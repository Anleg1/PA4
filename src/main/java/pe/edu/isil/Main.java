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

        // Impresión de verificación
        System.out.println("Vista previa de objetos:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);

    }
}