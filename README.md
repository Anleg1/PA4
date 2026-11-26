# PA4 - Sistema de Inventario Logístico

Programa en Java por consola para manejar el inventario de un almacén.
Los productos se registran en un HashSet que no acepta SKU repetidos. Después se recorren, se buscan y se ordenan.
Para separar los productos por categoría usamos herencia, una clase abstracta, una interfaz y sobrescritura de métodos.

## Integrantes

| Integrante | GitHub | Parte |
|---|---|---|
| Miguel Angel Caycho Roque | Anleg1 | 1. Diseño y estructura |
| Jorge Jerson Benito Mayhua | Jorge-ben | 2. Colecciones y registro de objetos |
| Franco Andrés Diaz Carreal | FrancoDC005 | 3. Búsqueda y ordenamiento |
| David Jared Damazo Valdeos | davidjdv14-jm11 | 4. Herencia, interfaz y entrega |

## Diseño adoptado

```
                 Producto
     (sku, nombre, precioBase, stock)
                    |
                    | extends
                    |
       ProductoCategoria (abstracta)          IntDespacho (interfaz)
       + calcularPrecioFinal()  (abstracto)   + calcularCostoEnvio()
       + mostrarDetalle()                     + obtenerTipoEmpaque()
                    |                                   |
          +---------+----------+                        |
          |                    |                        |
  ProductoElectronico   ProductoAlimenticio  <----------+
   - mesesGarantia       - diasParaVencer     (ambas implementan la interfaz)
```

- **Producto** es la clase base. Tiene el SKU, el nombre, el precio y el stock.
- **ProductoCategoria** es abstracta porque cada categoría calcula su precio final de una forma distinta. No tiene sentido crear un producto "con categoría" sin saber cuál es, por eso `new ProductoCategoria(...)` no compila.
- **ProductoElectronico** y **ProductoAlimenticio** heredan de ProductoCategoria. Llaman a `super(...)` en su constructor y sobrescriben con `@Override`:
  - `calcularPrecioFinal()`:
    - Electrónico: precio base + 5% de seguro.
    - Alimenticio: 20% de descuento si vence en 30 días o menos.
  - `mostrarDetalle()`: llama a `super.mostrarDetalle()` y agrega la garantía o los días para vencer.
- **IntDespacho** es una interfaz porque cualquier producto que salga del almacén necesita un costo de envío y un tipo de empaque, sin importar su categoría. Las dos subclases heredan de una clase e implementan la interfaz al mismo tiempo.
- Como las subclases también son `Producto`, se registran en el mismo `Inventario` y aparecen en las búsquedas y en los ordenamientos.

### Clases

| Clase | Qué hace |
|---|---|
| `Producto.java` | Clase base del producto, con `equals` y `hashCode` por SKU. |
| `Inventario.java` | Guarda los productos en un HashSet, los registra y los muestra. |
| `BusquedaOrdenamiento.java` | Busca por SKU y por nombre, y ordena por nombre y por precio. |
| `ProductoCategoria.java` | Clase abstracta con el método abstracto `calcularPrecioFinal()`. |
| `IntDespacho.java` | Interfaz con `calcularCostoEnvio()` y `obtenerTipoEmpaque()`. |
| `ProductoElectronico.java` | Subclase con garantía; sobrescribe el precio final, el detalle y el despacho. |
| `ProductoAlimenticio.java` | Subclase con días para vencer; sobrescribe el precio final, el detalle y el despacho. |
| `PruebaHerencia.java` | Registra los productos con categoría, los recorre y prueba los resultados. |
| `Main.java` | Punto de entrada: registro, búsqueda, ordenamiento y herencia. |

## Instrucciones de ejecución

Requisitos: JDK 21 e IntelliJ IDEA.

1. En IntelliJ, ir a **File → New → Project from Version Control**, pegar el enlace de este repositorio y hacer clic en **Clone**.
2. Esperar a que IntelliJ termine de cargar el proyecto Maven (barra de abajo).
3. Abrir `src/main/java/pe/edu/isil/Main.java`.
4. Hacer clic en el botón verde ▶ al lado de `public class Main` y elegir **Run 'Main.main()'**.
5. El resultado aparece en la consola de abajo.

### Resultados esperados de las pruebas de herencia

| Caso | Esperado |
|---|---|
| Impresora de S/ 800: precio final | S/ 840.0 |
| Impresora de S/ 800: envío | S/ 15.0 |
| Tablet de S/ 1500: envío | S/ 0.0 |
| Yogurt que vence en 15 días: precio final | S/ 96.0 |
| Atún que vence en 90 días: precio final | S/ 240.0 |

Cada caso debe decir "correcto" en la consola.

## Evidencias

- [Consola: herencia, clase abstracta, interfaz y pruebas](evidencias/consola-herencia.png)

## Video de exposición

https://youtu.be/ENLACE_DEL_VIDEO
