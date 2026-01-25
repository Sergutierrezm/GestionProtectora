package com.gestionprotectora.dao;

import com.gestionprotectora.model.Adoptante;
import com.gestionprotectora.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptanteDAO {

    //INSERTAR ANIMAL

    public void insertarAdoptante(Adoptante adoptante) {
        String sql = "INSERT INTO Adoptante (nombre, dni, telefono, email, direccion) VALUES (?, ?, ? , ? , ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, adoptante.getNombre());
            ps.setString(2, adoptante.getDni());
            ps.setString(3, adoptante.getTelefono());
            ps.setString(4, adoptante.getEmail());
            ps.setString(5, adoptante.getDireccion());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //Listar todos los adoptantes

    public List<Adoptante> listarAdoptantes() {
        List<Adoptante> adoptantes = new ArrayList<>();
        String sql = "SELECT * FROM adoptante";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Adoptante adoptante = new Adoptante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion")
                );
                adoptantes.add(adoptante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptantes;
    }

    //Filtrar por ID
    public Adoptante buscarPorId(int id) {
        String sql = "SELECT * FROM adoptante WHERE id = ?";
        Adoptante adoptante = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                adoptante = new Adoptante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptante;

    }

    public boolean eliminarAdoptante (int idAdoptante) {
        String sql = "DELETE FROM Adoptante WHERE id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAdoptante);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
