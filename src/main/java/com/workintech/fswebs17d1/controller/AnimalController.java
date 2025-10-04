package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    Map<Integer, Animal> animal = new HashMap<>();
    @GetMapping("/workintech/animal")
    public List<Animal> getALlAnimals() {
        return new ArrayList<>(animal.values());
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animal.get(id);
    }

    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestParam int id, @RequestParam String name) {
        Animal newAnimal = new Animal(name, String.valueOf(id));
        animal.put(id, newAnimal);
        return newAnimal;
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        if (animal.containsKey(id)) {
            Animal newAnimal = new Animal(updatedAnimal.getId(), updatedAnimal.getName());
            animal.put(id, newAnimal);
            return newAnimal;
        }
        return null;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public void deleteAnimal(@PathVariable int id) {
        if (animal.containsKey(id)) {
            animal.remove(id);
        } else {
            throw new RuntimeException("This id number doesn't exists.");
        }
    }
}
