import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//abrir otra instancia de cmd y lanzar en ambas con el comando java ChatConsole

public class ChatConsole {
    public static void main(String[] args) throws FileNotFoundException {
        CrearArchivo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola, Cual es tu apodo?");
        String apodo = sc.nextLine();
        String respuesta;
        do {
            System.out.println("-------------------------------");
            System.out.println("Aprete [Enter] ENVIAR MENSAJE");
            System.out.println("Escriba [V] para VER MENSAJE");
            System.out.println("Escriba [X] para salir");
            System.out.println("Esperando Orden...");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("V")) {
                LeerArchivo();
            }
            if (respuesta.equals("")){
                System.out.println("Ingrese el mensaje...");
                EscribirLinea(getDateTime().concat(apodo.concat(": ").concat(sc.nextLine())));
            }
        } while (!respuesta.equalsIgnoreCase("X"));
        System.out.println("Ingrese [X] para borrar el ultimo chat");
        String x = sc.nextLine();
        if(x.equalsIgnoreCase("X")){
            BorrarArchivo();
        }
    }

    private static void CrearArchivo(){
        try {
            File chat = new File("chat.txt");
            Scanner sc = new Scanner(System.in);
            if (!chat.createNewFile()) {
                System.out.println("Ingrese [X] para borrar el ultimo chat");
                String x = sc.nextLine();
                if(x.equalsIgnoreCase("X")){
                    BorrarArchivo();
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error...");
            e.printStackTrace();
        }
    }
    private static void BorrarArchivo(){
            File chat = new File("chat.txt");
            if (chat.delete()) {
                System.out.println("Archivo Borrado Exitosamente.");
            } else {
                System.out.println("Fallo al borrar archivo");
            }
    }
    private static void EscribirLinea(String linea) {
        try {
            FileWriter fw = new FileWriter("chat.txt", true);
            fw.write(linea + "\n");
            fw.close();
            System.out.println("Mensaje Enviado Exitosamente..");
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
    private static void LeerArchivo() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("chat.txt"));
        System.out.println("REGISTRO DEL CHAT: ");
        while(sc.hasNext()) {
            String linea = sc.nextLine();
            System.out.println(linea);
        }
    }
    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date).concat(" | ");
    }

}