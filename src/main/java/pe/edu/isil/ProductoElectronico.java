package pe.edu.isil;

public class ProductoElectronico extends ProductoCategoria implements IntDespacho {
    private int mesesGarantia;

    public ProductoElectronico(String codigoSku, String nombre, double precioBase, int stock, int mesesGarantia) {
        super(codigoSku, nombre, precioBase, stock, "Electronico");
        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    // Precio base + 5% de seguro contra danos
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + getPrecioBase() * 5 / 100;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Garantia: " + mesesGarantia + " meses");
    }

    // Envio gratis desde S/ 1000; si no, S/ 15
    @Override
    public double calcularCostoEnvio() {
        if (getPrecioBase() >= 1000) {
            return 0.0;
        }
        return 15.0;
    }

    @Override
    public String obtenerTipoEmpaque() {
        return "Caja con proteccion antigolpes";
    }
}
