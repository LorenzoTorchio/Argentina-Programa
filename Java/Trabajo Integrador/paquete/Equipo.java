package paquete;
public class Equipo{
    private String nombre;
    private String descripcion;
    public Equipo(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){ return this.descripcion;}
}
