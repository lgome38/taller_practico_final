public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private double precio;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    // Constructor
    public Producto(String id, String nombre, int cantidad, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria=categoria;
    }

    // Métodos getter
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Método toString para representar el objeto
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }

    public static void main(String[] args) {
        // Crear una instancia de Producto
        Producto producto1 = new Producto("001", "Laptop", 5, 1500.50);

        // Imprimir el producto
        System.out.println(producto1);
    }
}
