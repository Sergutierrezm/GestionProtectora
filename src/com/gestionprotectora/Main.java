package com.gestionprotectora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.gestionprotectora.dao.AnimalDAO;
import com.gestionprotectora.model.Animal;
import com.gestionprotectora.util.Menu;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Conexion ok");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT 1");

            if (rs.next()) {
                System.out.println("Consulta OK:" + rs.getInt(1));
            }


        } catch (Exception e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }


        int opcionPrincipal;

        do {
            opcionPrincipal = Menu.menuPrincipal();

            switch (opcionPrincipal) {
                case 1:
                    gestionarAnimales();
                case 2:
                    gestionarAdoptantes();
                case 3:
                    gestionarAdopciones();
                case 0:
                    System.out.println("Saliendo del programa");
                default:
                    System.out.println("Opción no valida");
            }

        } while (opcionPrincipal != 0);

    }

    private static void gestionarAnimales() {
        Scanner sc = new Scanner(System.in);
        AnimalDAO animalDAO = new AnimalDAO();
        int opcion;
        do {
            opcion = Menu.menuAnimales();
            switch (opcion) {
                case 1: { //Añadir animal
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.println("Especie");
                    String especie = sc.nextLine();

                    System.out.println("Edad");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    Animal animal = new Animal(0, nombre, especie, edad, false);
                    animalDAO.insertarAnimal(animal);
                    System.out.println("Animal registrado");
                    break;

                }
                case 2: { // Listar todos los animales
                    List<Animal> animales = animalDAO.listarAnimales();

                    for (Animal a : animales) {
                        System.out.println(
                                a.getId() + " - " +
                                        a.getNombre() + " (" +
                                        a.getEspecie() + ") edad: " +
                                        a.getEdad() + " " + "años " + " Adoptado: " +
                                        a.isAdoptado()

                        );

                    }
                    break;
                }

                case 3: { //Listar animales disponibles
                    List<Animal> animales = animalDAO.listarAnimalesDisponibles();

                    if (animales.isEmpty()) {
                        System.out.println("No hay animales disponibles");
                    } else {
                        for (Animal a : animales) {
                            System.out.println(
                                    a.getId() + " - " +
                                            a.getNombre() + " (" +
                                            a.getEspecie() + ") edad: " +
                                            a.getEdad() + " " + "años " + " Adoptado: " +
                                            a.isAdoptado()
                            );
                        }
                    }
                    break;

                }
                case 4: { //Cambiar estado a adoptado
                    System.out.println("Introduce el ID del animal a adoptar:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean actualizado = animalDAO.marcarComoAdoptado(id);

                    if (actualizado) {
                        System.out.println("Animal marcado como adoptado");
                    } else {
                        System.out.println("No existe ningun animal con ese ID");
                    }
                    break;
                }

                case 5: { //Cambiar estado a no adoptado
                    System.out.println("Introduce el ID del animal");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean ok = animalDAO.marcarComoNoAdoptado(id, false);

                    if (ok) {
                        System.out.println("Animal marcado como no adoptado");
                    } else {
                        System.out.println("No se encontro el animal indicado");
                    }
                    break;

                }

                case 6: { //Eliminar animal
                    System.out.println("Introduce el ID del animal que quieres eliminar");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean eliminado = animalDAO.eliminarAnimal(id);

                    if (eliminado) {
                        System.out.println("Animal eliminado");
                    } else {
                        System.out.println("No sé encontró el animal indicado");
                    }
                    break;

                }
                case 0:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opción no valida");

            }
        } while (opcion != 0);
    }


    private static void gestionarAdoptantes() {
        int opcion;
        do {
            opcion = Menu.menuAdoptantes();
            switch (opcion) {
                case 1:
                    System.out.println("Añadir adoptante");
                case 2:
                    System.out.println("Listar adoptantes");
                case 0:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }


    private static void gestionarAdopciones() {
        int opcion;
        do {
            opcion = Menu.menuAdopciones();
            switch (opcion) {
                case 1:
                    System.out.println("Registrar adopción");
                case 2:
                    System.out.println("Ver adopciones");
                case 0:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
}