package LorenzoTorchio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Qatar2022","root","8ritorneloz");
                    Statement stmt=con.createStatement();
                    String query =  "INSERT INTO departamento (`nombre`) VALUES (`Ventas`)";
                    String query0 = "DELETE FROM empleado WHERE DNI = 23495387";
                    String query1 = "INSERT INTO empleado (`DNI`, `nombre`, `apellido`, `nacionalidad`, `departamento`) VALUES (23495387, `Ricardo`, `Perez`, `Argentina`, `Ventas`)";
                    String query2 = "UPDATE empleado SET nacionalidad = `Peru` WHERE DNI = 23495387";
                    String query3 = "DELETE FROM empleado WHERE departamento = `Ventas`";
                    String query4 = "DELETE FROM departamento WHERE nombre = `Ventas`";

                    String[] consultas = {query,query0,query1,query2,query3,query4};
                    for (String consulta : consultas) {
                        stmt.executeUpdate(consulta);
                        boolean consultaEfectiva = stmt.execute(consulta);
                        if (consultaEfectiva) {
                            System.out.println("Consulta aplicada");
                        } else {
                            System.out.println("Consulta no afecto ningun registro.");
                        }
                    }

                    String query5 = "SELECT * FROM empleado WHERE departamento = 'Logística'";
                    ResultSet rs1=stmt.executeQuery(query5);
                    while(rs1.next()){
                        System.out.println(rs1.getInt(1));
                    }

                    String query6 = "SELECT * FROM departamento ORDER BY Nombre ASC";
                    ResultSet rs2=stmt.executeQuery(query6);
                    while(rs2.next()){
                        System.out.println(rs2);
                    }


                    con.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
}