package Configuracion;

public class Puntaje {


    private static int acierto;
    private static int bonusRonda;
    private static int bonusFase;

    public static int getAciertoValue() {
        return acierto;
    }
    public static int getBonusRondaValue() {
        return bonusRonda;
    }
    public static int getBonusFaseValue() {
        return bonusFase;
    }

    public static void setAcierto(int n){
        acierto = n;
    }
    public static void setBonusRonda(int n) {
        bonusRonda = n;
    }
    public static void setBonusFase(int n){
        bonusFase = n;
    }



}
