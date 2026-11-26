package pe.edu.isil;

import java.util.ArrayList;
import java.util.List;

// Herencia, clase abstracta, interfaz y sobrescritura sobre el mismo inventario
public class PruebaHerencia {

    public static void ejecutar(Inventario inventario) {
        System.out.println("\n=== HERENCIA, CLASE ABSTRACTA E INTERFAZ ===");

        // ProductoCategoria error = new ProductoCategoria("X", "Y", 1, 1, "Z");
        // ^ No compila: una clase abstracta no se puede instanciar

        // Variable de la clase abstracta, objeto de la subclase
        ProductoCategoria prod1 = new ProductoElectronico("SKU-009", "Impresora Epson L3250", 800.00, 7, 12);
        ProductoCategoria prod2 = new ProductoElectronico("SKU-010", "Tablet Samsung Galaxy Tab A9", 1500.00, 9, 24);
        ProductoCategoria prod3 = new ProductoAlimenticio("SKU-011", "Caja Yogurt Gloria x12", 120.00, 20, 15);
        ProductoCategoria prod4 = new ProductoAlimenticio("SKU-012", "Caja Atun Florida x48", 240.00, 14, 90);

        // Como heredan de Producto, entran al mismo inventario (HashSet)
        System.out.println("--- Registro de productos con categoria ---");
        inventario.registrarProducto(prod1);
        inventario.registrarProducto(prod2);
        inventario.registrarProducto(prod3);
        inventario.registrarProducto(prod4);
        System.out.println("Total en inventario: " + inventario.cantidadProductos());

        List<ProductoCategoria> categorizados = new ArrayList<>();
        categorizados.add(prod1);
        categorizados.add(prod2);
        categorizados.add(prod3);
        categorizados.add(prod4);

        // Cada objeto usa su propia version de los metodos sobrescritos
        System.out.println("\n--- Detalle y precio final ---");
        for (ProductoCategoria prod : categorizados) {
            prod.mostrarDetalle();
            System.out.println("Precio final: S/ " + prod.calcularPrecioFinal());
            System.out.println();
        }

        // Los mismos objetos vistos a traves de la interfaz
        System.out.println("--- Despacho (interfaz IntDespacho) ---");
        List<IntDespacho> despachos = new ArrayList<>();
        despachos.add((IntDespacho) prod1);
        despachos.add((IntDespacho) prod2);
        despachos.add((IntDespacho) prod3);
        despachos.add((IntDespacho) prod4);
        for (IntDespacho des : despachos) {
            System.out.println(des.obtenerTipoEmpaque() + " | Envio: S/ " + des.calcularCostoEnvio());
        }

        // Pruebas con resultados esperados
        System.out.println("\n--- Pruebas ---");
        verificar("Electronico menor a S/ 1000, precio final", prod1.calcularPrecioFinal(), 840.0);
        verificar("Electronico menor a S/ 1000, envio", ((IntDespacho) prod1).calcularCostoEnvio(), 15.0);
        verificar("Electronico desde S/ 1000, envio gratis", ((IntDespacho) prod2).calcularCostoEnvio(), 0.0);
        verificar("Alimenticio vence en 30 dias o menos", prod3.calcularPrecioFinal(), 96.0);
        verificar("Alimenticio vence en mas de 30 dias", prod4.calcularPrecioFinal(), 240.0);
    }

    private static void verificar(String caso, double obtenido, double esperado) {
        if (obtenido == esperado) {
            System.out.println(caso + ": correcto (S/ " + obtenido + ")");
        } else {
            System.out.println(caso + ": ERROR, se esperaba S/ " + esperado + " y salio S/ " + obtenido);
        }
    }
}
