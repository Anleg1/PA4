package pe.edu.isil;

import java.util.Objects;

public class Producto {
    protected String codigoSku;
    protected String nombre;
    protected double precioBase;
    protected int stock;

    public Producto(String codigoSku, String nombre, double precioBase, int stock) {
        this.codigoSku = codigoSku;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Getters y Setters
    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Precio Base: S/ %.2f | Stock: %d unidades",
                codigoSku, nombre, precioBase, stock);
    }

    // Dos productos son iguales si tienen el mismo SKU (sin importar mayusculas/minusculas).
    // Esto permite que el HashSet detecte los registros duplicados.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto otro = (Producto) obj;
        return codigoSku.equalsIgnoreCase(otro.codigoSku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoSku.toUpperCase());
    }
}
