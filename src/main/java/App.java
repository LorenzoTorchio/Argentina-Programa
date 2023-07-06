import Configuracion.BaseDeDatos;
import Configuracion.Puntaje;
import Entidades.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    private static final List<Persona> participantes = new ArrayList<>();
    private static final List<Partido> partidos = new ArrayList<>();
    private static final Map<String, Equipo> equipos = new HashMap<>();

    public static void main(String[] args) throws IOException, SQLException {

        String archivoResultado = args[0];
        String archivoConfig = args[1];
        //se lee por parametro la configuracion de base de datos y puntaje.
        Configuracion(archivoConfig);
        //se crea una base de datos desde 0 y se incertan los participantes y sus pronosticos
        BaseDeDatos();
        //se leen los participantes de la base de datos y se ingresan a un arreglo de personas
        RegistrarParticipantes();
        //se leen los resultados de un archivo csv, los partidos y sus respectivos equipos se registran en colecciones, ademas de subirlos a la base de datos
        RegistrarResultados(archivoResultado);
        //se agregan las llaves externas para la integridad relacional de la base de datos
        AgregarFK();
        //se leen los pronosticos de la base datos y se generan los objetos de pronosticos
        RegistrarPronosticos();
        //se recorre cada persona y pronostico para calcular el puntaje
        CalcularPuntaje();
        //se ordenan los participantes de mayor a menor puntaje y se imprime por consola
        TablaPosiciones();
    }

    private static void Configuracion(String archivo) {
        try {
            Scanner scanner = new Scanner(new File(archivo));
            while (scanner.hasNext()) {
                String linea = scanner.nextLine();
                String[] data = linea.split(",");
                BaseDeDatos.setUrl(data[0]);
                BaseDeDatos.setUser(data[1]);
                BaseDeDatos.setPass(data[2]);
                BaseDeDatos.setActualizarTo(Boolean.parseBoolean(data[3]));
                Puntaje.setAcierto(Integer.parseInt(data[4]));
                Puntaje.setBonusRonda(Integer.parseInt(data[5]));
                Puntaje.setBonusFase(Integer.parseInt(data[6]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void BaseDeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(BaseDeDatos.getUrl(), BaseDeDatos.getUser(), BaseDeDatos.getPass());
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DROP DATABASE IF EXISTS competencia");
            stmt.executeUpdate("CREATE DATABASE competencia");
            stmt.executeUpdate("USE competencia");
            stmt.executeUpdate("CREATE TABLE `Participantes` (" +
                "`ID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "`Nombre` varChar(255)" +
                ")");
            stmt.executeUpdate("CREATE TABLE `Equipos` (" +
                "`Nombre` varChar(255) PRIMARY KEY" +
                ")");
            stmt.executeUpdate("CREATE TABLE `Partidos` (" +
                "`ID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "`Fase` Int," +
                "`Ronda` Int," +
                "`EquipoL` varChar(255)," +
                "`GolesL` Int," +
                "`EquipoV` varChar(255)," +
                "`GolesV` Int," +
                "FOREIGN KEY (`EquipoL`) REFERENCES Equipos(Nombre)," +
                "FOREIGN KEY (`EquipoV`) REFERENCES Equipos(Nombre)" +
                ")");
            stmt.executeUpdate("CREATE TABLE `Pronosticos` (" +
                "`IDPersona` int ," +
                "`IDPartido` int," +
                "`Equipo` varChar(255)," +
                "`Resultado` Enum('ganador','perdedor','empate')," +
                "FOREIGN KEY (`IDPersona`) REFERENCES Participantes(ID)" +
                ")");
            stmt.executeUpdate("INSERT INTO `Participantes` (`Nombre`) VALUES" +
                "('Persona A')," +
                "('Persona B')," +
                "('Persona C'),"+
                "('Persona D')");
            stmt.executeUpdate("INSERT INTO Pronosticos (IDPersona, IDPartido, Equipo, Resultado) VALUES\n" +
                    "(1, '1', 'Equipo A', 'Ganador'),\n" +
                    "(1, '2', 'Equipo C', 'Ganador'),\n" +
                    "(1, '3', 'Equipo E', 'Ganador'),\n" +
                    "(1, '4', 'Equipo G', 'Ganador'),\n" +
                    "(2, '1', 'Equipo A', 'Ganador'),\n" +
                    "(2, '2', 'Equipo C', 'Ganador'),\n" +
                    "(2, '3', 'Equipo E', 'Ganador'),\n" +
                    "(2, '4', 'Equipo G', 'Perdedor'),\n" +
                    "(3, '1', 'Equipo A', 'Ganador'),\n" +
                    "(3, '2', 'Equipo C', 'Perdedor'),\n" +
                    "(3, '3', 'Equipo E', 'Ganador'),\n" +
                    "(3, '4', 'Equipo G', 'Perdedor'),\n" +
                    "(4, '1', 'Equipo A', 'Perdedor'),\n" +
                    "(4, '2', 'Equipo C', 'Perdedor'),\n" +
                    "(4, '3', 'Equipo E', 'Perdedor'),\n" +
                    "(4, '4', 'Equipo G', 'Perdedor');");
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void RegistrarParticipantes() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(BaseDeDatos.getUrl(), BaseDeDatos.getUser(), BaseDeDatos.getPass());
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From participantes");
            while (rs.next()) {
                Persona persona = new Persona(rs.getString(2));
                participantes.add(persona);
            }
            con.close();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void RegistrarResultados(String archivo) throws IOException {
            Scanner scanner = new Scanner(new File(archivo));
            scanner.useDelimiter(",");
            while (scanner.hasNext()){
                String linea = scanner.nextLine();
                try{
                String[] data = linea.split(",");
                    String fase = data[0];
                    String ronda = data[1];
                    String local = data[2];
                    int golesLocal = Integer.parseInt(data[3]);
                    String visitante = data[4];
                    int golesVisita = Integer.parseInt(data[5]);
                Partido partido = new Partido(
                    Integer.parseInt(fase), Integer.parseInt(ronda),
                    equipos.get(checkEquipo(local)),
                    equipos.get(checkEquipo(visitante)),
                    golesLocal, golesVisita);
                partidos.add(partido);
                BaseDeDatos.Actualizar("INSERT INTO partidos (fase,ronda,equipoL,golesL,equipoV,golesV) VALUES ("
                        + fase + "," + ronda + "," + "'" + local + "'," + golesLocal + ",'" + visitante + "'," + golesVisita + ")");
                }catch(Exception e){
                 e.printStackTrace();
                }
            }
    }

    private static String checkEquipo(String nombre){
        Equipo equipo = equipos.get(nombre);
         if (equipo == null) {
            equipos.put(nombre, new Equipo(nombre));
             BaseDeDatos.Actualizar("INSERT INTO equipos (nombre) VALUES ('" + nombre + "')");
         }
        return nombre;
    }

    private static void AgregarFK() {
        BaseDeDatos.Actualizar("ALTER TABLE pronosticos\n" +
                "ADD CONSTRAINT fk_idpartido FOREIGN KEY (IDPartido) REFERENCES Partidos(ID),\n" +
                "ADD CONSTRAINT fk_equipo FOREIGN KEY (Equipo) REFERENCES Equipos(Nombre);");
    }

    private static void RegistrarPronosticos() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(BaseDeDatos.getUrl(), BaseDeDatos.getUser(), BaseDeDatos.getPass());
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From pronosticos");
            while (rs.next()) {
                Persona persona = participantes.get(rs.getInt(1)-1);
                Pronostico pronostico = new Pronostico(
                        partidos.get(rs.getInt(2)-1),
                        equipos.get(rs.getString(3)),
                        ResultadoEnum.valueOf(rs.getString(4))
                );
                persona.addPronostico(pronostico);
            }
            con.close();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void CalcularPuntaje() {
        participantes.forEach(persona -> {
            int ronda = 1;
            int fase = 1;
            boolean rondaPerfecta = true;
            boolean fasePerfecta = true;

            for (Pronostico pronostico : persona.getPronosticos()) {
                Partido partido = pronostico.getPartido();

                if (partido.getRonda() != ronda) {
                    if (rondaPerfecta) {
                        persona.sumaPuntos(Puntaje.getBonusRondaValue());
                    }
                    rondaPerfecta = true;
                    ronda = partido.getRonda();
                }

                if (partido.getFase() != fase) {
                    if (fasePerfecta) {
                        persona.sumaPuntos(Puntaje.getBonusFaseValue());
                    }
                    fasePerfecta = true;
                    fase = partido.getFase();
                }

                if (pronostico.acertado()) {
                    persona.sumaPuntos(Puntaje.getAciertoValue());
                } else {
                    rondaPerfecta = false;
                    fasePerfecta = false;
                }
            }

            if (fasePerfecta) {
                persona.sumaPuntos(Puntaje.getBonusFaseValue());
            }
            if (rondaPerfecta) {
                persona.sumaPuntos(Puntaje.getBonusRondaValue());
            }
        });
    }

    private static void TablaPosiciones(){
        System.out.println("///TABLA DE POSICIONES GLOBAL///");
        participantes.sort((p1, p2) -> p2.getPuntos() - p1.getPuntos());
        for (int i = 0; i < participantes.size(); i++) {
            Persona persona = participantes.get(i);
            System.out.println((i + 1) + "# " + persona.getNombre().toUpperCase() + " [" + persona.getPuntos() + "] puntos");
        }
    }
}