package com.workintech.fswebs17d1.entity;

public class Animal {
    private String name;
    private String id;

    public Animal(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
