
package Atributos;
import Entidades.vhabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Atributos.Conexion;
import java.io.File;

public class LoHabi {
    
     /**
     * Atribustos para hcaer la conexion con la base de datos
     **/
   private Conexion mysql=new Conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
      
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;// define un modelo de tabla
       
        /**
        * los nombres de las columnas que se quuiere mostrar
        **/
       String [] habitacion = {"NUMERO HABITACION","NUMERO PERSONAS","TARIFA HABITACION","DISPONIBLE"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,habitacion);
      
       /**
        * Instruccion sSQL que trae los datos de la base de datos y los muetra en pantalla
        **/
       sSQL="SELECT numero_habitacion, numero_personas, tarifa_estadia, disponible FROM habitacion" ;
    
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
                 *  Ejecute el contenido de la variable SQL y almacenanda en el 
                 *  resultado de la consulta en la variable rs
                 */
               registro [0]=rs.getString("numero_habitacion");
               registro [1]=rs.getString("numero_personas");
               registro [2]=rs.getString("tarifa_estadia");
               registro [3]=rs.getString("disponible");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);// Agregar el contenido del vector datos a la tabla.
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
     public boolean insertar (vhabitacion dts){
         
         /**
         *  Instruccion SQL que me permite insertar un registro a la base de datos y almacenarlo en tabla habitacion
         */  
       sSQL="insert into habitacion (numero_habitacion,numero_personas,tarifa_estadia, disponible)" +
               "values (?,?,?,?)";

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
           pst.setString(1, dts.getNumero_habitacion());
           pst.setString(2, dts.getNumero_personas());
           pst.setString(3, dts.getTarifa_estadia());
           pst.setString(4, dts.getDisponible());
          
           
           int n=pst.executeUpdate();//ejecuta la instrucción SQL
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   
   }
 
   public boolean eliminar (vhabitacion dts){
       
       /**
          * Delete from elimina un registro de una tabla el where hace un delimitador para que solo se borre
          * ese registro 
          */
       sSQL="delete from habitacion where numero_habitacion=?";
       
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
           pst.setString(1, dts.getNumero_habitacion());
           
           int n=pst.executeUpdate();//ejecuta la instrucción SQL
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }


    }
  
   

