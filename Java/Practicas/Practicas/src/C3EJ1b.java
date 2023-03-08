public class C3EJ1b {
    public static void main(String[] args) {
        int numeros[] = {1,2,3};
        int numerosOrdenados[] = new int[numeros.length];
        int aux = 0;
        int orden = -1;

        if (orden > 0){
            for(int j = 1; j < numeros.length +1; j++) {
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

        for(int i = 0; i < numeros.length; i++){
            System.out.println(numerosOrdenados[i]);
        }
    }
    }

