import java.util.ArrayList;
import java.util.HashSet;

public class Materia {
    private String nombre;
    private ArrayList<Materia> correlativas;


    public Materia(String nombre){
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setCorrelativa(Materia materia){
        this.correlativas.add(materia);
    }

    public boolean puedeCursar(Alumno alumno){
        if(this.correlativas == null){
            return true;
        }
        return new HashSet<>(alumno.getMateriasAprobadas()).containsAll(this.correlativas);
    }

    @Override
    public String toString(){
        return this.getNombre();
    }
}
