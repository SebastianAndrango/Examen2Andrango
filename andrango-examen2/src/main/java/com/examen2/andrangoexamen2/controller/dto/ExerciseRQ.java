package com.examen2.andrangoexamen2.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.examen2.andrangoexamen2.model.Animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRQ implements Serializable {
    private String name;

    private Integer age;

    private List<String> fruits;

    private List<Animal> animals;
}
