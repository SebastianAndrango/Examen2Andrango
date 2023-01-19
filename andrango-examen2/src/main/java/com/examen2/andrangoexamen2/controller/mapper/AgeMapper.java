package com.examen2.andrangoexamen2.controller.mapper;

import com.examen2.andrangoexamen2.controller.dto.RSAge;
import com.examen2.andrangoexamen2.model.Exercise;

public class AgeMapper {

    public static RSAge map(Exercise exercise) {
        return RSAge.builder()
                .name(exercise.getName())
                .age(exercise.getAge())
                .fruit(exercise.getFruits())
                .build();
    }

}