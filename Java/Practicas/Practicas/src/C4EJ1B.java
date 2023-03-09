import java.util.Scanner;

public class C4EJ1B {
    public static void main(String[] args) {

        //creo el scanner para pedirle al usuario los datos por consola
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese 3 numeros");
        int n1 = teclado.nextInt();
        int n2 = teclado.nextInt();
        int n3 = teclado.nextInt();
        System.out.println("Escriba en que orden desea ordenar (ascendente, descendente)");
        String orden = teclado.nextLine();

        //creo dos array de enteros para la entrada y salida
        int[] numeros = {n1, n2, n3};
        int[] numerosOrdenados = new int[numeros.length];

        //itero para asignar al nuevo array los numeros ordenados mo
        for (int i = 0; i < numeros.length; i++) {

            //inicializo una variable comparar y almacenar el maximo
            int max = 0;
            //y otra para almacenar el indice del maxi
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