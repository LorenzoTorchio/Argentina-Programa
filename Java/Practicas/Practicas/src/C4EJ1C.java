import java.util.Scanner;

public class C4EJ1C {
    public static void main(String[] args) {
        //creo dos array de enteros para la entrada y salida
        int[] numeros = new int[3];
        int[] numerosOrdenados = new int[numeros.length];

        //creo el scanner en caso de que los argumentos no se ingresen
        Scanner teclado = new Scanner(System.in);

        //asigno los numeros y el orden de los argumentos a variables
        for (int i = 0; i < numeros.length; i++) {
            if(args[i].equals("")){
                numeros[i] = teclado.nextInt();
            }
                numeros[i] = Integer.parseInt(args[i]);
        }

        String orden = args[3];
        if(args[3].equals("")) {
            System.out.println("Escriba en que orden desea ordenar (ascendente, descendente)");
            orden = teclado.nextLine();
        }

        //itero para asignar al nuevo array los numeros ordenados mo
        for (int i = 0; i < numeros.length; i++) {

            //inicializo una variable comparar y almacenar el maximo
            int max = 0;
            //y otra para almacenar el indice del maximo
            int aux = 0;

            //itero para encontrar el maximo
            for (int j = 0; j < numeros.length; j++) {
                if (max < numeros[j]) {
                    max = numeros[j];
                    aux = j;
                }
            }

            //al encontrar el maximo lo anulo para encontrar el siguiente
            numeros[aux] = 0;

            //asigno al nuevo array dependiendo el orden deseado
            if (orden.equals("descendente")) {
                numerosOrdenados[i] = max;
            }
            if (orden.equals("ascendente")) {
                numerosOrdenados[numeros.length - i - 1] = max;
            }
        }

        //y los imprimo
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
    }
}