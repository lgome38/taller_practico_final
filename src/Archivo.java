import java.io.*;
import java.util.ArrayList; // Añadido el import de ArrayList
import java.util.List;

public class Archivo {

    // Leer productos desde un archivo de texto
    public static List<Producto> leerProductosDesdeArchivo(String ruta) {
        List<Producto> productos = new ArrayList<>(); // Usar ArrayList para crear la lista
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String id = datos[0];
                String nombre = datos[1];
                int cantidad = Integer.parseInt(datos[2]);
                double precio = Double.parseDouble(datos[3]);
                productos.add(new Producto(id, nombre, cantidad, precio));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return productos;
    }

    // Escribir productos en un archivo de texto
    public static void escribirProductosEnArchivo(String ruta, List<Producto> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Producto producto : productos) {
                bw.write(producto.getId() + "," + producto.getNombre() + "," + producto.getCantidad() + "," + producto.getPrecio());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
