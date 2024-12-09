package entidad;
public class Divisa {
    private int id;
    private String nombre;
    private double compra;
    private double venta;
    private boolean status;

    // Constructor, getters y setters
    public Divisa(int id, String nombre, double compra, double venta, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.compra = compra;
        this.venta = venta;
        this.status = status;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getCompra() {return compra;}

    public void setCompra(double compra) {this.compra = compra;}

    public double getVenta() {return venta;}

    public void setVenta(double venta) {this.venta = venta;}

    public boolean isStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    @Override
    public String toString() {
        return "Divisa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compra=" + compra +
                ", venta=" + venta +
                ", status=" + status +
                '}';
    }
}
