package paquete;

//supuestamente el metodo puntos entra en esta clase

public class Ronda{
    private int num;
    private Partido[] ronda;

    public Ronda(int espacio){
        this.ronda = new Partido[espacio];
    }
    public void setPartido(int i, Partido partido) {
        ronda[i] = partido;
    }

}
