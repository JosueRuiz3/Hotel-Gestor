
package Atributos;
    
import Entidades.vcliente;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;  

public class LoCliente {
  
    /**
     * Atribustos para hcaer la conexion con la base de datos
     **/
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar(); 
    private String sSQL = "";
    private String sSQL2 = "";
     private String sSQL3 = "";
    private String lista= "";
    public Integer totalregistros;
   
    
 public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo; // define un modelo de tabla

        /**
         * Nombre de las columnas que se van a poder ver en la tabla 
         * Definir las columnas necesarias para mostrar lo datos de la BD
         **/    
        String[] cliente = {"ID CLIENTE", " NOMBRE", "TELEFONO", "FECHA ENTRADA", "FECHA SALIDA", "NUMERO HABITACION", "TARIFA ESTADIA"};

        //Contidad maxima de columnas que se van a mostrar en el la tabla
            String[] registro = new String[10];
            

            totalregistros = 0;
            modelo = new DefaultTableModel(null,cliente);  // Captura las atributos de la Jtable
           /**
            * Instruccion SQL que me permite poder mostrar el resgristro almacenado en la base de datos y mostrarlo en la tabla
            */ 
           sSQL = "SELECT id_cliente, nombre, telefono, fecha_entrada, fecha_salida, numero_habitacion,"
                      + " tarifa_estadia FROM cliente" ;//Muestra los datos que se almacena en la tabla cliente de la base de datos hotel 
        
       try {
           /**
            *  instrucción ejecuta la orden sql para consultar
            * los datos de la BD Hotel la tabla clinete y me devuelve el resultado
            * de la consulta en el objeto 
            * ejecuto la instrucción SQL almacenada en la variable
            **/
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sSQL);
            

            while (rs.next()) {
                /**
                 *  Ejecute el contenido de la variable SQL y almacenada en el 
                 *  resultado de la consulta en la variable rs
                 */               
                registro[0] = rs.getString("id_cliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("fecha_entrada");
                registro[4] = rs.getString("fecha_salida");
                registro[5] = rs.getString("numero_habitacion");
                registro[6] = rs.getString("tarifa_estadia");
             
                totalregistros = totalregistros + 1;
                modelo.addRow(registro); // Agregar el contenido del vector datos a la tabla.
                 

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
     
 }

 
 
    public boolean insertar(vcliente dts) {
        /**
         *  Instruccion SQL que me permite insertar un registro a la base de datos y almacenarlo en tabla cliente
         *  Instruccion SQL que me permite insertar un registro a la base de datos y almacenarlo en tabla persona
         *  Instruccion SQL que me permite insertar un registro a la base de datos y almacenarlo en tabla reservaciones
         */  
        sSQL = "insert into cliente (id_cliente,nombre,telefono,fecha_entrada,fecha_salida,numero_habitacion,tarifa_estadia)"
                + "values (?,?,?,?,?,?,?)";
      
           sSQL2 = "INSERT INTO persona(id_cliente, nombre, telefono)"
                   + "VALUES (?,?,?)";
           
            sSQL3 = "insert into reservaciones (id_cliente,nombre,telefono,fecha_entrada,fecha_salida,numero_habitacion,tarifa_estadia)"
                + "values (?,?,?,?,?,?,?)";
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
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getFecha_entrada());
            pst.setString(5, dts.getFecha_salida());
            pst.setString(6, dts.getNumero_habitacion()); 
            pst.setString(7, dts.getTarifa_estadia());     

            pst2.setString(1, dts.getId_cliente());
            pst2.setString(2, dts.getNombre());
            pst2.setString(3, dts.getTelefono());
            
            pst3.setString(1, dts.getId_cliente());
            pst3.setString(2, dts.getNombre());
            pst3.setString(3, dts.getTelefono());
            pst3.setString(4, dts.getFecha_entrada());
            pst3.setString(5, dts.getFecha_salida());
            pst3.setString(6, dts.getNumero_habitacion()); 
            pst3.setString(7, dts.getTarifa_estadia());
            

            int n = pst.executeUpdate();//ejecuta la instrucción SQL
            
             if (n != 0) {
                int n2 = pst2.executeUpdate();//ejecuta la instrucción SQL
                int n3 = pst3.executeUpdate();//ejecuta la instrucción SQL

                if (n2 != 0) {
                    return true;

                } if (n3 != 0) {
                    return true;

                } else {
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

            int n = pst.executeUpdate();
            
              if (n != 0) {
                int n2 = pst2.executeUpdate();
                int n3 = pst3.executeUpdate();

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
