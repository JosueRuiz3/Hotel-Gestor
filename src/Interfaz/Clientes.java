/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Entidades.vcliente;
import Atributos.Conexion;
import Atributos.LoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Clientes extends javax.swing.JDialog {
/**
 *  Crear atributos para la conexión
 */
    Principal principal = new Principal();
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar(); 
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    public Integer totalregistros;
     
    

    public Clientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        //Mostrar en pantalla los que se almacena en la base de datos
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
        
        jButton_cancelar.setIcon(setIcono("/Imagenes/Cancelar.png", jButton_cancelar));
        //A la hora de precionar haga un enfoque de click
        jButton_cancelar.setPressedIcon(setIconoPresionado("/Imagenes/Cancelar.png",jButton_cancelar,2,2));
        
          jButton_eliminar.setIcon(setIcono("/Imagenes/Borrar.png", jButton_eliminar));
        //A la hora de precionar haga un enfoque de click
        jButton_eliminar.setPressedIcon(setIconoPresionado("/Imagenes/Borrar.png",jButton_eliminar,2,2));
     
          jButton_editar.setIcon(setIcono("/Imagenes/Updatee.png", jButton_editar));
        //A la hora de precionar haga un enfoque de click
        jButton_editar.setPressedIcon(setIconoPresionado("/Imagenes/Updatee.png",jButton_editar,2,2));
       
        //Llama el Array  del paquete Logica de la clase conexion para poder mostralo y ejecutarlo
       jComboBox_NumHabita.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = Conexion.llenar_combo();
        for(int i = 0; i<lista.size();i++){//Para que solo aparescan de uno en uno el numero de habitaciones y no todo juntos
            jComboBox_NumHabita.addItem(lista.get(i));
            
        }
        
        
    }

 /**
  * 
  * @param buscar Busca dentro de la clase LoCliente y lo muestra en pantalla lo que esta
  * almacenado en la base de datos
  * 
  **/
   void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            LoCliente func = new LoCliente();
            modelo = func.mostrar(buscar);

            jTable_cliente.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
   
    private String accion = "guardar";
       
    /**
    *  Limpia todos los campos de las casillas
    **/
      void limpiarCampos(){
      jTextField_Id.setText("");
       jTextField_nombre.setText("");
       jTextField_Telefono.setText("");
       jTextField_FechaEntrada.setText("");
       jTextField_FechaSalida.setText("");
       jComboBox_NumHabita.setSelectedItem("");
       jTextField_TariHabi.setText("");
     
       }
/**
 * 
 **/
        public void ajustarTabla(){
            /**
             * Adaptar el ancho de las columnas
             * Necesito accesar a las características de cada columna
             **/  
        TableColumnModel columnModel = jTable_cliente.getColumnModel();
        // Defino el ancho de cada columnas desde la 0..9
        columnModel.getColumn(0).setPreferredWidth(1);     // Col. Id.Cliente
        columnModel.getColumn(1).setPreferredWidth(100);    // Col. Nombre
        columnModel.getColumn(2).setPreferredWidth(50);    // Col. Teléfono
        columnModel.getColumn(3).setPreferredWidth(10);    // Col. fecha entrada
        columnModel.getColumn(4).setPreferredWidth(10);    // Col. fecha salida
        columnModel.getColumn(5).setPreferredWidth(10);    // Col. Num.Habitacion
        columnModel.getColumn(6).setPreferredWidth(10);    // Col. tarifa
       
    }
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton_Atras = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_cliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel_FechaSalida = new javax.swing.JLabel();
        jTextField_FechaEntrada = new javax.swing.JTextField();
        jLabel_FechaEntrada1 = new javax.swing.JLabel();
        jTextField_FechaSalida = new javax.swing.JTextField();
        jLabel_NumeroHabitacion = new javax.swing.JLabel();
        jLabel_NumeroHabitacion1 = new javax.swing.JLabel();
        jTextField_TariHabi = new javax.swing.JTextField();
        jComboBox_NumHabita = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hotel Java");

        jPanel1.setBackground(new java.awt.Color(36, 54, 67));

        jPanel2.setBackground(new java.awt.Color(36, 54, 67));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton_Atras.setBackground(new java.awt.Color(36, 54, 67));
        jButton_Atras.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Atras.setToolTipText("Volver a la pantalla principal");
        jButton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtrasActionPerformed(evt);
            }
        });

        jButton_Guardar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_Guardar.setToolTipText("Guardar Informacion");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jButton_cancelar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_cancelar.setToolTipText("Cancelar y limpiar campos");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jButton_eliminar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_eliminar.setToolTipText("Cancelar y limpiar campos");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jButton_editar.setBackground(new java.awt.Color(36, 54, 67));
        jButton_editar.setToolTipText("Cancelar y limpiar campos");
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
                .addGap(25, 25, 25)
                .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButton_Atras.getAccessibleContext().setAccessibleDescription("Atras");

        jTable_cliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_cliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_cliente);

        jPanel3.setBackground(new java.awt.Color(36, 54, 67));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id");

        jTextField_Id.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Id.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jTextField_nombre.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_nombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });

        jLabel_Telefono.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Telefono");

        jTextField_Telefono.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_Telefono.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TelefonoActionPerformed(evt);
            }
        });

        jLabel_FechaSalida.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_FechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FechaSalida.setText("Fecha Salida");

        jTextField_FechaEntrada.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_FechaEntrada.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_FechaEntrada.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_FechaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FechaEntradaActionPerformed(evt);
            }
        });

        jLabel_FechaEntrada1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_FechaEntrada1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FechaEntrada1.setText("Fecha Entrada");

        jTextField_FechaSalida.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_FechaSalida.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_FechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_FechaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FechaSalidaActionPerformed(evt);
            }
        });

        jLabel_NumeroHabitacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_NumeroHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumeroHabitacion.setText("Tarifa Habitacion");

        jLabel_NumeroHabitacion1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_NumeroHabitacion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumeroHabitacion1.setText("Numero Habitacion");

        jTextField_TariHabi.setEditable(false);
        jTextField_TariHabi.setBackground(new java.awt.Color(82, 79, 79));
        jTextField_TariHabi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_TariHabi.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_TariHabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TariHabiActionPerformed(evt);
            }
        });

        jComboBox_NumHabita.setBackground(new java.awt.Color(82, 79, 79));
        jComboBox_NumHabita.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_NumHabita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NumHabitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_NumeroHabitacion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_NumHabita, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jLabel_NumeroHabitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_TariHabi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel_Telefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel_FechaEntrada1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_FechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel_FechaSalida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_FechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_FechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_FechaEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_NumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TariHabi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NumeroHabitacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_NumHabita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
        
        /**
         * Cuando le damos al boton de atras, hace que se oculta el la pantalla que se esta mostrando 
         */
        this.setVisible(false);
         this.dispose();
     //Desconecta la base de datos
       mysql.DesconectarBase();

    }//GEN-LAST:event_jButton_AtrasActionPerformed

    private void jTextField_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdActionPerformed

        //TransferFocus() para poder daler enter en las casillas sin nesecidad de seleccionarla con el mause
        jTextField_Id.transferFocus();
    }//GEN-LAST:event_jTextField_IdActionPerformed

    private void jTextField_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TelefonoActionPerformed
/**
 *  TransferFocus() para poder daler enter en las casillas sin nesecidad de seleccionarla con el mause
 **/
        jTextField_Telefono.transferFocus();
    }//GEN-LAST:event_jTextField_TelefonoActionPerformed

    private void jComboBox_NumHabitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NumHabitaActionPerformed


    /**
     *Cuando precionamos el JComboBox aparecen las habitaciones, cuando seleccionamos la 
     * habitacion hace que aparescan los datos que contenga esa habitacion, en ese caso lo que
     * queremos que se muestre es la tarifa de esa habitacion y la vaya a mostrar en el JTextField
     **/    
        try{
           
          String sql = "SELECT  * FROM habitacion where numero_habitacion=?";
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1, (String)jComboBox_NumHabita.getSelectedItem());
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
             jTextField_TariHabi.setText(rs.getString("tarifa_estadia"));
           }
           pst.close();
           
        }catch(Exception e){
         e.printStackTrace();
        }
      
         jComboBox_NumHabita.transferFocus();
    
    }//GEN-LAST:event_jComboBox_NumHabitaActionPerformed

    private void jTable_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_clienteMouseClicked
        
     //Hace click en un filas de la tablas y las selecciona en las casillas correspondiente
      int fila = jTable_cliente.rowAtPoint(evt.getPoint());

        jTextField_Id.setText(jTable_cliente.getValueAt(fila, 0).toString());
        jTextField_nombre.setText(jTable_cliente.getValueAt(fila, 1).toString());
        jTextField_Telefono.setText(jTable_cliente.getValueAt(fila, 2).toString());
        jTextField_FechaEntrada.setText(jTable_cliente.getValueAt(fila, 3).toString());
        jTextField_FechaSalida.setText(jTable_cliente.getValueAt(fila, 4).toString());
        jComboBox_NumHabita.setSelectedItem(jTable_cliente.getValueAt(fila, 5).toString());
        jTextField_TariHabi.setText(jTable_cliente.getValueAt(fila, 6).toString());
        

        
    }//GEN-LAST:event_jTable_clienteMouseClicked

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
       //Limpia los capos de las casillas seleccionadas
        limpiarCampos();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
   
        /**
         * Muestra una advertencia de que hace faltan campos por completar y lo redirige al campo por rellenar
         * o mas espeficio implementar un método que revice si todos los campos de información
         * estan completos
         **/
        
         if (jTextField_Id.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el ID del cliente");
            jTextField_Id.requestFocus();
            return;
        }
        if (jTextField_nombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Nombre para el cliente");
            jTextField_nombre.requestFocus();
            return;
        }
        
        if (jTextField_Telefono.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el telefono para el cliente");
            jTextField_Telefono.requestFocus();
            return;
        }
        

        if (jTextField_FechaEntrada.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la fecha en que entra el cliente");
            jTextField_FechaEntrada.requestFocus();
            return;
        }
        
        if (jTextField_FechaSalida.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar que fecha desea salir el cliente");
            jTextField_FechaSalida.requestFocus();
            return;
        }

        /**
         * Llama la clase de vcliente para poder guardalos 
         **/
        vcliente dts = new vcliente(); 
        LoCliente func = new LoCliente();

        /**
         * Cuando el usuario presiona el boton de guardar esta hace que 
         * Guarde en la base de datos todo lo que el usuario quiera almacenar 
         **/
        dts.setId_cliente(jTextField_Id.getText());
        dts.setNombre(jTextField_nombre.getText());
        dts.setTelefono(jTextField_Telefono.getText());     
        int seleccionado = jComboBox_NumHabita.getSelectedIndex();
        dts.setNumero_habitacion((String) jComboBox_NumHabita.getItemAt(seleccionado));
        dts.setFecha_entrada(jTextField_FechaEntrada.getText());
        dts.setFecha_salida(jTextField_FechaSalida.getText());
        dts.setTarifa_estadia(jTextField_TariHabi.getText());
        
       
        //Guardar
        if (accion.equals("guardar")) { 
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El cliente fue registrado satisfactoriamente");
                mostrar("");
            }

        }
        
        limpiarCampos();
        mostrar("");
        
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        /**
         * Elimina registros de la base de datos
         **/
          if (!jTextField_Id.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Cliente?","Confirmar",2);

            if (confirmacion==0) {
                 LoCliente co = new LoCliente();
                vcliente dts= new vcliente();

                dts.setId_cliente(String.valueOf(jTextField_Id.getText()));
                co.eliminar(dts);
                mostrar("");
                limpiarCampos();
      
            }

          }

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreActionPerformed

        jTextField_nombre.transferFocus();

    }//GEN-LAST:event_jTextField_nombreActionPerformed

    private void jTextField_FechaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FechaEntradaActionPerformed

        jTextField_FechaEntrada.transferFocus();
    }//GEN-LAST:event_jTextField_FechaEntradaActionPerformed

    private void jTextField_FechaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FechaSalidaActionPerformed

        jTextField_FechaSalida.transferFocus();

    }//GEN-LAST:event_jTextField_FechaSalidaActionPerformed

    private void jTextField_TariHabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TariHabiActionPerformed

        jTextField_TariHabi.transferFocus();
 
    }//GEN-LAST:event_jTextField_TariHabiActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
           /**
            * Editar los campos de las tablas
            **/
           try{
            String id_cliente = jTextField_Id.getText();
            String nombre = jTextField_nombre.getText(); 
            String telefono = jTextField_Telefono.getText();
            String fecha_entrada = jTextField_FechaEntrada.getText();
            String fecha_salida = jTextField_FechaSalida.getText();
            String numero_habitacion = (String) jComboBox_NumHabita.getSelectedItem();
            String tarifa_estadia = jTextField_TariHabi.getText();
            
            /**
             * Instruccion String SQL que me permite editar la tablas cliente, persona y reservaciones
             **/
            String sSQL ="Update cliente set id_cliente ='"+id_cliente+"',"
                    + "nombre ='"+nombre+"',telefono='"+telefono+"',fecha_entrada='"+fecha_entrada+"',fecha_salida='"+fecha_salida+"',numero_habitacion='"+numero_habitacion+"',"
                    + "tarifa_estadia ='"+tarifa_estadia+"' WHERE id_cliente='"+id_cliente+"'";
            
             String sSQL2 ="Update persona set id_cliente ='"+id_cliente+"',"
                            + "nombre ='"+nombre+"',"
                     + "telefono ='"+telefono+"' WHERE id_cliente='"+id_cliente+"'";
             
             String sSQL3 ="Update reservaciones set id_cliente ='"+id_cliente+"',"
                    + "nombre ='"+nombre+"',telefono='"+telefono+"',fecha_entrada='"+fecha_entrada+"',fecha_salida='"+fecha_salida+"',numero_habitacion='"+numero_habitacion+"',"
                    + "tarifa_estadia ='"+tarifa_estadia+"' WHERE id_cliente='"+id_cliente+"'";
             
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            PreparedStatement pst3=cn.prepareStatement(sSQL3);
            /**
             * Ejecuto la instruccion para 
             **/
            pst.execute();
            pst2.execute();
            pst3.execute();
            mostrar("");
            JOptionPane.showMessageDialog(null, "Se ha modificado con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }

        jTextField_Id.requestFocus();
        
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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_NumHabita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_FechaEntrada1;
    private javax.swing.JLabel jLabel_FechaSalida;
    private javax.swing.JLabel jLabel_NumeroHabitacion;
    private javax.swing.JLabel jLabel_NumeroHabitacion1;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_cliente;
    private javax.swing.JTextField jTextField_FechaEntrada;
    private javax.swing.JTextField jTextField_FechaSalida;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_TariHabi;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_nombre;
    // End of variables declaration//GEN-END:variables

    private static class modelocombo {

        public modelocombo() {
        }
    }
}
