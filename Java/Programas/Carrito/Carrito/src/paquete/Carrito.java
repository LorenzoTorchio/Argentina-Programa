package paquete;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private final List<ItemCarrito> items;
    private float precio;


    public Carrito() {
        this.items = new ArrayList<>();
    }

    public void addItem(ItemCarrito item) {
        items.add(item);
    }

    public float getPrecio(){
        return this.precio;
    }


    public float Precio() throws CarritoCeroException, MontoNegativoException {

        float precio = 0;
        for (ItemCarrito itemCarrito : items) {
            precio += itemCarrito.precioItem();
        }

        if (precio == 0) {
            throw new CarritoCeroException();
        }


        return precio;
    }

    public static class CarritoCeroException extends Exception {
        public CarritoCeroException() {
        }
    }

    public static class MontoNegativoException extends Exception {
        public MontoNegativoException() {
        }
    }


    public void setPrecio(float precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        String lista = "";
        for (ItemCarrito itemCarrito : items) {
            lista = lista + itemCarrito.toString() + "\n";
        }
        return lista;
    }
}