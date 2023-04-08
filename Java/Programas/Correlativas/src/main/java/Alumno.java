import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre){
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }
}
