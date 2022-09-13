
package Atributos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    /**
 * Atributos para la conexion
 * user = "root";//Nombre del usuario
 * password = "";//contraseña que nosotros tenemos en el MySQL
 * url = "jdbc:mysql://localhost:3306/hotel";//El nombre del servidor 
   */
    static Statement sentencia;
    static ResultSet resultado;
    private final String user = "root";
    private final String password = "nombren07";
    private final String url = "jdbc:mysql://localhost:3306/hotel";//El nombre del servidor 
   
    /**
    *Metodo constructor para crear la conexion de la base de datos de MySQL
    **/
    public Conexion(){
        
    }
        Connection con = null;

        /**
         *  Class.forName("com.mysql.cj.jdbc.Driver");//Diver para conectar el MySQL con el NetBeans
         * 
         * @return retorna "con" que es la coneccion con la base de datos
         */
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
            /**
            * Crear las intrucciones SQL que contiene
            * los parámetros de conexión con la BD
            **/
            sentencia = con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        }
      return con;
    } 
    
    /**
     *  //  Array para poder llenar el jComboBox de la base de datos y mostralo en el JComboBox
     * @return lista, para asi mostrar el numero de la habitacion en el jComboBox
     *  String q = "SELECT * FROM habitacion"; Busca y selecciona la tabla de la base de datos
     *  lista.add(resultado.getString("numero_habitacion"));  Lo que desea que se vaya a mostrar en el JComboBox
     */
       public static ArrayList<String> llenar_combo() {
           ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM habitacion";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString("numero_habitacion"));
                           }
        } catch (Exception e) {
        }
        return lista;//Retorna lista
        
    }

       public void DesconectarBase(){
           try{
              con.close();
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ha ocurrido un error a la hora de cerrar la base de datos: "+e);
           }
               
       }
}
