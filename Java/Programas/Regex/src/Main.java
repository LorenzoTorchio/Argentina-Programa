import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File(args[0]);
        String regex = args[1];
        Pattern patron = Pattern.compile(regex);
        ValidarExpresion(archivo, patron);

        regex = args[2];
        Pattern patrones = Pattern.compile(regex);
        ExtraerValidos(archivo, patrones);
    }

    private static void ValidarExpresion(File archivo, Pattern patron) throws FileNotFoundException {
        Scanner scanner = new Scanner(archivo);
        while(scanner.hasNext()){
            String linea = scanner.nextLine();
            System.out.println(linea + " " + patron.matcher(linea).matches());
        }
    }

    private static void ExtraerValidos(File archivo, Pattern patrones) throws FileNotFoundException {
        Scanner scanner = new Scanner(archivo);
        while(scanner.hasNext()){
            String linea = scanner.nextLine();
            System.out.println();
        }
    }
}