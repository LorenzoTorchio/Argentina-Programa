import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidadorCorrelativas  {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Materia> materias = new ArrayList<>(){{
            add(new Materia("Programacion I"));
            add(new Materia("Programacion II"));
            add(new Materia("Base de Datos I"));
        }};
        ArrayList<Alumno> alumnos = new ArrayList<>() {{
            add(new Alumno("Lorenzo"));
            add(new Alumno("Facundo"));
            add(new Alumno("Federico"));
        }};
        CrearArchivo();
        ValidarInscripciones(materias, alumnos);
    }

    private static void CrearArchivo(){
        try {
            File inscr = new File("inscripciones-validadas.csv");
            if (inscr.createNewFile()) {
                System.out.println("Archivo Creado: " + inscr.getName());
            } else {
                System.out.println("Archivo Encontrado");
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }

    private static void ValidarInscripciones(ArrayList<Materia> materias, ArrayList<Alumno> alumnos) throws FileNotFoundException {
        String archivo = "src\\main\\resources\\inscripciones.csv";
        Scanner scanner = new Scanner(new File(archivo));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            String linea = scanner.nextLine();
            String[] data = linea.split(",");
            String alumno = data[0];
            String materia = data[1];
                if (alumno == null){
                    EscribirLinea("alumno inexistente");
                    continue;
                }
                if (materia == null){
                    EscribirLinea("materia inexistente");
                    continue;
                }
            setCorrelativas(materias, materias.get(Materia.getIndex(materia,materias)));

            Inscripcion insc = new Inscripcion(alumno, materia);


            if(insc.aprobada()){
                linea = linea.concat(",aprobada");
            } else {
                linea = linea.concat(",rechazada");
            }
            EscribirLinea(linea);
        }
    }

    private static void setCorrelativas(ArrayList<Materia> materias, Materia materia){
        if(!materia.getNombre().endsWith("I")){
            for (Materia value : materias) {
                if (value.getNombre().startsWith(materia.getNombre().substring(0, value.getNombre().length()-3)) && !materia.equals(value)) {
                    materia.setCorrelativa(value);
                }
            }
        }
    }

    private static void EscribirLinea(String linea) {
        try {
            FileWriter myWriter = new FileWriter("inscripciones-validadas.csv");
            myWriter.write(linea);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}