import paquete.Equipo;
import paquete.Partido;
import paquete.Ronda;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TrabajoPracticoIntegradorApolo
{
    public static void main(String[] args) throws IOException {
        Path partidos = Paths.get("../partidos.txt");
        Path pronosticos = Paths.get("../pronosticos.txt");

        long l = Files.lines(partidos).count();
        int dimension = (int) l;

        Ronda ronda = new Ronda(dimension);

        int index = 0;
        for (String linea : Files.readAllLines(pronosticos, StandardCharsets.UTF_8)) {
            String[] i = linea.split(" ");
            Equipo equipo1  = new Equipo(i[0]);
            Equipo equipo2  = new Equipo(i[1]);
            Partido partido = new Partido(equipo1,equipo2,Integer.parseInt(i[2]),Integer.parseInt(i[3]));
            ronda.setPartido(index, partido);
            index++;
        }

    }
}
