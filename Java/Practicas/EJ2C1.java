public class EJ2C1 {
    public static void main(String[] args) {
        int ingMen = 300000;
        int autNuev = 2;
        int inm = 1;
        boolean activoLujo = false;
        if (ingMen >= 489083 || autNuev >= 3 || inm >= 3 || activoLujo){
            System.out.println("pertenece al segmento de ingresos altos");
        } else
            System.out.println("NO pertenece al segment o de ingresos altos");
    }
}
