import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encripcion {

    public static void main(String[] args) throws IOException {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";

        String operacion = args[0];
        int desplazamiento = Integer.parseInt(args[1]);

        String archivoEntrada = args[2];
        String archivoSalida = args[3];

        BufferedReader archivoI = new BufferedReader(new FileReader(archivoEntrada));
        String palabra = archivoI.readLine();

        if(operacion.equalsIgnoreCase("codificaion")) {
            palabra = Codificacion(palabra, abecedario, desplazamiento);
            System.out.println(palabra);
        }

        if(operacion.equalsIgnoreCase("decodificaion")) {
            palabra = Decodificacion(palabra, abecedario, desplazamiento);
            System.out.println(palabra);
        }

        try {
            FileWriter myWriter = new FileWriter(archivoSalida);
            myWriter.write(palabra);
            myWriter.close();
            System.out.println("Escritura Exitosa");
        } catch (IOException e) {
            System.out.println("Escritura Fallida");
            e.printStackTrace();
        }

    }

    private static String Codificacion(String palabra, String abecedario, int desplazamiento){
        String codigo = "";
        for(int i = 0; i < palabra.length(); i++){
            int posicionLetra = abecedario.indexOf(palabra.charAt(i)) + desplazamiento;
            codigo += abecedario.charAt(posicionLetra);
        }
        return codigo;
    }

    private static String Decodificacion(String codigo, String abecedario, int desplazamiento){
        String deco = "";
        for(int i = 0; i < codigo.length(); i++){
            int posicionLetra = abecedario.indexOf(codigo.charAt(i)) - desplazamiento;
           deco += abecedario.charAt(posicionLetra);
        }
        return deco;
    }


}
