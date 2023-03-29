import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7EJ {
        public static void main(String[] args) throws IOException {

            class Producto {
                //atributos
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

            class ItemCarrito {
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

            class Carrito {
                private float precio;
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

                public float setPrecio(float precio){
                    return this.precio = precio;
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

            class Descuento{
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

            Path archivo = Paths.get("../lista.txt");

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
            Assertions.assertEquals(1300,carrito.getPrecio());
            Assertions.assertEquals(1170.0,Descuento.DescuentoPorcentaje.getDescuento(carrito.getPrecio(), 10));
            Assertions.assertEquals(1250.0,Descuento.DescuentoFijo.getDescuento(carrito.getPrecio(), 50));
            Assertions.assertEquals(1170.0,Descuento.DescuentoPorcentajeConTope.getDescuento(carrito.getPrecio(), 20, 10));
            //Aprender colecciones, para el carrito, y para personas
            //Excepciones: descuento resultado negativo, descuento a carrito 0, mostrar error no resultado. Testear

        }

    }
