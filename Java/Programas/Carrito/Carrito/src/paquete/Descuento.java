package paquete;

public abstract class Descuento{
    private float valor;
    public float getValorDesc() {
        return valor;
    }
    public void setValorDesc(float valor) {
        this.valor = valor;
    }
    public abstract float valorFinal(float valorInicial);

    public static class Fijo extends Descuento{

        @Override
        public float valorFinal(float valorInicial) {
            return valorInicial - this.getValorDesc();
        }
    }

    public static class Porcentaje extends Descuento{
        @Override
        public float valorFinal(float valorInicial) {
            return valorInicial - (valorInicial * this.getValorDesc() / 100);
        }
    }


    public static class PorcentajeTope extends Descuento {
        private float tope;

        public void setTope(float tope){
            this.tope = tope;
        }

        public float getTope(){
            return this.tope;
        }


        @Override
        public float valorFinal(float valorInicial) {
            float desc = this.getValorDesc();
            if ( desc > this.getTope()){
                desc = this.getTope();
            }
            return valorInicial - (valorInicial * desc / 100);
        }
    }


}
