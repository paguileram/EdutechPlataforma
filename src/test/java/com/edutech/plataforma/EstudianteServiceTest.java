package com.edutech.plataforma;

import com.edutech.plataforma.DTO.EstudianteDTO;
import com.edutech.plataforma.DTO.EstudianteRegisDTO;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.service.EstudianteService;
import com.edutech.plataforma.service.MetodoPagoService;
import com.edutech.plataforma.service.PersonaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @Mock
    private PersonaService personaService;

    @Mock
    private MetodoPagoService metodoPagoService;

    @InjectMocks
    private EstudianteService estudianteService;

    @Test // Cristobal
    void registrarEstudiante() {
        EstudianteRegisDTO dto = new EstudianteRegisDTO();
        dto.setRut("11.111.111-1");

        when(personaService.existe(dto.getRut())).thenReturn(true);

        String resultado = estudianteService.registrarEstudiante(dto);

        assertEquals("Persona o Estudiante ya registrado en el sistema", resultado);
    }

    @Test // Cristobal
    void registrarEstudianteMetodoPagoInvalido() {
        EstudianteRegisDTO dto = new EstudianteRegisDTO();
        dto.setRut("11.111.111-1");
        dto.setIdPago(123);

        when(personaService.existe(dto.getRut())).thenReturn(false);
        when(metodoPagoService.existe(dto.getIdPago())).thenReturn(false);

        String resultado = estudianteService.registrarEstudiante(dto);

        assertEquals("Metodo de pago invalido", resultado);
    }

    @Test // Cristobal
    void registrarEstudianteDatosCorrectos() {
        EstudianteRegisDTO dto = new EstudianteRegisDTO();
        dto.setRut("11.111.111-1");
        dto.setIdPago(123);
        dto.setNombre("Juan");
        dto.setContrasena("1234");
        dto.setCorreo("juan@mail.com");
        dto.setDireccion("Calle falsa");
        dto.setFecha("01-01-2024");

        MetodoPago metodoPago = new MetodoPago();
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1);

        when(personaService.existe(dto.getRut())).thenReturn(false);
        when(metodoPagoService.existe(dto.getIdPago())).thenReturn(true);
        when(metodoPagoService.encontrar(dto.getIdPago())).thenReturn(metodoPago);
        when(estudianteRepository.save(any(Estudiante.class))).thenAnswer(invocation -> {
            Estudiante est = invocation.getArgument(0);
            est.setId(1);
            return est;
        });

        String resultado = estudianteService.registrarEstudiante(dto);

        assertEquals("Estudiante Registrado 1", resultado);
    }

    @Test // Cristobal
    void modificarEstudiante() {
        String rut = "11.111.111-1";

        when(estudianteRepository.existsByPersonaRut(rut)).thenReturn(false);

        String resultado = estudianteService.modificarEstudiante(rut, new EstudianteDTO());

        assertEquals("Usuario no encontrado", resultado);
    }

    @Test // Cristobal
    void modificarEstudianteDatos() {
        String rut = "11.111.111-1";

        EstudianteDTO dto = new EstudianteDTO();
        dto.setCorreo("nuevo@correo.com");
        dto.setDireccion("Nueva dirección");
        dto.setNombre("Nuevo Nombre");
        dto.setIdPago(99);

        Persona persona = new Persona();
        persona.setNombre("Original");
        persona.setCorreo("original@mail.com");
        persona.setDireccion("Calle original");

        Estudiante estudiante = new Estudiante();
        estudiante.setPersona(persona);

        MetodoPago nuevoPago = new MetodoPago();

        when(estudianteRepository.existsByPersonaRut(rut)).thenReturn(true);
        when(estudianteRepository.findByPersonaRut(rut)).thenReturn(estudiante);
        when(metodoPagoService.encontrar(dto.getIdPago())).thenReturn(nuevoPago);

        String resultado = estudianteService.modificarEstudiante(rut, dto);

        verify(estudianteRepository).save(estudiante);
        assertEquals("Cambios realizados", resultado);
        assertEquals("Nuevo Nombre", persona.getNombre());
    }

    @Test // Cristobal
    void listar() {
        Estudiante e1 = new Estudiante();
        Estudiante e2 = new Estudiante();
        when(estudianteRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Estudiante> resultado = estudianteService.listar();

        assertEquals(2, resultado.size());
    }
}