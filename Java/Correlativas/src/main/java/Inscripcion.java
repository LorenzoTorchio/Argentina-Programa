import java.util.Date;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(){
        Date fecha = new Date(System.currentTimeMillis());
    }



    public boolean aprobada(){
        return true;
    }
}
