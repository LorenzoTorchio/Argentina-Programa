import java.nio.file.Files;
import java.nio.file.Paths;

public class C4EJ2 {
    public static void main(String[] args){
        String archivo = args[0];
        String operacion = args[1];
        int resultado = 0;
        for (String linea : Files.readAllLines(Paths.get(archivo))){
            if (args[1].equals("suma"))
                resultado = Integer.parseInt(linea) + resultado;
            if (args[1].equals("resta"))
                resultado = Integer.parseInt(linea) - resultado;
        }
        System.out.println(resultado);
    }

}

