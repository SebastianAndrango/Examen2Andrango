package com.examen2.andrangoexamen2.controller.mapper;

import com.examen2.andrangoexamen2.controller.dto.ExerciseRQ;
import com.examen2.andrangoexamen2.model.Exercise;

public class ExerciseMapper {

    public static Exercise mapRQ(ExerciseRQ exerciseRQ) {
        return Exercise.builder()
                .name(exerciseRQ.getName())
                .age(exerciseRQ.getAge())
                .animals(exerciseRQ.getAnimals())
                .fruits(exerciseRQ.getFruits()).build();
    }

}
