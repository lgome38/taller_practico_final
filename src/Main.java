import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        String archivo = "productos.txt";

        // Cargar productos desde archivo
        inventario.agregarProducto(new Producto("001", "Producto A", 10, 100.0));
        inventario.agregarProducto(new Producto("002", "Producto B", 5, 200.0));
        inventario.agregarProducto(new Producto("003", "Producto C", 7, 150.0));

        while (true) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Ver Inventario");
            System.out.println("5. Ver Producto más Costoso");
            System.out.println("6. Calcular Cantidad Total");
            System.out.println("7. Guardar y Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    inventario.agregarProducto(new Producto(id, nombre, cantidad, precio));
                    break;

                case 2:
                    System.out.print("ID del producto a actualizar: ");
                    String idActualizar = scanner.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    if (inventario.actualizarProducto(idActualizar, nuevaCantidad, nuevoPrecio)) {
                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID del producto a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    if (inventario.eliminarProducto(idEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    inventario.generarReporte();
                    break;

                case 5:
                    Producto masCostoso = inventario.productoMasCostoso();
                    if (masCostoso != null) {
                        System.out.println("Producto más costoso: " + masCostoso);
                    } else {
                        System.out.println("No hay productos en el inventario.");
                    }
                    break;

                case 6:
                    int cantidadTotal = inventario.calcularCantidadTotal();
                    System.out.println("Cantidad total de productos: " + cantidadTotal);
                    break;

                case 7:
                    // Guardar cambios en archivo y salir
                    System.out.println("Datos guardados. Salida.");
                    //Archivo.escribirProductosEnArchivo(archivo, inventario.getProductos());
                    return;

                case 8:
                    inventario.funcionSalir();

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
