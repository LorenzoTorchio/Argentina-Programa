package paquete;

public class Carrito {
    private final ItemCarrito[] carrito;


    public Carrito(int espacio) {
        this.carrito = new ItemCarrito[espacio];
    }

    public void setItem(int i, ItemCarrito item) {
        carrito[i] = item;
    }


    public float getPrecio() {
        float precio = 0;
        for (ItemCarrito itemCarrito : carrito) {
            precio += itemCarrito.precioItem();
        }
        return precio;
    }

    @Override
    public String toString() {
        String lista = "";
        for (ItemCarrito itemCarrito : carrito) {
            lista = lista + itemCarrito.toString() + "\n";
        }
        return lista;
    }
}