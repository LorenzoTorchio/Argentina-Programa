import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C4EJ2 {
    public static void main(String[] args) throws IOException {
        String archivo = args[0];
        String operacion = args[1];
        int resultado = 0;
        if (operacion.equals("multiplicacion")) {
            resultado += 1;
        }

        for (String linea : Files.readAllLines(Paths.get(archivo), StandardCharsets.UTF_8)) {
            if (operacion.equals("suma")) {
                resultado = Integer.parseInt(linea) + resultado;
            }
            if (operacion.equals("multiplicacion")) {
                resultado = Integer.parseInt(linea) * resultado;
            }
            System.out.println(resultado);
        }

    }
}
