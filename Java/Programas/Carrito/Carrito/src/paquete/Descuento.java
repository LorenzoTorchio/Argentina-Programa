package paquete;

public class Descuento{
    class DescuentoPorcentaje extends Descuento{
        public static float getDescuento(float precio, int descuento) {
            return precio - (precio * descuento / 100);
        }
    }

    class DescuentoFijo extends Descuento{
        public static float getDescuento(float precio, int descuento){
            return precio - descuento;
        }
    }
    class DescuentoPorcentajeConTope extends DescuentoPorcentaje{
        public static float getDescuento(float precio, int descuentoPorcentaje, int tope) {
            if (descuentoPorcentaje > tope){
                descuentoPorcentaje = tope;
            }
            return precio - (precio * descuentoPorcentaje / 100);
        }
    }

}
