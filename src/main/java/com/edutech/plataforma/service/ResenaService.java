package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.ResenaDTO;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Resena;
import com.edutech.plataforma.repository.CursoRepository;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.PersonaRepository;
import com.edutech.plataforma.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public String publicarReseña(String rut, String siglas, Resena resena){

        if(!estudianteRepository.existsByPersonaRut(rut)){
            return "Rut incorrecto";
        }
        if(!cursoRepository.existsById(siglas)){
            return "Curso no encontrado";
        }
        String nombre = estudianteRepository.findByPersonaRut(rut).getPersona().getNombre();
        resena.setNombre(nombre);
        List<Resena> resenas = resenaRepository.findAll();
        for (Resena resena2 : resenas) {
            if(resena2.getNombre().equals(resena.getNombre())){
                return "Ya se publico una resena antes";
            }
        }
        Curso curso = cursoRepository.findById(siglas).get();
        resena.setCurso(curso);
        resenaRepository.save(resena);

        return "Resena publicada";
        //Patricio
    }

    public List<ResenaDTO> listarResenas(String rut, String siglas){
        List<Resena> resenas = new ArrayList<>();
        List<ResenaDTO> resenasDTO = new ArrayList<>();
        if(!personaRepository.existsById(rut)){
            Resena ren = new Resena();
            ren.setDescripcion("Usuario invalido");
            resenas.add(ren);
            return resenasDTO;
        }
        if(!cursoRepository.existsById(siglas)){
            Resena ren = new Resena();
            ren.setDescripcion("Curso invalido");
            resenas.add(ren);
            return resenasDTO;
        }
        resenas = resenaRepository.findAll();
        for (Resena resena : resenas) {
            if(resena.getCurso().getSiglas().equals(siglas)){
                ResenaDTO rDto = new ResenaDTO();
                rDto.setDescripcion(resena.getDescripcion());
                rDto.setNombre(resena.getNombre());
                resenasDTO.add(rDto);
            }
        }
        return resenasDTO;
        //Patricio
    }
}
