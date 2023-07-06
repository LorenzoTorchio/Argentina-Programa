package Entidades;

import java.util.ArrayList;

public class Persona {
    private final String nombre;
    private int puntos;
    private final ArrayList<Pronostico> pronosticos;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }
    public String getNombre(){
        return this.nombre;
    }

    public void addPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }
    public ArrayList<Pronostico> getPronosticos(){
        return this.pronosticos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumaPuntos(int puntos) {
        this.puntos += puntos;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
