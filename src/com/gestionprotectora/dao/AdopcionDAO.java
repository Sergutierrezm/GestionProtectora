package com.gestionprotectora.dao;

import com.gestionprotectora.DBConnection;
import com.gestionprotectora.model.Adopcion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdopcionDAO {

    public boolean registrarAdopcion(Adopcion adopcion){
        String sql = "INSERT INTO adopcion (animal_id, adoptante_id, fecha_adopcion) VALUES (?, ?, ?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, adopcion.getAnimal().getId());
            ps.setInt(2, adopcion.getAdoptante().getId());
            ps.setDate(3, Date.valueOf(adopcion.getFechaAdopcion()));

            return ps.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
