import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import paquete.*;

import org.junit.jupiter.api.Assertions;


public class ListaDeCompras {
    public static void main(String[] args) throws IOException, Carrito.CarritoCeroException, Carrito.MontoNegativoException {
    Path archivo = Paths.get("lista.txt");

    Carrito carrito = new Carrito();

        for (String linea : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
        String[] i = linea.split(" ");
        String nombre = i[0];
        int precio = Integer.parseInt(i[1]);
        int cantidad = Integer.parseInt(i[2]);

        Producto producto = new Producto(nombre, precio);
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        carrito.addItem(item);
        }

        if(args.length > 0){
            try {
                String tipoDescuento = args[0];
                switch (tipoDescuento) {
                    case "Fijo" -> {
                        Descuento desc = new Descuento.Fijo();
                        desc.setValorDesc(Float.parseFloat(args[1]));
                        desc.valorFinal(carrito.Precio());
                        carrito.setPrecio(desc.valorFinal(carrito.Precio()));
                    }
                    case "Porcentaje" -> {
                        Descuento desc = new Descuento.Porcentaje();
                        desc.setValorDesc(Float.parseFloat(args[1]));
                        desc.valorFinal(carrito.Precio());
                        carrito.setPrecio(desc.valorFinal(carrito.Precio()));
                    }
                    case "PorcentajeTope" -> {
                        Descuento.PorcentajeTope desc = new Descuento.PorcentajeTope();
                        desc.setValorDesc(Float.parseFloat(args[1]));
                        desc.setTope(Float.parseFloat(args[2]));
                        carrito.setPrecio(desc.valorFinal(carrito.Precio()));
                    }
                }

            } catch (Carrito.MontoNegativoException e){
                System.out.println("Descuento resulta en un valor negativo");
            } catch (Carrito.CarritoCeroException e){
                System.out.println("Descuento no aplicable");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("el precio de su compra es de $" + carrito.getPrecio());
        TestDescuento();
    }



    private static void TestDescuento() throws Carrito.MontoNegativoException, Carrito.CarritoCeroException {
        Carrito carrito1 = new Carrito();
        carrito1.addItem(new ItemCarrito(new Producto("Producto 1", 130), 3));
        carrito1.addItem(new ItemCarrito(new Producto("Producto 2", 2000), 2));
        carrito1.addItem(new ItemCarrito(new Producto("Producto 3", 600), 1));
        Assertions.assertEquals(4990.0,carrito1.Precio());

        Carrito carrito2 = new Carrito();
        carrito2.addItem(new ItemCarrito(new Producto("Producto 1",400),1));
        carrito2.addItem(new ItemCarrito(new Producto("Producto 2",700),2));
        Assertions.assertEquals(1800.0,carrito2.Precio());

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

        Carrito carrito3 = new Carrito();
        carrito3.addItem(new ItemCarrito(new Producto("Producto 1", 100), 0));
        Assertions.assertThrows(Carrito.CarritoCeroException.class, carrito3::Precio);

        Carrito carrito4 = new Carrito();
        carrito4.addItem(new ItemCarrito(new Producto("Producto 1", -100), 1));
        Assertions.assertThrows(Carrito.MontoNegativoException.class, carrito4::Precio);
    }

}
