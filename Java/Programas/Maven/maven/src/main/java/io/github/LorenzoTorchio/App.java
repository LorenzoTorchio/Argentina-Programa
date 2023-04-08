package io.github.LorenzoTorchio;

import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String x = "";
        System.out.println("Programa para crear una lista de personas");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        while(x.equals("")) {
            Persona persona = new Persona();
            System.out.println("ingrese un nombre");
            persona.setNombre(teclado.nextLine());
            System.out.println("ingrese un apellido");
            persona.setApellido(teclado.nextLine());
            System.out.println("ingrese un fecha de nacimiento(dd/mm/aaaa)");
            persona.setFecha(teclado.nextLine());
            personas.add(persona);
            System.out.println("[ENTER] = SKIP");
            System.out.println("  [X]   = VER LISTA");
            x = teclado.nextLine();
            if (!x.equals("")){
                //hacer esto con Getters
                int index = 1;
                for (Persona i : personas) {
                    System.out.print(index + ") ");
                    System.out.println(i);
                    index++;
                }
            }
            System.out.println("[ENTER] = SEGUIR AÑADIENDO");
            System.out.println("  [X]   = SALIR");
            x = teclado.nextLine();
        }
    }
    static class Persona{
        @Setter private String nombre;
        @Setter private String apellido;
        @Setter private String fecha;

        @Override
        public String toString() {
            return nombre + " " + apellido + " [" + fecha + "]";
        }
    }
}