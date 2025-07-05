package com.edutech.plataforma;

import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.repository.RolRepository;
import com.edutech.plataforma.service.RolService;

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
class RolServiceTest {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolService rolService;

    @Test // Patricio
    void almacenar() {
        Rol rol = new Rol();
        rol.setId(1);
        rol.setRol("ADMIN");

        String resultado = rolService.almacenar(rol);

        verify(rolRepository).save(rol);
        assertEquals("Ok", resultado);
    }

    @Test // Patricio
    void obtenerRoles() {
        Rol r1 = new Rol();
        Rol r2 = new Rol();
        List<Rol> lista = Arrays.asList(r1, r2);

        when(rolRepository.findAll()).thenReturn(lista);

        List<Rol> resultado = rolService.obtenerRoles();

        assertEquals(2, resultado.size());
        assertSame(lista, resultado);
    }

    @Test // Patricio
    void encontrar() {
        Rol rol = new Rol();
        rol.setRol("USER");

        when(rolRepository.findById(1)).thenReturn(Optional.of(rol));

        Rol resultado = rolService.encontrar(1);

        assertEquals("USER", resultado.getRol());
    }

    @Test // Patricio
    void existe() {
        when(rolRepository.findById(1)).thenReturn(Optional.of(new Rol()));

        assertTrue(rolService.existe(1));
    }

    @Test // Patricio
    void noExiste() {
        when(rolRepository.findById(999)).thenReturn(Optional.empty());

        assertFalse(rolService.existe(999));
    }
}