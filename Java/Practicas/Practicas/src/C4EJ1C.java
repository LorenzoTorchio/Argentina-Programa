import java.util.Scanner;

public class C4EJ1C {
    public static void main(String[] args) {
            int numeros[] = {n1,n2,n3};
            int numerosOrdenados[] = new int[numeros.length];
            int aux = 0;
            int orden = -1;

            String n1 = args[0];
            Scanner teclado = new Scanner(System.in);
            if (args[0].equals("")) {
               n1 = interger.parseInt(teclado.nextline());
            }


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