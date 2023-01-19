package com.examen2.andrangoexamen2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen2.andrangoexamen2.model.Animal;
import com.examen2.andrangoexamen2.model.Exercise;
import com.examen2.andrangoexamen2.repository.ExerciseRepo;

@Service
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;

    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public List<Exercise> findAllExercisesByAge(Integer age) {

        List<Exercise> opExercise = exerciseRepo.findByAge(age);

        // AQUI VA TODA LA LOGICA DE NEGOCIO
        /*
         * if(opExercise.size() > 0){
         * return opExercise;
         * }else {
         * return null;
         * }
         */

        return opExercise;
    }

    public void saveExercise(Exercise exercise) {
        try {
            exerciseRepo.save(
                    Exercise.builder()
                            .name(exercise.getName())
                            .age(exercise.getAge())
                            .fruits(
                                    exercise.getFruits())
                            .animals(
                                    exercise.getAnimals())
                            .build());
        } catch (Exception e) {
            throw e;
        }

    }
}
