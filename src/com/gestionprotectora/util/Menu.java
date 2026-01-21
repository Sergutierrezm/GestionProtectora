package com.gestionprotectora.util;

import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    public static int menuPrincipal() {
        System.out.println("\n==============================");
        System.out.println("      GESTIÓN PROTECTORA");
        System.out.println("==============================");
        System.out.println("1. Gestion de animales");
        System.out.println("2. Gestion de adoptantes");
        System.out.println("3. Gestion de adopciones");
        System.out.println("0. Salir");
        System.out.println("Elige una opcion");

        return leerOpcion();
    }


    public static int menuAnimales(){
        System.out.println("\n--- Gestión de animales ---");
        System.out.println("1. Añadir animal");
        System.out.println("2. Listar todos los animales");
        System.out.println("3. Listar animales disponibles");
        System.out.println("4. Cambiar estado si adoptado");
        System.out.println("5. Cambiar estado no adoptado");
        System.out.println("6. Eliminar animal");
        System.out.println("0. Volver al menu principal");
        System.out.println("Elige una opcion");

        return leerOpcion();
    }

    public static int menuAdoptantes(){
        System.out.println("\n--- Gestión de adoptantes ---");
        System.out.println("1. Añadir adoptante");
        System.out.println("2. Listar adoptante");
        System.out.println("0. Volver");
        System.out.println("Elige una opcion");

        return leerOpcion();

    }

    public static int menuAdopciones(){
        System.out.println("\n--- Gestión de adopciones ---");
        System.out.println("1. Registrar adopcion");
        System.out.println("2. Ver adopciones");
        System.out.println("0. Volver");
        System.out.println("Elige una opcion");

        return leerOpcion();

    }


    private static int leerOpcion() {
        while(!sc.hasNextInt()){
            System.out.println("Opcion invalida. introduce un numero");
            sc.next();
        }
        return sc.nextInt();
    }

}



