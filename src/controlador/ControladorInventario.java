package controlador;

import modelo.BaseDeDatos;
import vista.InventarioVista;
import modelo.Producto;

public class ControladorInventario {

    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos modelo, InventarioVista vista) {
        this.baseDatos = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {

            int opcion = vista.mostrarMenu();

            switch(opcion) {
                case 1:
                    Producto nuevo = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(nuevo);
                    vista.mostrarMensaje("Producto agregado correctamente.");
                    break;

                case 2:
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;

                case 3:
                    vista.mostrarProductos(baseDatos.buscarTodos());
                    break;

                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean ok = baseDatos.eliminarProducto(skuEliminar);
                    if (ok) {
                        vista.mostrarMensaje("Producto eliminado.");
                    } else {
                        vista.mostrarMensaje("No se encontro el producto.");
                    }
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje("Opcion invalida.");
            }
        }
    }
}