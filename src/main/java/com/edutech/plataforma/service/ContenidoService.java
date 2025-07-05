package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.Contenido;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.repository.ContenidoRepository;
import com.edutech.plataforma.repository.CursoRepository;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.PersonaRepository;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public String subirContenido(String rut, Contenido contenido, String siglas){

        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno profesor = internoRepository.findByPersonaRut(rut);
        if(!(profesor.getRol().getId()==3)){
            return "No posee el rol necesario";
        }
        if(!cursoRepository.existsById(siglas)){
            return "Curso no existe";
        }
        List<Contenido> lista = contenidoRepository.findAll();
        for (Contenido cont : lista) {
            if(cont.getNombre().equals(contenido.getNombre())
                && cont.getCurso().getSiglas().equals(siglas)){
                return "Contenido ya cargado";
            }
        }
        Curso curso = cursoRepository.findById(siglas).get();
        contenido.setCurso(curso);
        contenidoRepository.save(contenido);
        return "Contenido subido";
        //Patricio
    }
    public String aprovarContenido(String rut, int id){

        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno gerente = internoRepository.findByPersonaRut(rut);
        if(!(gerente.getRol().getId()==2)){
            return "No posee el rol necesario";
        }
        if(!contenidoRepository.existsById(id)){
            return "Contenido no existe";
        }
        Contenido contenido = contenidoRepository.findById(id).get();
        contenido.setAprovado(true);
        contenidoRepository.save(contenido);
        return "Contenido aprovado";
        //Patricio
    }

    public List<Contenido> mostrarContenido(String rut){
        List<Contenido> contenidos = new ArrayList<>();
        if(!personaRepository.findById(rut).isPresent()){
            return contenidos;
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return contenidos;
        }
        Interno gerente = internoRepository.findByPersonaRut(rut);
        if(!(gerente.getRol().getId()==2)){
            return contenidos;
        }
        contenidos = contenidoRepository.findAll();
        return contenidos;
        //Patricio
    }

    public List<Contenido> mostrarContenidoPorCurso(String rut, String sigla){
        List<Contenido> contenidos = new ArrayList<>();
        if(!personaRepository.findById(rut).isPresent()){
            return contenidos;
        }
        if(!cursoRepository.existsById(sigla)){
            return contenidos;
        }
        contenidos = contenidoRepository.findAll();
        List<Contenido> contenidosMostrar = new ArrayList<>();
        for (Contenido contenido : contenidos) {
            if(estudianteRepository.existsByPersonaRut(rut)){
                if(contenido.getAprovado() && contenido.getCurso().getSiglas().equals(sigla)){
                    contenidosMostrar.add(contenido);
                }
            }
            if(internoRepository.existsByPersonaRut(rut)){
                if(contenido.getCurso().getSiglas().equals(sigla)){
                    contenidosMostrar.add(contenido);
                }
            }
        }
        return contenidosMostrar;
        //Patricio
    }
}
