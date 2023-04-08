import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<Materia> correlativas;

    public Materia(String nombre){
        this.nombre = nombre;
    }

    public void setCorrelativa(Materia materia){
        this.correlativas.add(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public static int getIndex(String materia, ArrayList<Materia> materias){
        int indice = 0;
        for(Materia x : materias){
            if(x.getNombre().equals(materia)){
                break;
            }
            indice++;
        }
        return indice;
    }

    public boolean puedeCursar(Alumno alumno){
        return true;
    }
}
