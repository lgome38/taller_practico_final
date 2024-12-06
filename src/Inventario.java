import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

     

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Actualizar producto
    public boolean actualizarProducto(String id, int nuevaCantidad, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.setCantidad(nuevaCantidad);
                return true;
            }
        }
        return false;
    }

    // Eliminar producto
    public boolean eliminarProducto(String id) {
        return productos.removeIf(producto -> producto.getId().equals(id));
    }

    // Calcular cantidad total de productos
    public int calcularCantidadTotal() {
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getCantidad();
        }
        return total;
    }

    // Producto más costoso
    public Producto productoMasCostoso() {
        if (productos.isEmpty()) {
            return null;
        }
        Producto max = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getPrecio() > max.getPrecio()) {
                max = producto;
            }
        }
        return max;
    }

    // Generar reporte
    public void generarReporte() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        for (Producto producto : productos) {
            System.out.println(producto);

        }
    }
    public static void funcionSalir() {
        System.out.println("\n!Gracias¡");
        System.exit(0);
    }

    }
