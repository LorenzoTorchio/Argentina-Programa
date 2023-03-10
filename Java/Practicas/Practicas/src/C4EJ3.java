import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C4EJ3 {
    public static void main(String[] args) throws IOException {
        String operacion = args[0];
        int desplazamiento = Integer.parseInt(args[1]);
        String archivoEntrada = args[2];
        String archivoSalida = args[3];
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String resultado = "";

        BufferedReader archivoI = new BufferedReader(new FileReader(archivoEntrada));
        String palabra = archivoI.readLine();

        if(operacion.equals("codificacion")) {
            for (int i = 0; i < palabra.length(); i++) {
                int posicionLetra = abecedario.indexOf(palabra.charAt(i)) + desplazamiento;
                resultado +=  abecedario.charAt(posicionLetra);
            }
        }

        if(operacion.equals("decodificaion")) {
            for (int i = 0; i < palabra.length(); i++) {
                int posicionLetra = abecedario.indexOf(palabra.charAt(i)) - desplazamiento;
                resultado += abecedario.charAt(posicionLetra);
            }
        }

        try {
            FileWriter myWriter = new FileWriter(archivoSalida);
            myWriter.write(resultado);
            myWriter.close();
            System.out.println("Escritura Exitosa");
        } catch (IOException e) {
            System.out.println("Escritura Fallida");
            e.printStackTrace();
        }

    }
}

