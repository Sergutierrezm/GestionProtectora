package com.gestionprotectora.model;

public class Adoptante {
    private int id;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;

    public Adoptante(int id, String nombre, String dni, String telefono, String email, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDni(){
        return dni;
    }

    public void SetDni(String dni){
        this.dni= dni;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}
