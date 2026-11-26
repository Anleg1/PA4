package pe.edu.isil;

// Clase abstracta: un producto con categoria que calcula su propio precio final.
// No se puede instanciar; solo sus subclases (electronico y alimenticio).
public abstract class ProductoCategoria extends Producto {
    private String categoria;

    public ProductoCategoria(String codigoSku, String nombre, double precioBase, int stock, String categoria) {
        super(codigoSku, nombre, precioBase, stock);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    // Cada categoria calcula el precio final a su manera
    public abstract double calcularPrecioFinal();

    // Metodo concreto que las subclases amplian con super.mostrarDetalle()
    public void mostrarDetalle() {
        System.out.println(this);
        System.out.println("Categoria: " + categoria);
    }
}
