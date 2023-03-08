import java.util.Scanner;
public class C4EJ1B {

        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            int n1 = teclado.nextInt();
            int n2 = teclado.nextInt();
            int n3 = teclado.nextInt();
            int numeros[] = {n1,n2,n3};
            int numerosOrdenados[] = new int[numeros.length];
            int aux = 0;
            int orden = teclado.nextInt();
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

