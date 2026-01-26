package com.gestionprotectora.dao;

import com.gestionprotectora.DBConnection;
import com.gestionprotectora.model.Adopcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> listarAdopciones() {
        List<String> adopciones = new ArrayList<>();

        String sql = """
                SELECT
                    a.id AS adopcion_id,
                    an.nombre AS animal_nombre,
                    an.especie AS especie,
                    ad.nombre AS adoptante_nombre,
                    a.fecha_adopcion AS fecha
                    FROM adopcion a
                    JOIN animal an ON a.animal_id = an.id
                    JOIN adoptante ad ON a.adoptante_id = ad.id
                """;

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()){
                String linea =
                        "Adopcion" + rs.getInt("adopcion_id") +
                         " Animal: " + rs.getString("animal_nombre") +
                         " " + rs.getString("especie") + " " +
                         "Adoptante: " + rs.getString("Adoptante_nombre") +
                         " Fecha: " + rs.getDate("fecha");
                adopciones.add(linea);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return adopciones;


    }

}
