package com.examen2.andrangoexamen2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen2.andrangoexamen2.controller.dto.ExerciseRQ;
import com.examen2.andrangoexamen2.controller.dto.RQAge;
import com.examen2.andrangoexamen2.controller.dto.RSAge;
import com.examen2.andrangoexamen2.controller.mapper.AgeMapper;
import com.examen2.andrangoexamen2.controller.mapper.ExerciseMapper;
import com.examen2.andrangoexamen2.model.Animal;
import com.examen2.andrangoexamen2.model.Exercise;
import com.examen2.andrangoexamen2.repository.ExerciseRepo;
import com.examen2.andrangoexamen2.service.ExerciseService;
import com.examen2.andrangoexamen2.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/exercise")
public class ExcersiceController {
    private final ExerciseRepo exerciseRepo; // Esto esta MAL, solo se hize por rapidez, no replicar NUNCA

    private final ExerciseService exerciseService; // Esto esta bien, al controlador solo se debe inyectar la clase de
                                                   // servicios

    public ExcersiceController(ExerciseRepo exerciseRepo, ExerciseService exerciseService) {
        this.exerciseRepo = exerciseRepo;
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Exercise> get() {
        return exerciseRepo.findAll();
    }

    @GetMapping(value = "/find")
    public Exercise getByName() {
        Optional<Exercise> exercise = exerciseRepo.findByName("David");
        return (exercise.isPresent()) ? exercise.get() : null;
    }

    @PutMapping(value = "/simple")
    public String update() {
        Optional<Exercise> opExercise = exerciseRepo.findByName("David");
        if (opExercise.isPresent()) {
            Exercise exercise = opExercise.get();
            exercise.setName("Enrique");
            exerciseRepo.save(exercise);
            return "Success";
        } else {
            return "Failure";
        }
    }

    @PutMapping(value = "/complex")
    public String updateComplex() {
        Optional<Exercise> opExercise = exerciseRepo.findByName("Enrique");
        if (opExercise.isPresent()) {
            Exercise exercise = opExercise.get();
            exercise.getFruits().add("Babaco");
            exercise.getAnimals().add(Animal.builder().name("Pato").legs(2).build());
            exerciseRepo.save(exercise);
            return "Success";
        } else {
            return "Failure";
        }
    }

    @GetMapping(value = "/inside")
    public Object getByInsideKey() {
        List<Exercise> opExercise = exerciseRepo.findByAnimalsName("vaca");

        if (opExercise.size() > 0) {
            return opExercise;
        } else {
            return "Failure";
        }
    }

    @GetMapping(value = "/between")
    public Object getByNameAndAges() {
        List<Exercise> opExercise = exerciseRepo.findByNameAndAgeBetween("Enrique", 30, 40);

        if (opExercise.size() > 0) {
            return opExercise;
        } else {
            return "Failure";
        }
    }

    /*
     * @GetMapping(value = "/{age}")
     * public ResponseEntity<RSAge> obtenerClientePorId(@PathVariable("age") Integer
     * age){
     * List <Exercise> exercise = this.exerciseService.findAllExercisesByAge(age);
     * List<Exercise> dbExercises =
     * exerciseService.findAllExercisesByAge(request.getAge());
     * if (exercise != null){
     * for (Exercise dbExercise : exercise) {
     * exercise = AgeMapper.map(exercise);
     * exercises.add(exercise);
     * }
     * return ResponseEntity.ok(exercises);
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     */

    /*
     * @GetMapping(value = "/age/{message}")
     * public ResponseEntity<Object> getByAge(
     * 
     * @PathVariable("message") String message,
     * 
     * @RequestBody RQAge request) {
     * // Se debe validar los datos de entrada
     * if (!Utils.hasAllAttributes(request)) {
     * throw new RuntimeException("Faltan parametros");
     * }
     * 
     * System.out.println("Varible Path ->" + message);
     * 
     * List<Exercise> dbExercises =
     * exerciseService.findAllExercisesByAge(request.getAge());
     * List<RSAge> exercises = new ArrayList<>();
     * RSAge exercise;
     * 
     * if (dbExercises.size() > 0) {
     * for (Exercise dbExercise : dbExercises) {
     * exercise = AgeMapper.map(dbExercise);
     * exercises.add(exercise);
     * }
     * return ResponseEntity.ok(exercises);
     * } else {
     * throw new RuntimeException("No se encontraron registros con esa edad");
     * }
     * }
     */

    /*
     * @PostMapping
     * public String save() {
     * exerciseRepo.save(
     * Exercise.builder()
     * .name("Juan")
     * .age(50)
     * .fruits(
     * List.of("aji", "naranja", "durazno"))
     * .animals(
     * List.of(
     * Animal.builder().name("perro").legs(4).build(),
     * Animal.builder().name("gato").legs(4).build()))
     * .build());
     * return "Success";
     * }
     */

    @PostMapping
    public ResponseEntity<String> createExercise(@RequestBody ExerciseRQ exerciseRQ) {
        System.out.println(exerciseRQ.toString());
        try {
            this.exerciseService.saveExercise(ExerciseMapper.mapRQ(exerciseRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}