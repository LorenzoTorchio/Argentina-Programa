//codificación o decodificación, el valor del desplazo, y 2 archivos, uno para la entrada y
//otro para la salida

public class C4EJ3 {
    public static void main(String[] args) {
        String operacion = args[0];
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        int desplazamiento =  Integer.parseInt(args[1]);
        String palabra = args[2];
        String resultado = args[3];

        if(operacion.equals("codificacion")) {
            for (int i = 0; i < palabra.length(); i++) {
                int posicionLetra = abecedario.indexOf(palabra.charAt(i)) + desplazamiento;
                resultado = resultado + abecedario.charAt(posicionLetra);
            }
        }

        if(operacion.equals("decodificaion")) {
            for (int i = 0; i < palabra.length(); i++) {
                int posicionLetra = abecedario.indexOf(palabra.charAt(i)) - desplazamiento;
                resultado = resultado + abecedario.charAt(posicionLetra);
            }
        }

        if(succes){
            System.out.println("operacion exitosa")
        } else {
            System.out.println("operacion fallida");
        }
    }
}

