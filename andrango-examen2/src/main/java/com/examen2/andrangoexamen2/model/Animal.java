package com.examen2.andrangoexamen2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
    private String name;
    private Integer legs;
}