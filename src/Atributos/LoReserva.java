
package Atributos;


import Entidades.vcliente;
import Entidades.vreservacion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LoReserva {
     /**
     * Atribustos para hcaer la conexion con la base de datos
     **/
   private Conexion mysql=new Conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   private String sSQL2 = "";
   private String sSQL3 = "";
   public Integer totalregistros;
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;// define un modelo de tabla
       
        /**
         * Nombre de las columnas que se van a poder ver en la tabla 
         * Definir las columnas necesarias para mostrar lo datos de la BD
         **/ 
       String [] reservaciones = {"NUMERO RESERVA", "ID CLIENTE", "NOMBRE", "TELEFONO", "FECHA ENTRADA", "FECHA SALIDA", "NUMERO HABITACION","TARIFA HABITACION","TOTAL OTROS SERVICIOS","TATOL PAGAR"};
       
         //Contidad maxima de columnas que se van a mostrar en el la tabla
       String [] registro =new String [11];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,reservaciones);
       
       /**
       * Instruccion SQL que me permite poder mostrar el resgristro almacenado en la base de datos y mostrarlo en la tabla
       **/ 
      sSQL="SELECT numero_reservacion, id_cliente, nombre, telefono, fecha_entrada, fecha_salida, numero_habitacion, tarifa_estadia,total_otroservicios, total_a_pagar FROM reservaciones " ;

       try {
           
          /**
            *  instrucción ejecuta la orden sql para consultar
            * los datos de la BD Hotel la tabla clinete y me devuelve el resultado
            * de la consulta en el objeto 
            * ejecuto la instrucción SQL almacenada en la variable
            **/
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
          
           while(rs.next()){
                /**
                 *  Ejecute el contenido de la variable SQL y almacenada en el 
                 *  resultado de la consulta en la variable rs
                 */
               registro [0]=rs.getString("numero_reservacion");
               registro [1]=rs.getString("id_cliente");
               registro [2]=rs.getString("nombre");
               registro [3]=rs.getString("telefono");
               registro [4]=rs.getString("fecha_entrada");
               registro [5]=rs.getString("fecha_salida");
               registro [6]=rs.getString("numero_habitacion");
               registro [7]=rs.getString("tarifa_estadia");
               registro [8]=rs.getString("total_otroservicios");
               registro [9]=rs.getString("total_a_pagar");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);// Agregar el contenido del vector datos a la tabla.
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   public boolean insertar (vreservacion dts){
        /**
         *  Instruccion SQL que me permite insertar un registro a la base de datos y almacenarlo en tabla reservaciones
         */ 
       sSQL="insert into reservaciones (numero_reservacion, id_cliente, nombre, telefono, fecha_entrada, fecha_salida, numero_habitacion, tarifa_estadia, total_otroservicios, total_a_pagar )" +
               "values (?,?,?,?,?,?,?,?,?,?)";
       try {
           /**
             *  ejecuto la instrucción SQL almacenada en la variable y 
             *  Preparo para validar la indicación sql almacenada en la variable
             **/
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           /**
            *   Sustituye los signos de la interrogación sql
            *   por los valores que debería tomar
            **/
           
           pst.setString(1, dts.getNumero_reservacion());
           pst.setString(2, dts.getId_cliente());
           pst.setString(3, dts.getNombre());
           pst.setString(4, dts.getTelefono());
           pst.setString(5, dts.getFecha_entrada());
           pst.setString(6, dts.getFecha_salida());
           pst.setString(7, dts.getNumero_habitacion());
           pst.setString(8, dts.getTarifa_estadia());
           pst.setString(9, dts.getTotaOtrosServicion());
           pst.setString(10, dts.getTotalAPagar());

           
           int n=pst.executeUpdate();//ejecuta la instrucción SQL
                            
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
       return false;
   
   }

    
     public boolean eliminar(vcliente dts) {
         /**
          * Delete from elimina un registro de una tabla el where hace un delimitador para que solo se borre
          * ese registro 
          */
         
       sSQL = "delete from cliente where id_cliente=?";
       sSQL2 = "delete from persona where id_cliente=?";
       sSQL3 ="delete from reservaciones where id_cliente=?";

        try {
             /**
             *  ejecuto la instrucción SQL almacenada en la variable y 
             *  Preparo para validar la indicación sql almacenada en la variable
             **/
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            PreparedStatement pst3 = cn.prepareStatement(sSQL3);
 
            /**
            *   Sustituye los signos de la interrogación sql
            *   por los valores que debería tomar
            **/
            pst.setString(1, dts.getId_cliente());
            pst2.setString(1, dts.getId_cliente());
            pst3.setString(1, dts.getId_cliente());

            int n = pst.executeUpdate();//ejecuta la instrucción SQL
            
              if (n != 0) {
                int n2 = pst2.executeUpdate();//ejecuta la instrucción SQL
                int n3 = pst3.executeUpdate();//ejecuta la instrucción SQL

                if (n2 != 0) {
                    return true;

                }  if (n3 != 0) {
                    return true;

                }  else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
       
    }  
}
