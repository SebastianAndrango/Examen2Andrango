package com.examen2.andrangoexamen2.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class RSAge implements Serializable {
    private String name;
    private Integer age;
    private List<String> fruit;
}