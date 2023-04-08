import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Introduccion {
    public static void main(String[] args) throws IOException {
        Operaciones();
        ingresosAltos();
        OperacionesArchivoParametro(args[0],args[1]);
    }

    private static void Operaciones(){
        int a = 0;
        int b = 10;
        System.out.println("(a)");
        while(a<b+1) {
            System.out.println(a);
            a++;
        }

        System.out.println("(b)");
        a = 0;
        while(a<b+1) {
            if(a%2==0) {
                System.out.println(a);
            }
            a++;
        }

        System.out.println("(c)");
        a = 0;
        int c = 1;
        while(a<b) {
            if(a%2==c) {
                System.out.println(a);
            }
            a++;
        }

        System.out.println("(d)");
        a = 0;
        while (a < b) {
            if(b%2==0) {
                System.out.println(b);
            }
            b--;
        }
    }

    private static void ingresosAltos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese sus ingresos mensuales.");
        int ingMen = sc.nextInt();
        System.out.println("Cuantos autos nuevos posee?");
        int autNuev = sc.nextInt();
        System.out.println("Cuantos inmuebles posee?");
        int inm = sc.nextInt();
        System.out.println("Posee algun activo de lujo? ingrese si o no");
        boolean activoLujo = sc.nextLine().equals("si");
        if (ingMen >= 489083 || autNuev >= 3 || inm >= 3 || activoLujo){
            System.out.println("pertenece al segmento de ingresos altos");
        } else
            System.out.println("NO pertenece al segment o de ingresos altos");
    }

    private static void OperacionesArchivoParametro(String archivo,String operacion) throws IOException {
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



