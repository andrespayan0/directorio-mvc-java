package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarProductoSku(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> buscarTodos() {
        return productos;
    }

    public boolean eliminarProducto(String sku) {
        Producto p = buscarProductoSku(sku);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}
