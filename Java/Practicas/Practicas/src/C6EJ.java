import org.junit.jupiter.api.Assertions;
public class C6EJ {
    public static void main(String[] args){
        class Calculadora{
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

        Assertions.assertEquals(240, Calculadora.Multiplicar(80, 3));
        Assertions.assertEquals(110, Calculadora.Dividir(Calculadora.Sumar(150, 180), 3));
        Assertions.assertNotEquals(605, Calculadora.Multiplicar(Calculadora.Restar(90, 50), 15), 0.0);
        Assertions.assertNotEquals(2700, Calculadora.Multiplicar(Calculadora.Sumar(70, 40), 25), 0.0);

    }
}
