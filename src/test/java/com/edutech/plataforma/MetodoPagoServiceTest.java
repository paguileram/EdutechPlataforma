package com.edutech.plataforma;

import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.repository.MetodoPagoRepository;
import com.edutech.plataforma.service.MetodoPagoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MetodoPagoServiceTest {

    @Mock
    private MetodoPagoRepository metodoPagoRepository;

    @InjectMocks
    private MetodoPagoService metodoPagoService;

    @Test // Patricio
    void almacenar() {
        MetodoPago metodo = new MetodoPago();
        metodo.setId(1);
        metodo.setNombre("Tarjeta");

        String resultado = metodoPagoService.almacenar(metodo);

        verify(metodoPagoRepository).save(metodo);
        assertEquals("Ok", resultado);
    }

    @Test // Patricio
    void obtenerMetodoPagos() {
        MetodoPago m1 = new MetodoPago();
        MetodoPago m2 = new MetodoPago();
        List<MetodoPago> lista = Arrays.asList(m1, m2);

        when(metodoPagoRepository.findAll()).thenReturn(lista);

        List<MetodoPago> resultado = metodoPagoService.obtenerMetodoPagos();

        assertEquals(2, resultado.size());
        assertSame(lista, resultado);
    }

    @Test // Patricio
    void encontrar() {
        MetodoPago metodo = new MetodoPago();
        metodo.setNombre("Transferencia");

        when(metodoPagoRepository.findById(1)).thenReturn(Optional.of(metodo));

        MetodoPago resultado = metodoPagoService.encontrar(1);

        assertEquals("Transferencia", resultado.getNombre());
    }

    @Test // Patricio
    void existe() {
        when(metodoPagoRepository.findById(1)).thenReturn(Optional.of(new MetodoPago()));

        assertTrue(metodoPagoService.existe(1));
    }

    @Test // Patricio
    void noExiste() {
        when(metodoPagoRepository.findById(999)).thenReturn(Optional.empty());

        assertFalse(metodoPagoService.existe(999));
    }
}