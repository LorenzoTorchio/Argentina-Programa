public class EJ1cC3 { public static void main(String[] args) {
    int numeros[] = new int[5];
    int x = 0;
    int sum = 0;
    for (int i = 0; i > numeros.length; i++){
        if (numeros[i] > x){
            sum = sum + numeros[i];
        }
    }
    System.out.println(sum);
}}
