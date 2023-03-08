public class C3EJ2 {public static void main(String[] args) {
    String abecedario = "abcdefghijklmnñopqrstuvwxyz";
    int desplazamiento = 1;
    String palabra = "palabra";
    String codigo = "";
    String deco = "";

    for(int i = 0; i < palabra.length(); i++){
        int posicionLetra = abecedario.indexOf(palabra.charAt(i)) + desplazamiento;
        codigo = codigo + abecedario.charAt(posicionLetra);
    }
    System.out.println(codigo);


    for(int i = 0; i < codigo.length(); i++){
        int posicionLetra = abecedario.indexOf(codigo.charAt(i)) - desplazamiento;
        deco = deco + abecedario.charAt(posicionLetra);
    }
    System.out.println(deco);
}}
