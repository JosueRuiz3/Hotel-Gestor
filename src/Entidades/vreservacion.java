
package Entidades;

import java.util.ArrayList;


public class vreservacion extends vcliente{
    
    private String numero_reservacion;
    private String numero_habitacion;
    private ArrayList<vcliente> cliente;
    private ArrayList<vhabitacion> habitacion;
    private String totaOtrosServicion;
    private String TotalAPagar;
    
    public vreservacion() {
    }

    public vreservacion(String id_cliente, String nombre, String telefono,String fecha_entrada, String fecha_salida, String numero, String numero_habitacion, String totalOtrosServicios, String TotalAPagar, String numero_reservacion) {
        super(id_cliente, nombre, telefono, fecha_entrada, numero_habitacion, fecha_entrada, fecha_salida, numero);
        this.numero_habitacion = numero_habitacion;
        this.totaOtrosServicion = totaOtrosServicion;
        this.TotalAPagar = TotalAPagar;
        this.numero_reservacion = numero_reservacion;
    }

    public String getNumero_reservacion() {
        return numero_reservacion;
    }

    public void setNumero_reservacion(String numero_reservacion) {
        this.numero_reservacion = numero_reservacion;
    }

    public String getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(String numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public ArrayList<vcliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<vcliente> cliente) {
        this.cliente = cliente;
    }

    public ArrayList<vhabitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ArrayList<vhabitacion> habitacion) {
        this.habitacion = habitacion;
    }

    public String getTotaOtrosServicion() {
        return totaOtrosServicion;
    }

    public void setTotaOtrosServicion(String totaOtrosServicion) {
        this.totaOtrosServicion = totaOtrosServicion;
    }

    public String getTotalAPagar() {
        return TotalAPagar;
    }

    public void setTotalAPagar(String TotalAPagar) {
        this.TotalAPagar = TotalAPagar;
    }

    

}
