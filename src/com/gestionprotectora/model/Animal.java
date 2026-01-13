package com.gestionprotectora.model;

public class Animal {

    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private boolean adoptado;

    public Animal(int id, String nombre, String especie, int edad, boolean adoptado){
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.adoptado = adoptado;
    }

    public int  getId() {
        return id;
    }

    public String getNombre() {
        return nombre;

    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEspecie(){
        return especie;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    public boolean isAdoptado(){
        return adoptado;
    }

    public void setAdoptado(boolean adoptado){
        this.adoptado = adoptado;
    }
}
