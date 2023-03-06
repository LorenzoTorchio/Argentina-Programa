public class EJ1C3 {
    public static void main(String[] args) {
        String palabra = "palabra";
        char letra = 'a';
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra){
                contador++;
            }
        }
        System.out.println("(" + contador + ") letras \"" + letra + "\" encontradas en la palabra " + "\"" + palabra + "\"");
    }
}