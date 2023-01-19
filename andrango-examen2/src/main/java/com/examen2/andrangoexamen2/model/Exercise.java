package com.examen2.andrangoexamen2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Document(collection = "exercises")
public class Exercise {
    @Id
    private String id;

    private String name;

    private Integer age;

    private List<String> fruits;

    private List<Animal> animals;

    @Version
    private Long version;
}