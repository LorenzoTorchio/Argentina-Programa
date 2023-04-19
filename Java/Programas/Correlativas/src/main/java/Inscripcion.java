import java.util.Date;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia){
        this.alumno = alumno;
        this.materia = materia;
        Date fecha = new Date(System.currentTimeMillis());
    }

    public boolean aprobada(){
        return this.materia.puedeCursar(this.alumno);
    }
}
