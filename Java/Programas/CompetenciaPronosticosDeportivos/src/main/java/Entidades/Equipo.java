package Entidades;
public class Equipo{
    private final String nombre;
    public Equipo(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

}
