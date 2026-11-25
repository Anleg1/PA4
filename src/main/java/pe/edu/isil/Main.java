package pe.edu.isil;


public class Main {
    public static void main(String[] args) {
        System.out.println("===INICIANDO SISTEMA DE INVENTARIO LOGÍSTICO===\n");

        Producto p1 = new Producto("SKU-001", "Monitor Dell 24 pulgadas", 650.00, 15);
        Producto p2 = new Producto("SKU-002", "Teclado Mecánico Redragon", 180.50, 30);
        Producto p3 = new Producto("SKU-003", "Laptop Lenovo ThinkPad E14", 3450.00, 8);
        Producto p4 = new Producto("SKU-004", "Mouse Inalámbrico Logitech MX", 320.00, 25);
        Producto p5 = new Producto("SKU-005", "Caja Leche Evaporada x24", 96.00, 50);
        Producto p6 = new Producto("SKU-006", "Saco Arroz Extra 50kg", 145.00, 12);
        Producto p7 = new Producto("SKU-007", "Audífonos Sony WH-1000XM5", 1190.00, 6);
        Producto p8 = new Producto("SKU-008", "Silla Ergonómica de Oficina", 580.00, 10);

        // Objetos con SKU duplicado
        Producto pDuplicado1 = new Producto("sku-001", "Monitor Dell Clonado", 500.00, 5);
        Producto pDuplicado2 = new Producto("SKU-005", "Leche Evaporada Repetida", 90.00, 10);

        // Registro de productos en el inventario (HashSet)
        Inventario inventario = new Inventario();

        System.out.println("--- Registro de productos ---");
        inventario.registrarProducto(p1);
        inventario.registrarProducto(p2);
        inventario.registrarProducto(p3);
        inventario.registrarProducto(p4);
        inventario.registrarProducto(p5);
        inventario.registrarProducto(p6);
        inventario.registrarProducto(p7);
        inventario.registrarProducto(p8);

        // Prueba de duplicados
        System.out.println("\n--- Prueba de duplicados ---");
        inventario.registrarProducto(pDuplicado1);
        inventario.registrarProducto(pDuplicado2);

        // Recorrido y visualizacion
        System.out.println();
        inventario.mostrarProductos();
        System.out.println("\nTotal de productos registrados: " + inventario.cantidadProductos());

        // ==========================================
        // BUSQUEDA Y ORDENAMIENTO - INTEGRANTE 3
        // ==========================================

        BusquedaOrdenamiento funciones =
                new BusquedaOrdenamiento(inventario);

        // 1. Buscar producto por SKU
        System.out.println("\n=== BUSQUEDA POR SKU ===");
        Producto encontrado = funciones.buscarPorSku("SKU-004");

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }

        // 2. Buscar productos por nombre
        System.out.println("\n=== BUSQUEDA POR NOMBRE ===");
        for (Producto p : funciones.buscarPorNombre("Mouse")) {
            System.out.println(p);
        }

        // 3. Ordenar productos por nombre
        System.out.println("\n=== ORDENAR POR NOMBRE ===");
        for (Producto p : funciones.ordenarPorNombre()) {
            System.out.println(p);
        }

        // 4. Ordenar productos por precio
        System.out.println("\n=== ORDENAR POR PRECIO ===");
        for (Producto p : funciones.ordenarPorPrecio()) {
            System.out.println(p);
        }

    }
}