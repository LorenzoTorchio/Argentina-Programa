package paquete;

public class Carrito {
    private ItemCarrito[] carrito;

    public Carrito(int espacio) {
        this.carrito = new ItemCarrito[espacio];
    }

    public void setItem(int i, ItemCarrito item) {
        carrito[i] = item;
    }


    public float getPrecio() {
        float precio = 0;
        for (int i = 0; i < carrito.length; i++) {
            precio += carrito[i].precioItem();
        }
        return precio;
    }

    @Override
    public String toString() {
        String lista = "";
        for (int i = 0; i < carrito.length; i++) {
            lista = lista + carrito[i].toString() + "\n";
        }
        return lista;
    }
}