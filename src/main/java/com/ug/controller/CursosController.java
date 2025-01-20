package com.ug.controller;
import java.util.ArrayList;
import java.util.List;

import com.ug.model.Curso;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CursosController {
    
    private List<Curso> cursos;
    
    public void agregarCurso(Curso curso){
        cursos.add(curso);
        System.out.println("Curso agregado correctamente!");
    }
    
    public void eliminarCurso(int idCurso){
        cursos.removeIf((c) -> c.getIdCurso() == idCurso);
        System.out.println("Curso eliminado correctamente!");
    }

    public void modificarCurso(Curso curso, Curso cursoNuevo){
        cursos.set(cursos.indexOf(curso), cursoNuevo);
        System.out.println("Curso modificado correctamente!");
    }
    
    public Curso buscarCurso(int idCurso){
        return cursos.stream().filter(((c) -> c.getIdCurso() == idCurso)).findFirst().orElse(null);
    }
    
    public List<Curso> obtenerCursos(){
        return new ArrayList<>(cursos);
    }
    
    public void mostrarCursos(){
        for(Curso curso : cursos){
            System.out.println(curso);
        }
    }
}
