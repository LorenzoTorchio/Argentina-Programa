import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import paquete.*;

public class ListaDeCompras {
    public static void main(String[] args) throws IOException {
    Path archivo = Paths.get("lista.txt");

    long l = Files.lines(archivo).count();

    int dimension = (int) l;

    Carrito carrito = new Carrito(dimension);
    int index = 0;

        for (String linea : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
        String[] i = linea.split(" ");
        String nombre = i[0];
        int precio = Integer.parseInt(i[1]);
        int cantidad = Integer.parseInt(i[2]);

        Producto producto = new Producto(nombre, precio);
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        carrito.setItem(index, item);
        index++;
    }
        System.out.println("el precio de su compra es de $" + carrito.getPrecio() + ".");

    }

}
