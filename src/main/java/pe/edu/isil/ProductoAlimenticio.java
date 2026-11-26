package pe.edu.isil;

public class ProductoAlimenticio extends ProductoCategoria implements IntDespacho {
    private int diasParaVencer;

    public ProductoAlimenticio(String codigoSku, String nombre, double precioBase, int stock, int diasParaVencer) {
        super(codigoSku, nombre, precioBase, stock, "Alimenticio");
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    // 20% de descuento si vence en 30 dias o menos
    @Override
    public double calcularPrecioFinal() {
        if (diasParaVencer <= 30) {
            return getPrecioBase() - getPrecioBase() * 20 / 100;
        }
        return getPrecioBase();
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Vence en: " + diasParaVencer + " dias");
    }

    @Override
    public double calcularCostoEnvio() {
        return 10.0;
    }

    @Override
    public String obtenerTipoEmpaque() {
        return "Caja sellada";
    }
}
