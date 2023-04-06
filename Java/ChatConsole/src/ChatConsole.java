import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChatConsole {
    public static void main(String[] args) throws FileNotFoundException {
        CrearArchivo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola, Cual es tu apodo?");
        String apodo = sc.nextLine();
        String respuesta;
        do {
            System.out.println();
            System.out.println("Aprete Enter para enviar mensaje");
            System.out.println("Escriba [V] para ver mensajes");
            System.out.println("Salir [X]");
            System.out.println();
            respuesta = sc.nextLine();
            if (respuesta.equals("V")) {
                LeerArchivo();
            }
            if (respuesta.equals("")){
                System.out.println("Escriba y aprete Enter para enviar mensaje");
                EscribirLinea(apodo.concat(": ").concat(sc.nextLine()));
            }
        } while (!respuesta.equals("X"));
    }

    private static void CrearArchivo(){
        try {
            File chat = new File("chat.txt");
            Scanner sc = new Scanner(System.in);
            if (!chat.createNewFile()) {
                System.out.println("escriba x para borrar la ultima conversacion");
                String x = sc.nextLine();
                if(x.equals("x")){
                    BorrarArchivo();
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error...");
            e.printStackTrace();
        }
    }
    private static void BorrarArchivo(){
            System.out.println("Borrando Chat");
            File chat = new File("chat.txt");
            if (chat.delete()) {
                System.out.println("Archivo borrado");
            } else {
                System.out.println("Fallo al borrar archivo");
            }
    }

    private static void LeerArchivo() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("chat.txt"));
        System.out.println("Mensajes hasta ahora:");
        while(sc.hasNext()) {
            String linea = sc.nextLine();
            System.out.println(linea);
        }
    }

    private static void EscribirLinea(String linea) {
        try {
            FileWriter fw = new FileWriter("chat.txt", true);
            fw.write(linea + "\n");
            fw.close();
            System.out.println("Mensaje Enviado.");
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}