package com.crudapi.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "birds")

public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int birdId;

    @Column(nullable = false)
    private String name;
    private String description;
    private String family;
    private String species;

    public Bird(int birdId, String name, String family, String species, String description){
        this.birdId = birdId;
        this.name = name;
        this.family = family;
        this.species = species;
        this.description = description;
    }

    public Bird(){
        //no-argument constructor
    }

    public int getBirdId() {
        return birdId;
    }

    public void setBirdId(int birdId) {
        this.birdId = birdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family){
        this.family = family;
    }

    public String getFamily(){
        return family;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies(){
        return species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
