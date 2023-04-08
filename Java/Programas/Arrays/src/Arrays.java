import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        contadorLetras("palabra", 'a');
        int[] numeros = {1, 2, 3, 4, 5};
        sumarDesde(numeros, numeros[2]);
        ordenarNumeros(numeros, "ascendente");
        if(args.length > 0) {
            ordenarNumerosPorParametro(args[0], args);
        } else {
            ordenarNumerosPorConsola();
        }
    }

    private static void contadorLetras(String palabra, char letra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                contador++;
            }
        }
        System.out.println("(" + contador + ") letras \"" + letra + "\" encontradas en la palabra " + "\"" + palabra + "\"");
    }

    private static void ordenarNumeros(int[] numeros, String orden) {
        int[] numerosOrdenados = new int[numeros.length];
        int aux = 0;
        if (orden.equals("ascendente")) {
            for (int j = 1; j < numeros.length + 1; j++) {
                int max = 0;
                for (int i = 0; i < numeros.length; i++) {
                    if (max < numeros[i]) {
                        max = numeros[i];
                        aux = i;
                    }
                }
                numeros[aux] = 0;
                numerosOrdenados[numeros.length - j] = max;
            }

        } else {
            for (int j = 0; j < numeros.length; j++) {
                int max = 0;
                for (int i = 0; i < numeros.length; i++) {
                    if (max < numeros[i]) {
                        max = numeros[i];
                        aux = i;
                    }
                }
                numeros[aux] = 0;
                numerosOrdenados[j] = max;
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
    }

    private static void sumarDesde(int[] numeros, int num) {
        int suma = 0;
        for (int numero : numeros) {
            if (numero > num) {
                suma += numero;
            }
        }
        System.out.println(suma);

    }
    private static void ordenarNumerosPorParametro(String orden, String[] args) {
        int[] numeros = new int[3];
        int[] numerosOrdenados = new int[numeros.length];
        for (int i = 1; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(args[i]);
        }
        for (int i = 0; i < numeros.length; i++) {
            int max = 0;
            int aux = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (max < numeros[j]) {
                    max = numeros[j];
                    aux = j;
                }
            }
            numeros[aux] = 0;
            if (orden.equals("descendente")) {
                numerosOrdenados[i] = max;
            }
            if (orden.equals("ascendente")) {
                numerosOrdenados[numeros.length - i - 1] = max;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
    }
    private static void ordenarNumerosPorConsola(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese 3 numeros");
        int n1 = teclado.nextInt();
        int n2 = teclado.nextInt();
        int n3 = teclado.nextInt();
        System.out.println("Escriba en que orden desea ordenar (ascendente, descendente)");
        String orden = teclado.nextLine();
        int[] numeros = {n1, n2, n3};
        int[] numerosOrdenados = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            int max = 0;
            int aux = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (max < numeros[j]) {
                    max = numeros[j];
                    aux = j;
                }
            }
            numeros[aux] = 0;
            if (orden.equals("descendente")) {
                numerosOrdenados[i] = max;
            }
            if (orden.equals("ascendente")) {
                numerosOrdenados[numeros.length - i - 1] = max;
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
    }
}