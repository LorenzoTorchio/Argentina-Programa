package paquete;

public class Producto {
    private String nombre;
    private int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto: " +
                "nombre:" + nombre + "\n" +
                "precio:" + precio + "\n";
    }
}
