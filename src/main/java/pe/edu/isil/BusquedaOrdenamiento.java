
package pe.edu.isil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BusquedaOrdenamiento {

    private final Inventario inventario;

    // Constructor
    public BusquedaOrdenamiento(Inventario inventario) {
        this.inventario = inventario;
    }

    // 1. Buscar producto por codigo SKU
    public Producto buscarPorSku(String sku) {

        for (Producto p : inventario.getProductos()) {

            if (p.getCodigoSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }

        return null;
    }

    // 2. Buscar productos por nombre
    public List<Producto> buscarPorNombre(String nombre) {

        List<Producto> encontrados = new ArrayList<>();

        for (Producto p : inventario.getProductos()) {

            if (p.getNombre().toLowerCase()
                    .contains(nombre.toLowerCase())) {

                encontrados.add(p);
            }
        }

        return encontrados;
    }

    // 3. Ordenar productos alfabeticamente por nombre
    public List<Producto> ordenarPorNombre() {

        List<Producto> lista = new ArrayList<>(
                inventario.getProductos()
        );

        lista.sort(
                Comparator.comparing(
                        Producto::getNombre,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        return lista;
    }

    // 4. Ordenar productos por precio de menor a mayor
    public List<Producto> ordenarPorPrecio() {

        List<Producto> lista = new ArrayList<>(
                inventario.getProductos()
        );

        lista.sort(
                Comparator.comparingDouble(Producto::getPrecioBase)
        );

        return lista;
    }

}
