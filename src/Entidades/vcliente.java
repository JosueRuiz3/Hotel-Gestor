
package Entidades;

import javax.swing.JComboBox;


public class vcliente extends vpersona{
   
    
    
    private String fecha_entrada;
    private String fecha_salida;
    private String numero_habitacion;
    private String tarifa_estadia;

    /**
     * metodo constructor sin parametros 
     */
    public vcliente() {
    }
    
/**
 * metodos constructor con parametros de tipos String
 * 
 * @param id_cliente 
 * @param nombre  
 * @param telefono 
 * @param fecha_entrada 
 * @param numero_habitacion 
 * @param tarifa_estadia 
 * @param fecha_salida  
 * 
 * 
 **/
        public vcliente(String id_cliente, String nombre, String telefono, String fecha_entrada, String numero_habitacion, String tarifa_estadia, String fecha_salida, String numero) {
        super(id_cliente,nombre,telefono);
        this.fecha_entrada = fecha_entrada;
        this.numero_habitacion = numero_habitacion;
        this.tarifa_estadia = tarifa_estadia;
        this.fecha_salida = fecha_salida;
        
    }

    /**
     * metodos set and get
     * @return 
     */

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(String numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public String getTarifa_estadia() {
        return tarifa_estadia;
    }

    public void setTarifa_estadia(String tarifa_estadia) {
        this.tarifa_estadia = tarifa_estadia;
    }  
}
