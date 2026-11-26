package pe.edu.isil;

// Interfaz: lo que todo producto debe definir para ser despachado
public interface IntDespacho {
    double calcularCostoEnvio();

    String obtenerTipoEmpaque();
}
