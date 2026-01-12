package com.gestionprotectora;

import com.gestionprotectora.util.Menu;
public class Main {
    public static void main(String[] args) {

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

        private static void gestionarAnimales(){
            int opcion;
            do{
            opcion = Menu.menuAnimales();
            switch(opcion){
                case 1: System.out.println("Añadir animal");
                case 2: System.out.println("Listar animales");
                case 3: System.out.println("Listar disponibles");
                case 4: System.out.println("Cambiar estado");
                case 0: System.out.println("Volviendo al menu principal");
                default: System.out.println("Opción no valida");

            }
            }while (opcion != 0);
            }


        private static void gestionarAdoptantes(){
        int opcion;
        do{
            opcion = Menu.menuAdoptantes();
            switch(opcion){
                case 1: System.out.println("Añadir adoptante");
                case 2: System.out.println("Listar adoptantes");
                case 0: System.out.println("Volviendo al menu principal");
                default: System.out.println("Opcion no valida");
            }
        } while(opcion != 0);
        }


        private static void gestionarAdopciones(){
        int opcion;
        do{
            opcion = Menu.menuAdopciones();
            switch(opcion){
                case 1: System.out.println("Registrar adopción");
                case 2: System.out.println("Ver adopciones");
                case 0: System.out.println("Volviendo al menu principal");
                default: System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        }
}