
package Entidades;


public class vpersona {
    private String id_cliente;
    private String nombre;
    private String telefono;

    /**
     * metodo constructor sin parametros
     */
    public vpersona() {
    }

    /**
     * metodo constructor con parametros 
     * @param id_cliente
     * @param nombre
     * @param telefono 
     */
    public vpersona(String id_cliente, String nombre, String telefono) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
/**
 * 
 * @return id_cliente, nombre, telefono
 */
    public String getId_cliente () {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    
}
