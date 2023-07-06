package Entidades;

public class Partido {

    private final int fase;
    private final int ronda;
    private final Equipo equipo1;
    private final Equipo equipo2;
    private final int golesEquipo1;
    private final int golesEquipo2;
    public Partido(int fase, int ronda, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.fase = fase;
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    public ResultadoEnum Resultado(Equipo equipo){
        if(golesEquipo1 == golesEquipo2){
            return ResultadoEnum.empate;
        }
        if (equipo.equals(equipo1)) {
            return golesEquipo1 > golesEquipo2 ? ResultadoEnum.ganador : ResultadoEnum.perdedor;
        }
        return golesEquipo1 > golesEquipo2 ? ResultadoEnum.perdedor : ResultadoEnum.ganador;
    }

    public int getFase() {
        return fase;
    }

    public int getRonda() {
        return ronda;
    }

    @Override
    public String toString() {
        return this.equipo1.getNombre() + ") " + this.golesEquipo1 + " - " + this.golesEquipo2 + " (" + this.equipo2.getNombre();
    }
}

