package com.gestionprotectora.model;

import java.time.LocalDate;

public class Adopcion {
    private int id;
    private Animal animal;
    private Adoptante adoptante;
    private LocalDate fechaAdopcion;

    public Adopcion(Animal animal, Adoptante adoptante){
        this.animal = animal;
        this.adoptante = adoptante;
        this.fechaAdopcion = LocalDate.now();
    }

    public int getId(){
        return id;
    }

    public Animal getAnimal(){
        return animal;
    }

    public Adoptante getAdoptante(){
        return adoptante;
    }

    public LocalDate getFechaAdopcion(){
        return fechaAdopcion;
    }

}
