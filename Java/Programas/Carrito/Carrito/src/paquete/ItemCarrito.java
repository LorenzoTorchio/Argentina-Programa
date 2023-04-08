package paquete;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
    private float precioUnidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnidad = producto.getPrecio();
    }

    public float precioItem() {
        return precioUnidad * cantidad;
    }

    @Override
    public String toString() {
        return producto.toString() + "cantidad: " + cantidad;
    }
}
