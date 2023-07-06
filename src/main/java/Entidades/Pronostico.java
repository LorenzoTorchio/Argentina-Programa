package Entidades;

public class Pronostico{
    private final Partido partido;
    private final Equipo equipo;
    private final ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Partido getPartido(){
        return this.partido;
    }
    public boolean acertado() {
      return this.resultado.equals(this.partido.Resultado(this.equipo));
    }

    @Override
    public String toString(){
        if(this.equipo == null) {
            return this.partido.toString() +
                    " | " + this.resultado + " | ";
        } else return this.partido.toString() +
                " | " + this.equipo + " " + this.resultado ;
    }
}