package com.example.sistemaedu.logica;

import com.example.sistemaedu.bd.JPA.EstudianteJPA;
import com.example.sistemaedu.bd.ORM.EstudianteORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteService {

    private final EstudianteJPA estudianteJPA;
    public boolean guardarEstudiante(Long id,String nombre, String genero, Integer edad, String carrera, String email, Integer semestre, Float promedio){
        if (promedio < 0 || promedio >5 ){
            throw new IllegalArgumentException("no se permite un promedio mayor a 5 o menor a 0");
        }
        EstudianteORM nuevoEstudiante =new EstudianteORM();
        nuevoEstudiante.setId(id);
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setGenero(genero);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setCarrera(carrera);
        nuevoEstudiante.setEmail(email);
        nuevoEstudiante.setSemestre(semestre);
        nuevoEstudiante.setPromedio(promedio);
        estudianteJPA.save(nuevoEstudiante);
        return true;
    }
}
