package com.edutech.plataforma;

import com.edutech.plataforma.DTO.InternoDTO;
import com.edutech.plataforma.DTO.InternoRegisDTO;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.service.InternoService;
import com.edutech.plataforma.service.PersonaService;
import com.edutech.plataforma.service.RolService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InternoServiceTest {

    @Mock
    private InternoRepository internoRepository;

    @Mock
    private PersonaService personaService;

    @Mock
    private RolService rolService;

    @InjectMocks
    private InternoService internoService;

    @Test // Patricio
    void registrarInterno() {
        InternoRegisDTO dto = new InternoRegisDTO();
        dto.setRut("22.222.222-2");

        when(personaService.existe(dto.getRut())).thenReturn(true);

        String resultado = internoService.registrarInterno(dto);

        assertEquals("Persona o Interno ya registrado en el sistema", resultado);
    }

    @Test // Patricio
    void registrarInternoRol() {
        InternoRegisDTO dto = new InternoRegisDTO();
        dto.setRut("22.222.222-2");
        dto.setRol(1);

        when(personaService.existe(dto.getRut())).thenReturn(false);
        when(rolService.existe(dto.getRol())).thenReturn(false);

        String resultado = internoService.registrarInterno(dto);

        assertEquals("Rol no existente", resultado);
    }

    @Test // Patricio
    void registrarInternoDatosValidos() {
        InternoRegisDTO dto = new InternoRegisDTO();
        dto.setRut("22.222.222-2");
        dto.setNombre("Pedro");
        dto.setCorreo("pedro@mail.com");
        dto.setContrasena("1234");
        dto.setDireccion("Calle 1");
        dto.setFecha("01-01-2024");
        dto.setRol(1);
        dto.setDescripcion("Backend Dev");
        dto.setEspecialidad("Java");

        Rol rol = new Rol();
        rol.setRol("ADMIN");

        when(personaService.existe(dto.getRut())).thenReturn(false);
        when(rolService.existe(dto.getRol())).thenReturn(true);
        when(rolService.encontrar(dto.getRol())).thenReturn(rol);

        String resultado = internoService.registrarInterno(dto);

        verify(internoRepository).save(any(Interno.class));
        assertEquals("Interno registrado 22.222.222-2 - ADMIN", resultado);
    }

    @Test // Patricio
    void modificarInterno() {
        String rut = "22.222.222-2";

        when(internoRepository.existsByPersonaRut(rut)).thenReturn(false);

        String resultado = internoService.modificarInterno(rut, new InternoDTO());

        assertEquals("Usuario no encontrado", resultado);
    }

    @Test // Patricio
    void modificarInternoDatosValidos() {
        String rut = "22.222.222-2";

        InternoDTO dto = new InternoDTO();
        dto.setCorreo("nuevo@mail.com");
        dto.setDescripcion("DevOps");
        dto.setEspecialidad("Cloud");
        dto.setDireccion("Nueva dirección");
        dto.setNombre("Nuevo Nombre");

        Persona persona = new Persona();
        persona.setCorreo("old@mail.com");

        Interno interno = new Interno();
        interno.setPersona(persona);

        when(internoRepository.existsByPersonaRut(rut)).thenReturn(true);
        when(internoRepository.findByPersonaRut(rut)).thenReturn(interno);

        String resultado = internoService.modificarInterno(rut, dto);

        verify(internoRepository).save(interno);
        assertEquals("Cambios realizados", resultado);
        assertEquals("nuevo@mail.com", persona.getCorreo());
        assertEquals("DevOps", interno.getDescripcion());
    }

    @Test // Patricio
    void listar() {
        Interno i1 = new Interno();
        Interno i2 = new Interno();
        List<Interno> lista = Arrays.asList(i1, i2);

        when(internoRepository.findAll()).thenReturn(lista);

        List<Interno> resultado = internoService.listar();

        assertEquals(2, resultado.size());
        assertSame(lista, resultado);
    }
}