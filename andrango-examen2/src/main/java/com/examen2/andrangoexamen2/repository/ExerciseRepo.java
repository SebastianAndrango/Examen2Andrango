package com.examen2.andrangoexamen2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen2.andrangoexamen2.model.Exercise;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepo extends MongoRepository<Exercise, String> {

    Optional<Exercise> findByName(String name);

    List<Exercise> findByAge(Integer age);

    List<Exercise> findByAnimalsName(String name);

    List<Exercise> findByNameAndAgeBetween(String name, Integer from, Integer to);
}