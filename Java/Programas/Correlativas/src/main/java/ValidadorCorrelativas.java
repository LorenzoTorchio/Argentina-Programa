import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValidadorCorrelativas  {
    public static void main(String[] args) throws FileNotFoundException {
        CrearArchivo();
        ArrayList<Materia> materias = new ArrayList<>(){{
            add(new Materia("Programacion I"));
            add(new Materia("Programacion II"));
            add(new Materia("BaseDeDatos I"));
        }};
        System.out.println("creadas " + materias);
        setCorrelativas(materias);
        ArrayList<Alumno> alumnos = new ArrayList<>() {{
            add(new Alumno("Alumno1","Programacion I,aprobada"));
            add(new Alumno("Alumno2","Programacion I,desaprobada"));
            add(new Alumno("Alumno3",""));
        }};
        System.out.println("creadas " + alumnos);
        setMateriasAprobadas(materias, alumnos);
        ValidarInscripciones(materias, alumnos);
    }

    private static void CrearArchivo(){
        try {
            File inscr = new File("inscripciones-validadas.csv");
            if (inscr.createNewFile()) {
                System.out.println("Archivo Creado: " + inscr.getName());
            } else {
                System.out.println("Archivo Encontrado");
                if(inscr.delete()){
                    System.out.println("Archivo Borrado");
                    if(inscr.createNewFile()){
                        System.out.println("Archivo creado nuevamente: " + inscr.getName());
                    }
                }
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

            Inscripcion insc = new Inscripcion(alumnos.get(indexAlumno(alumnos,alumno)),materias.get(indexMateria(materias,materia)));

            if(insc.aprobada()){
                linea = linea.concat(",aprobada");
            } else {
                linea = linea.concat(",rechazada");
            }
            EscribirLinea(linea);
        }
    }

    private static void setCorrelativas(ArrayList<Materia> materias){
        for(Materia materia : materias) {
            if (!materia.getNombre().endsWith(" I")) {
                for (Materia value : materias) {
                    String nombreMateria = materia.getNombre().substring(0, value.getNombre().length() - 3);
                    if (value.getNombre().startsWith(nombreMateria) && !materia.equals(value)) {
                        materia.setCorrelativa(value);
                        System.out.println(value + " agregado como correlativa de " + materia + "[O]");
                    }
                }
            } else {
                System.out.println(materia + " no tiene correlativa [X]");
            }
        }
    }

    private static int indexMateria(ArrayList<Materia> materias, String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombre)) {
                return materias.indexOf(materia);
            }
        }
        return 0;
    }

    private static int indexAlumno(ArrayList<Alumno> alumnos, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumnos.indexOf(alumno);
            }
        }
        return 0;
    }

    private static void setMateriasAprobadas(ArrayList<Materia> materias, ArrayList<Alumno> alumnos){
        for(Alumno alumno : alumnos){
            String[] registro = alumno.getLegajo().split(",");
            System.out.println(Arrays.toString(registro));
            if(registro.length > 1) {
                for(int i = 0; i < registro.length; i+=2) {
                    String materia = registro[i];
                    String aprobada = registro[1+i];
                    System.out.println(alumno + " tiene" + aprobada + " la materia "  +  materia);
                    if (aprobada.equals("aprobada")) {
                        alumno.addMateriaAprobada(materias.get(indexMateria(materias, materia)));
                        System.out.println(materia + " agregada como aprobada de " + alumno + "[O]" );
                    } else {
                        System.out.println(alumno + " NO aprobo " + materia + "[X]");
                    }
                }
            } else {
                System.out.println(alumno + "no curso nada");
            }
        }
    }

    private static void EscribirLinea(String linea) {
        try {
            FileWriter myWriter = new FileWriter("inscripciones-validadas.csv", true);
            myWriter.write(linea + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}