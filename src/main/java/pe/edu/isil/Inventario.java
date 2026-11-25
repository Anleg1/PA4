package pe.edu.isil;

import java.util.HashSet;
import java.util.Set;

/**
 * Almacena los productos del inventario en un HashSet.
 * Al usar un Set no se permiten productos repetidos (mismo SKU).
 */
public class Inventario {

    private final Set<Producto> productos;

    public Inventario() {
        this.productos = new HashSet<>();
    }

    // Registra un producto. Devuelve false si el SKU ya existia.
    public boolean registrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede registrar un producto nulo.");
            return false;
        }

        boolean agregado = productos.add(producto);

        if (agregado) {
            System.out.println("Registrado: " + producto.getCodigoSku() + " - " + producto.getNombre());
        } else {
            System.out.println("Duplicado rechazado: el SKU " + producto.getCodigoSku() + " ya esta registrado.");
        }
        return agregado;
    }

    // Verifica si ya existe un producto con ese SKU
    public boolean existeSku(String sku) {
        for (Producto p : productos) {
            if (p.getCodigoSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }

    // Recorre la coleccion y muestra cada producto
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("--- LISTADO DE PRODUCTOS (" + productos.size() + ") ---");
        int contador = 1;
        for (Producto p : productos) {
            System.out.println(contador + ". " + p);
            contador++;
        }
    }

    public int cantidadProductos() {
        return productos.size();
    }

    // Se devuelve la coleccion para que el integrante 3 pueda buscar y ordenar
    public Set<Producto> getProductos() {
        return productos;
    }
}
