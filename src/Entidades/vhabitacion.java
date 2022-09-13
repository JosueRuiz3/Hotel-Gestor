
package Entidades;


public class vhabitacion {
    private String numero_habitacion;
    private String numero_personas;
    private String tarifa_estadia;
    private String disponible;

    /**
     *Metodo constructor basido 
     **/
    public vhabitacion() {
    }

    /**
     * metodo constructor con parametros
     * @param numero_habitacion Numero de la habitacion
     * @param numero_personas Cantidad de peronas que permite la habitacio
     * @param tarifa_estadia  tarifa de la habitacion
     * @param disponible  SI estara disponible o no disponible la habitacion
     **/
     
    public vhabitacion(String numero_habitacion, String numero_personas, String tarifa_estadia, String disponible) {
        this.numero_habitacion = numero_habitacion;
        this.numero_personas = numero_personas;
        this.tarifa_estadia = tarifa_estadia;
        this.disponible = disponible;
    }

    /**
     * metodos set and get
     * @return retorna el numero de habitacion, cantidad de personas,tarifa de la habitacion, disponible
     */
    
    public String getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(String numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public String getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(String numero_personas) {
        this.numero_personas = numero_personas;
    }

    public String getTarifa_estadia() {
        return tarifa_estadia;
    }

    public void setTarifa_estadia(String tarifa_estadia) {
        this.tarifa_estadia = tarifa_estadia;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }


    
    
    
}
