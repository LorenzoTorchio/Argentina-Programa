import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import paquete.*;

import org.junit.jupiter.api.Assertions;


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

        if(args.length > 0){
            String tipoDescuento = args[0];
            switch (tipoDescuento) {
                case "Fijo" -> {
                    Descuento desc = new Descuento.Fijo();
                    desc.setValorDesc(Float.parseFloat(args[1]));
                    desc.valorFinal(carrito.getPrecio());
                    System.out.println("el precio de su compra es de $" +  desc.valorFinal(carrito.getPrecio()));
                }
                case "Porcentaje" -> {
                    Descuento desc = new Descuento.Porcentaje();
                    desc.setValorDesc(Float.parseFloat(args[1]));
                    desc.valorFinal(carrito.getPrecio());
                    System.out.println("el precio de su compra es de $" +  desc.valorFinal(carrito.getPrecio()));
                }
                case "PorcentajeTope" -> {
                    Descuento.PorcentajeTope desc = new Descuento.PorcentajeTope();
                    desc.setValorDesc(Float.parseFloat(args[1]));
                    desc.setTope(Float.parseFloat(args[2]));
                    System.out.println("el precio de su compra es de $" +  desc.valorFinal(carrito.getPrecio()));
                }
            }
        }

        System.out.println("el precio de su compra es de $" + carrito.getPrecio());
        TestDescuento();
    }

    private static void TestDescuento(){
        Carrito carrito1 = new Carrito(3);
        carrito1.setItem(0, new ItemCarrito(new Producto("papa", 130), 3));
        carrito1.setItem(1, new ItemCarrito(new Producto("desodorante", 2000), 2));
        carrito1.setItem(2, new ItemCarrito(new Producto("yerba", 600), 1));
        Assertions.assertEquals(4990.0,carrito1.getPrecio());

        Carrito carrito2 = new Carrito(2);
        carrito2.setItem(0, new ItemCarrito(new Producto("jabon",400),1));
        carrito2.setItem(1, new ItemCarrito(new Producto("cuchillo",700),2));
        Assertions.assertEquals(1800.0,carrito2.getPrecio());

        float ValorInicial = 1300.0F;
        Descuento desc1 = new Descuento.Fijo();
        desc1.setValorDesc(12.0F);
        Assertions.assertEquals(1288.0,desc1.valorFinal(ValorInicial));

        Descuento desc2 = new Descuento.Porcentaje();
        desc2.setValorDesc(10.0F);
        Assertions.assertEquals(1170.0,desc2.valorFinal(ValorInicial));

        Descuento.PorcentajeTope desc3 = new Descuento.PorcentajeTope();
        desc3.setValorDesc(10.0F);
        desc3.setTope(5.0F);
        Assertions.assertEquals(1235.0,desc3.valorFinal(ValorInicial));
    }

}
