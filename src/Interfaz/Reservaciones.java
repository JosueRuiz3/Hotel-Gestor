package Interfaz;

import Entidades.vcliente;
import Entidades.vreservacion;
import Atributos.Conexion;
import Atributos.LoCliente;
import Atributos.LoReserva;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Reservaciones extends javax.swing.JDialog {

    Principal principal = new Principal();
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar(); 
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
     
    public Reservaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        mostrar("");
        ajustarTabla();
         
          //cambia la imagen de la tacita de cafe
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Reservacion.png")).getImage());
        
              jButton_Atras.setIcon(setIcono("/Imagenes/Atras.png", jButton_Atras));
        //A la hora de precionar haga un enfoque de click
        jButton_Atras.setPressedIcon(setIconoPresionado("/Imagenes/Atras.png",jButton_Atras,2,2));
        
        jButton_Guardar.setIcon(setIcono("/Imagenes/Guardar.png", jButton_Guardar));
        //A la hora de precionar haga un enfoque de click
        jButton_Guardar.setPressedIcon(setIconoPresionado("/Imagenes/Guardar.png",jButton_Guardar,2,2));
        
        jButton_Cancelar.setIcon(setIcono("/Imagenes/Cancelar.png", jButton_Cancelar));
        //A la hora de precionar haga un enfoque de click
        jButton_Cancelar.setPressedIcon(setIconoPresionado("/Imagenes/Cancelar.png",jButton_Cancelar,2,2));
          jButton_eliminar.setIcon(setIcono("/Imagenes/Borrar.png", jButton_eliminar));
          
        //A la hora de precionar haga un enfoque de click
        jButton_eliminar.setPressedIcon(setIconoPresionado("/Imagenes/Borrar.png",jButton_eliminar,2,2));
        
           jButton_editar.setIcon(setIcono("/Imagenes/Updatee.png", jButton_editar));
        //A la hora de precionar haga un enfoque de click
        jButton_editar.setPressedIcon(setIconoPresionado("/Imagenes/Updatee.png",jButton_editar,2,2));
       
        
        //Llama el Array  del paquete Logica de la clase conexion para poder mostralo y ejecutarlo       
         jComboBox_Numhabi.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = Conexion.llenar_combo();
        for(int i = 0; i<lista.size();i++){//Para que solo aparescan de uno en uno el numero de habitaciones y no todo juntos
            jComboBox_Numhabi.addItem(lista.get(i));
            
        }
    }

      //Llama la clase LoClinete  para poder mostrarlo en pantalla
   void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            LoReserva func = new LoReserva();
            modelo = func.mostrar(buscar);

            jTable_reserva.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
   
    private String accion = "guardar";
       
    
    //Limpia todos los campos de las casillas
      void limpiarCampos(){
       
       jTextField_Numresevacion.setText("");
       jTextField_Idcliente.setText("");
       jTextField_Nombre.setText("");
       jTextField_telefono.setText("");
       jTextField_entrada.setText("");
       jTextField_salida.setText("");
       jComboBox_Numhabi.setSelectedItem("");
       jTextField_Tarifa.setText("");
       jTextField_OtrosServicios.setText("");
       jTextField_TotalPagar.setText("");
     
       }
          public void ajustarTabla(){
        // Adaptar el ancho de las columnas
        // Necesito accesar a las características de cada columna
        TableColumnModel columnModel = jTable_reserva.getColumnModel();
        // Defino el ancho de cada columnas desde la 0..9
        columnModel.getColumn(0).setPreferredWidth(1);     // Col. Num.Reservacio
        columnModel.getColumn(1).setPreferredWidth(10);    // Col. Id.Cliente
        columnModel.getColumn(2).setPreferredWidth(100);    // Col. Nombre
        columnModel.getColumn(3).setPreferredWidth(10);    // Col. Teléfono
        columnModel.getColumn(4).setPreferredWidth(10);    // Col. fecha entrada
        columnModel.getColumn(5).setPreferredWidth(10);    // Col. fecha salida
        columnModel.getColumn(6).setPreferredWidth(10);    // Col. Num.Habitacion
        columnModel.getColumn(7).setPreferredWidth(20);    // Col. Tarifa
        columnModel.getColumn(8).setPreferredWidth(20);    // Col. Otros servicios
        columnModel.getColumn(9).setPreferredWidth(20);    // Col. Total a pagar

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_reserva = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_Atras = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Numresevacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Idcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_entrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_salida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_Numhabi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Tarifa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_OtrosServicios = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_TotalPagar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hotel Java");

        jPanel1.setBackground(new java.awt.Color(36, 54, 67));

        jTable_reserva.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable_reserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_reserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_reservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_reserva);

        jPanel2.setBackground(new java.awt.Color(36, 54, 67));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton_Cancelar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });

        jButton_Atras.setBackground(new java.awt.Color(36, 54, 67));
        jButton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtrasActionPerformed(evt);
            }
        });

        jButton_Guardar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jButton_eliminar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jButton_editar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1241, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(36, 54, 67));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Num.Reser");

        jTextField_Numresevacion.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Numresevacion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Numresevacion.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Numresevacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NumresevacionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Cliente");

        jTextField_Idcliente.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Idcliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Idcliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Idcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdclienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jTextField_Nombre.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Nombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");

        jTextField_telefono.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_telefono.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telefonoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Entrada ");

        jTextField_entrada.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_entrada.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_entrada.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_entradaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Salida");

        jTextField_salida.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_salida.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_salida.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_salidaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Num.Habitacion");

        jComboBox_Numhabi.setBackground(new java.awt.Color(82, 79, 79));
        jComboBox_Numhabi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox_Numhabi.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Numhabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NumhabiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tarifa");

        jTextField_Tarifa.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Tarifa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Tarifa.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Tarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TarifaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Otros servicios");

        jTextField_OtrosServicios.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_OtrosServicios.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_OtrosServicios.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_OtrosServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_OtrosServiciosActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total a Pagar");

        jTextField_TotalPagar.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_TotalPagar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_TotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_TotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TotalPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Numhabi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField_Numresevacion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_OtrosServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_TotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(194, 194, 194))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Numresevacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_OtrosServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Numhabi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
               this.setVisible(false);

    }//GEN-LAST:event_jButton_AtrasActionPerformed

    private void jTextField_NumresevacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NumresevacionActionPerformed
       
        jTextField_Numresevacion.transferFocus();
        
    }//GEN-LAST:event_jTextField_NumresevacionActionPerformed

    private void jTextField_IdclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdclienteActionPerformed

        jTextField_Idcliente.transferFocus();
    }//GEN-LAST:event_jTextField_IdclienteActionPerformed

    private void jTextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NombreActionPerformed
        jTextField_Nombre.transferFocus();
    }//GEN-LAST:event_jTextField_NombreActionPerformed

    private void jTextField_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_telefonoActionPerformed
       jTextField_telefono.transferFocus();
    }//GEN-LAST:event_jTextField_telefonoActionPerformed

    private void jTextField_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_entradaActionPerformed

         jTextField_entrada.transferFocus();
    }//GEN-LAST:event_jTextField_entradaActionPerformed

    private void jTextField_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_salidaActionPerformed

         jTextField_salida.transferFocus();
    }//GEN-LAST:event_jTextField_salidaActionPerformed

    private void jComboBox_NumhabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NumhabiActionPerformed
 
     /**
     * Cuando precionamos el JComboBox aparecen las habitaciones, cuando seleccionamos la 
     * habitacion hace que aparescan los datos que contenga esa habitacion, en ese caso lo que
     * queremos que se muestre es la tarifa de esa habitacion y la vaya a mostrar en el JTextField
     **/
        
        try{
          String sql = "SELECT  * FROM habitacion where numero_habitacion=?";
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1, (String)jComboBox_Numhabi.getSelectedItem());
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
             jTextField_Tarifa.setText(rs.getString("tarifa_estadia"));
           }
           pst.close();
           
        }catch(Exception e){
         e.printStackTrace();
        }
       jComboBox_Numhabi.transferFocus();
    }//GEN-LAST:event_jComboBox_NumhabiActionPerformed

    private void jTextField_TarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TarifaActionPerformed

             jTextField_Tarifa.transferFocus();

    }//GEN-LAST:event_jTextField_TarifaActionPerformed

    private void jTextField_OtrosServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_OtrosServiciosActionPerformed

        /**
         * Conversion de String a Integer para suma de otros servicios y tarifa 
         **/
      String a = jTextField_Tarifa.getText();
      String b = jTextField_OtrosServicios.getText();
      
      int sum1 = Integer.parseInt(a);
      int sum2 = Integer.parseInt(b);
      
      int resultado = sum1 + sum2;  
      /**
       * Muesta el resultado en la caja de texto
       **/
      jTextField_TotalPagar.setText(Integer.toString(resultado));
      
      jTextField_OtrosServicios.transferFocus();

    }//GEN-LAST:event_jTextField_OtrosServiciosActionPerformed

    private void jTextField_TotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TotalPagarActionPerformed

         jTextField_TotalPagar.transferFocus();
    }//GEN-LAST:event_jTextField_TotalPagarActionPerformed

    private void jTable_reservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_reservaMouseClicked

          //Hace click en un filas de la tablas y las selecciona en las casillas correspondiente
      int fila = jTable_reserva.rowAtPoint(evt.getPoint());

   //    jTextField_Numresevacion.setText(jTable_reserva.getValueAt(fila, 0).toString());
        jTextField_Idcliente.setText(jTable_reserva.getValueAt(fila, 1).toString());
        jTextField_Nombre.setText(jTable_reserva.getValueAt(fila, 2).toString());
        jTextField_telefono.setText(jTable_reserva.getValueAt(fila, 3).toString());
        jTextField_entrada.setText(jTable_reserva.getValueAt(fila, 4).toString());
        jTextField_salida.setText(jTable_reserva.getValueAt(fila, 5).toString());
        jComboBox_Numhabi.setSelectedItem(jTable_reserva.getValueAt(fila, 6).toString());
        jTextField_Tarifa.setText(jTable_reserva.getValueAt(fila, 7).toString());
//       jTextField_OtrosServicios.setText(jTable_reserva.getValueAt(fila, 8).toString());
//       jTextField_TotalPagar.setText(jTable_reserva.getValueAt(fila, 9).toString());
        
        
    }//GEN-LAST:event_jTable_reservaMouseClicked

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        /**
         * Elimina registros de la base de datos
         **/
        if (!jTextField_Idcliente.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Cliente?","Confirmar",2);

            if (confirmacion==0) {
                LoReserva co = new LoReserva();
                vreservacion dts= new vreservacion();

                dts.setId_cliente(String.valueOf(jTextField_Idcliente.getText()));
                co.eliminar(dts);
                mostrar("");
                limpiarCampos();
      
            }

          }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
                
        /**
            * Editar los campos de las tablas
            **/
            try{
            String numero_reservacion = jTextField_Numresevacion.getText();
            String id_cliente = jTextField_Idcliente.getText();
            String nombre = jTextField_Nombre.getText(); 
            String telefono = jTextField_telefono.getText();
            String fecha_entrada = jTextField_entrada.getText();
            String fecha_salida = jTextField_salida.getText();
            String numero_habitacion = (String) jComboBox_Numhabi.getSelectedItem();
            String tarifa_estadia = jTextField_Tarifa.getText();
            String otroservicios = jTextField_OtrosServicios.getText();
            String total = jTextField_TotalPagar.getText();
            
             /**
             * Instruccion String SQL que me permite editar la tablas cliente y reservaciones
             **/
            
             String sSQL ="Update cliente set id_cliente ='"+id_cliente+"',"
                    + "nombre ='"+nombre+"',telefono='"+telefono+"',fecha_entrada='"+fecha_entrada+"',fecha_salida='"+fecha_salida+"',numero_habitacion='"+numero_habitacion+"',"
                    + "tarifa_estadia ='"+tarifa_estadia+"' WHERE id_cliente='"+id_cliente+"'";
        
            String sSQL3 ="Update reservaciones set numero_reservacion='"+numero_reservacion+"',id_cliente ='"+id_cliente+"',"
                    + "nombre ='"+nombre+"',telefono='"+telefono+"',fecha_entrada='"+fecha_entrada+"',fecha_salida='"+fecha_salida+"',numero_habitacion='"+numero_habitacion+"',"
                    + "tarifa_estadia ='"+tarifa_estadia+"',total_otroservicios='"+otroservicios+"',total_a_pagar='"+total+"'WHERE id_cliente='"+id_cliente+"'";
             
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst3=cn.prepareStatement(sSQL3);
         
            
            /**
             * Ejecuta los parametros
             */
            pst.execute();
            pst3.execute();
            mostrar("");
            JOptionPane.showMessageDialog(null, "Se ha modificado con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }

        jTextField_Idcliente.requestFocus();
        limpiarCampos();
    }//GEN-LAST:event_jButton_editarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reservaciones dialog = new Reservaciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
 public Icon setIcono(String url,JButton boton ){//adapta el icono a la altura o ancho que uno quiera
     ImageIcon icon = new ImageIcon(getClass().getResource(url));
     
     int ancho = boton.getWidth();
     
     int alto = boton.getHeight();
     
     ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho,alto,Image.SCALE_DEFAULT));
     
     return icono;
    }
    //Hace como un click hacia abajo a la hora de tocar la casilla
    public Icon setIconoPresionado(String url, JButton boton, int ancho, int altura){
    
    ImageIcon icon = new ImageIcon(getClass().getResource(url));
    int width = boton.getWidth() - ancho;
    int height = boton.getHeight() - altura;
    
    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
     return icono;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Atras;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_Numhabi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_reserva;
    private javax.swing.JTextField jTextField_Idcliente;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_Numresevacion;
    private javax.swing.JTextField jTextField_OtrosServicios;
    private javax.swing.JTextField jTextField_Tarifa;
    private javax.swing.JTextField jTextField_TotalPagar;
    private javax.swing.JTextField jTextField_entrada;
    private javax.swing.JTextField jTextField_salida;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables
}
