package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDeDatos {
    private static String DB_URL;
    private static String USER;
    private static String PASS;

    private static boolean actualizar;
    public static void setUrl(String nombre){
        DB_URL = "jdbc:mysql://localhost/" + nombre;
    }
    public static void setUser(String user){
        USER = user;
    }
    public static void setPass(String pass){
        PASS = pass;
    }
    public static String getUrl(){
        return DB_URL;
    }
    public static String getUser(){
        return USER;
    }
    public static String getPass(){
        return PASS;
    }

    public static void setActualizarTo(boolean value){
        actualizar = value;
    }
    public static void Actualizar(String sql) {
        if(actualizar){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(getUrl(), getUser(), getPass());
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }



}
