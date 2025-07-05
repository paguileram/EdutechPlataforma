package com.edutech.plataforma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.Codigo;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.repository.CodigoRepository;
import com.edutech.plataforma.repository.CursoRepository;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.PersonaRepository;

@Service
public class CodigoService {

    @Autowired
    private CodigoRepository codigoRepository;

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public String registrarCupon(String rut, Codigo codigo){
        
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
        codigoRepository.save(codigo);
        return "Codigo Creado "+codigo.getNombre();
        //Patricio
    }

    public String vincularCupon(String rut, String sigla, int id){
        
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
        if(!cursoRepository.existsById(sigla)){
            return "Curso no encontrado";
        }
        if(!codigoRepository.existsById(id)){
            return "Codigo no encontrado";
        }
        Curso curso = cursoRepository.findById(sigla).get();
        Codigo codigo = codigoRepository.findById(id).get();
        codigo.setCurso(curso);
        codigoRepository.save(codigo);
        return "Codigo "+codigo.getNombre()+" vinculado a "+sigla;
        //Patricio
    }

    public String aplicarCupon(String rut, String sigla, int id){
        
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if((internoRepository.existsByPersonaRut(rut))){
            return "Debe ser estudiante";
        }
        if(!cursoRepository.existsById(sigla)){
            return "Curso no encontrado";
        }
        if(!codigoRepository.existsById(id)){
            return "Codigo no encontrado";
        }
        Curso curso = cursoRepository.findById(sigla).get();
        Codigo codigo = codigoRepository.findById(id).get();
        return "Cupon "+codigo.getNombre()+" Aplicado en curso "+curso.getNombre()+"\nValor actual: "+Math.round((curso.getValor()*(codigo.getPorcentaje()/100)));
        //Patricio
    }
}
