package com.gestionprotectora.dao;

import com.gestionprotectora.model.Animal;
import com.gestionprotectora.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalDAO {

//INSERTAR ANIMAL
    public void insertarAnimal(Animal animal){
        String sql = "INSERT INTO animal (nombre, especie, edad, adoptado) VALUES (?, ?, ?, ?)";

        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, animal.getNombre());
            ps.setString(2, animal.getEspecie());
            ps.setInt(3, animal.getEdad());
            ps.setBoolean(4, animal.isAdoptado());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //LISTAR ANIMALES

    public List<Animal> listarAnimales(){
        List<Animal> animales = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)){

            while(rs.next()){
                Animal animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getInt("edad"),
                        rs.getBoolean("adoptado")

                );
                animales.add(animal);
            }
            }catch(SQLException e) {
            e.printStackTrace();

        }
        return animales;
    }




}
