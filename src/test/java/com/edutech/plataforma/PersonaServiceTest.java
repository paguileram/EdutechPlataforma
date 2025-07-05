package com.edutech.plataforma;

import com.edutech.plataforma.DTO.LoginDTO;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.PersonaRepository;
import com.edutech.plataforma.service.PersonaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    @Test // Cristobal
    void registrarPersona() {
        Persona persona = new Persona();
        persona.setRut("11.111.111-1");

        when(personaRepository.findById(persona.getRut())).thenReturn(Optional.empty());

        String resultado = personaService.registrarPersona(persona);

        verify(personaRepository).save(persona);
        assertEquals("11.111.111-1", resultado);
    }

    @Test // Cristobal
    void registrarPersonaExistente() {
        Persona persona = new Persona();
        persona.setRut("11.111.111-1");

        when(personaRepository.findById(persona.getRut()))
                .thenReturn(Optional.of(persona));

        String resultado = personaService.registrarPersona(persona);

        verify(personaRepository, never()).save(any());
        assertEquals("Persona ya inscrita", resultado);
    }

    @Test // Cristobal
    void loginUsuarioIncorrecto() {
        LoginDTO login = new LoginDTO();
        login.setRut("11.111.111-1");
        login.setContrasena("1234");

        when(personaRepository.existsById(login.getRut())).thenReturn(false);

        String resultado = personaService.login(login);

        assertEquals("Usuario o contraseña incorrectos", resultado);
    }

    @Test // Cristobal
    void loginContrasenaIncorrecta() {
        LoginDTO login = new LoginDTO();
        login.setRut("11.111.111-1");
        login.setContrasena("wrongpass");

        Persona persona = new Persona();
        persona.setRut("11.111.111-1");
        persona.setContrasena("correctpass");

        when(personaRepository.existsById(login.getRut())).thenReturn(true);
        when(personaRepository.findById(login.getRut())).thenReturn(Optional.of(persona));

        String resultado = personaService.login(login);

        assertEquals("Usuario o contraseña incorrectos", resultado);
    }

    @Test // Cristobal
    void loginDatosCorrectos() {
        LoginDTO login = new LoginDTO();
        login.setRut("11.111.111-1");
        login.setContrasena("1234");

        Persona persona = new Persona();
        persona.setRut("11.111.111-1");
        persona.setContrasena("1234");

        when(personaRepository.existsById(login.getRut())).thenReturn(true);
        when(personaRepository.findById(login.getRut())).thenReturn(Optional.of(persona));

        String resultado = personaService.login(login);

        assertEquals("correcto", resultado);
    }

    @Test // Cristobal
    void listar() {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        List<Persona> personas = Arrays.asList(persona1, persona2);

        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> resultado = personaService.listar();

        assertEquals(2, resultado.size());
        assertSame(personas, resultado);
    }

    @Test // Cristobal
    void encontrar() {
        Persona persona = new Persona();
        persona.setRut("11.111.111-1");

        when(personaRepository.findById("11.111.111-1")).thenReturn(Optional.of(persona));

        Persona resultado = personaService.encontrar("11.111.111-1");

        assertEquals("11.111.111-1", resultado.getRut());
    }

    @Test // Cristobal
    void PersonaExistente() {
        when(personaRepository.findById("11.111.111-1")).thenReturn(Optional.of(new Persona()));

        assertTrue(personaService.existe("11.111.111-1"));
    }

    @Test // Cristobal
    void PersonaNoExistente() {
        when(personaRepository.findById("11.111.111-1")).thenReturn(Optional.empty());

        assertFalse(personaService.existe("11.111.111-1"));
    }
}