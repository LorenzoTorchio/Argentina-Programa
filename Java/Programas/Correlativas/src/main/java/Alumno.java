import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;


    public Alumno(String nombre, String legajo){
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }
    public String getLegajo() {
        return legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void addMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString(){
        return this.getNombre();
    }

}
