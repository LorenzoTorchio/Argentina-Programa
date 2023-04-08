import org.junit.jupiter.api.Assertions;

public class Calculadora{
    public static void main(String[] args){

        class Operacion{

                public static double Sumar(double a, double b){
                    return a + b;
                }

                public static double Restar(double a, double b){
                    return a - b;
                }

                public static double Multiplicar(double a, double b){
                    return a * b;
                }

                public static double Dividir(double a, double b){
                    return a / b;
                }

        }

            Assertions.assertEquals(240, Operacion.Multiplicar(80, 3));
            Assertions.assertEquals(110, Operacion.Dividir(Operacion.Sumar(150, 180), 3));
            Assertions.assertNotEquals(605, Operacion.Multiplicar(Operacion.Restar(90, 50), 15), 0.0);
            Assertions.assertNotEquals(2700, Operacion.Multiplicar(Operacion.Sumar(70, 40), 25), 0.0);


    }


}

