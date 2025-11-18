package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("===== INVENTARIO =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }

    public Producto pedirDatosUsuario() {
        scanner.nextLine(); 
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("SKU: ");
        String sku = scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        scanner.nextLine();
        System.out.print("Ingrese SKU: ");
        return scanner.nextLine();
    }

    public void mostrarProducto(Producto p) {
        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(p.toString());
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}