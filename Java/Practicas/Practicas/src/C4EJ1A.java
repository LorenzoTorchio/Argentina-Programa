public class C4EJ1A {
    public static void main(String[] args) {
        //creo dos array de enteros para la entrada y salida
        int[] numeros = new int[3];
        int[] numerosOrdenados = new int[numeros.length];

        //asigno los numeros y el orden de los argumentos a variables
        String orden = args[3];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(args[i]);
        }

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


