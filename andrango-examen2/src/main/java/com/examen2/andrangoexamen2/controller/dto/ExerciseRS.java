package com.examen2.andrangoexamen2.controller.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseRS implements Serializable {
    private String name;
    private Integer age;
    private List<String> fruits;
}
