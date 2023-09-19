package angelitogui_netbeans;

import Entidades.Producto;
import Entidades.modeloProducto;
import angelitogui_netbeans.Conexion;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Statement;


/**
 * Este formulario puede realizar ventas y registrar todos los detalles 
 * de esta para guardarlos dentro de la base de datos de la empresa y llevar
 * un control de ventas e inventario
 * 
 * @author jonce
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class RegistrarVenta extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public RegistrarVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblInventario.setVisible(false);
        txtFecha.setText(fechaActual());
        llenarProducto();
                              
    }
    
    //Método para llenar el jComboBox con los productos disponibles para venta
    private void llenarProducto(){
        modeloProducto modProducto = new modeloProducto();
        ArrayList<Producto> listaProductos = modProducto.getProducto();
        
            cbxProductos.removeAllItems();
        
        for (int i = 0; i < listaProductos.size(); i++) {
            cbxProductos.addItem(new Producto(listaProductos.get(i).getCodigo_Barras(),
                    listaProductos.get(i).getProducto(), listaProductos.get(i).getPrecio()));
            
        }
          
    }
    
    
    private void verificarInventario(){
    
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs = null;
        int codigo_barras = cbxProductos.getItemAt(cbxProductos.getSelectedIndex()).getCodigo_Barras();
            
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT cantidad FROM inventario WHERE codigo_barras =" + codigo_barras);
            
            if (rs.next()) {                
                lblInventario.setText(rs.getString("cantidad"));
                                
            }else
                JOptionPane.showMessageDialog(null, "No existe un producto con ese"
                        + "codigo de barras");
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
    
    
    private void calcularImporte(){
    
        int precio = Integer.parseInt(lblPrecio.getText());
        int cantidad = Integer.parseInt(lblCantidad.getText());
        int calculo = (precio*cantidad);
        String importe = Integer.toString(calculo);
        
        lblImporte.setText(importe);
    
    }
    
    private void actualizarInventario(){
        
        int inventarioActual = Integer.parseInt(lblInventario.getText());
        int cantidadVendida = Integer.parseInt(lblCantidad.getText());
        int inventarioActualizado = inventarioActual-cantidadVendida;
        String codigoDeBarras = txtCodigo_Barras.getText();
        
                Connection con = Conexion.getConexion();
                Statement stmt;
                ResultSet rs = null;
            
        try {
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE `inventario` SET `cantidad` = '"+inventarioActualizado+"'"
                        + " WHERE inventario.codigo_barras="+codigoDeBarras+";");
                                          
                } catch (SQLException e) {
                    System.err.println(e);
                    
                }
    }
    
    private void limpiarCampos(){
        txtCodigo_Barras.setText("");
        lblPrecio.setText("0");
        lblCantidad.setText("0");
        lblImporte.setText("0");
        
    }
    
    
    //Método para buscar todos los datos sobre un producto dentro de la BD
    private void buscar(){
    
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs = null;
        int codigo_barras = cbxProductos.getItemAt(cbxProductos.getSelectedIndex()).getCodigo_Barras();
            
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM producto WHERE"
                    + " codigo_barras=" + codigo_barras);
            
            if (rs.next()) {
                
                txtCodigo_Barras.setText(rs.getString("codigo_barras"));
                lblPrecio.setText(rs.getString("precio"));
                                
            }else
                JOptionPane.showMessageDialog(null, "No existe un producto con ese"
                        + "codigo de barras");
            
        } catch (SQLException e) {
            System.err.println(e);
            
        }
                
    }
    
     
    public static String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        return formatoFecha.format(fecha);
        
    }
    
    /*
    Al realizar una venta este método actualizará el numero de venta 
    en el formulario
    */
    private void actualizarNumVenta(){
    
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs = null;
                    
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) as ventasRealizadas "
                    + "FROM `venta`");
            
            if (rs.next()) {
                
                int nVenta = Integer.parseInt(rs.getString("ventasRealizadas"));
                nVenta++;
                lblNumerodeVenta.setText(Integer.toString(nVenta));
                
            }else
                JOptionPane.showMessageDialog(null, "error");
            
        } catch (SQLException e) {
            System.err.println(e);
            
        }
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbDeVenta = new javax.swing.JLabel();
        lbAtendió = new javax.swing.JLabel();
        lbFechaDe = new javax.swing.JLabel();
        lbRegistro1 = new javax.swing.JLabel();
        lbNumero1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btInCancelar = new javax.swing.JButton();
        btlnConfirmar = new javax.swing.JButton();
        lblUsuarioActual = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        cbxProductos = new javax.swing.JComboBox<>();
        txtCodigo_Barras = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        lblMasCantidad = new javax.swing.JLabel();
        MenosCantidad = new javax.swing.JLabel();
        lbl$ = new javax.swing.JLabel();
        lblNumerodeVenta = new javax.swing.JLabel();
        lblInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(77, 160, 80));

        lbTitulo.setFont(new java.awt.Font("Roboto", 1, 52)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Registrar Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(360, 360, 360))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(32, 32, 32))
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        jPanel1.setBackground(new java.awt.Color(77, 160, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1090, 70));

        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1090, 30));

        lbDeVenta.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbDeVenta.setForeground(new java.awt.Color(0, 0, 0));
        lbDeVenta.setText("de venta:");
        bg.add(lbDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        lbAtendió.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbAtendió.setForeground(new java.awt.Color(0, 0, 0));
        lbAtendió.setText("Atendió:");
        bg.add(lbAtendió, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        lbFechaDe.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbFechaDe.setForeground(new java.awt.Color(0, 0, 0));
        lbFechaDe.setText("Fecha de");
        bg.add(lbFechaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        lbRegistro1.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbRegistro1.setForeground(new java.awt.Color(0, 0, 0));
        lbRegistro1.setText("Registro:");
        bg.add(lbRegistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        lbNumero1.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbNumero1.setForeground(new java.awt.Color(0, 0, 0));
        lbNumero1.setText("Número");
        bg.add(lbNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Importe");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Producto");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código de Barras");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, -1, -1));

        btInCancelar.setBackground(new java.awt.Color(255, 3, 16));
        btInCancelar.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        btInCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btInCancelar.setText("Cancelar");
        btInCancelar.setBorder(null);
        btInCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btInCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInCancelarActionPerformed(evt);
            }
        });
        bg.add(btInCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 550, 100, 50));

        btlnConfirmar.setBackground(new java.awt.Color(77, 160, 80));
        btlnConfirmar.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        btlnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btlnConfirmar.setText("Confirmar");
        btlnConfirmar.setBorder(null);
        btlnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btlnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlnConfirmarActionPerformed(evt);
            }
        });
        bg.add(btlnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 100, 50));

        lblUsuarioActual.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblUsuarioActual.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuarioActual.setText("usuario");
        bg.add(lblUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 200, 40));

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setText("dd/MM/YYYY");
        bg.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 150, 40));

        cbxProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProductosItemStateChanged(evt);
            }
        });
        cbxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductosActionPerformed(evt);
            }
        });
        bg.add(cbxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 130, 50));

        txtCodigo_Barras.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        bg.add(txtCodigo_Barras, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 190, 50));

        lblPrecio.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecio.setText("0");
        bg.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 90, -1));

        lblCantidad.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(0, 0, 0));
        lblCantidad.setText("0");
        bg.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 70, 50));

        lblImporte.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblImporte.setForeground(new java.awt.Color(0, 0, 0));
        lblImporte.setText("  $0");
        bg.add(lblImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 130, 50));

        lblMasCantidad.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblMasCantidad.setForeground(new java.awt.Color(0, 0, 0));
        lblMasCantidad.setText("+");
        lblMasCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMasCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMasCantidadMousePressed(evt);
            }
        });
        bg.add(lblMasCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 50, 50));

        MenosCantidad.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        MenosCantidad.setForeground(new java.awt.Color(0, 0, 0));
        MenosCantidad.setText("-");
        MenosCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenosCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenosCantidadMousePressed(evt);
            }
        });
        bg.add(MenosCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 50, 50));

        lbl$.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lbl$.setForeground(new java.awt.Color(0, 0, 0));
        lbl$.setText("$");
        bg.add(lbl$, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 70, 50));

        lblNumerodeVenta.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNumerodeVenta.setForeground(new java.awt.Color(0, 0, 0));
        lblNumerodeVenta.setText("#");
        bg.add(lblNumerodeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, 90, 40));

        lblInventario.setForeground(new java.awt.Color(0, 0, 0));
        lblInventario.setText("jLabel6");
        bg.add(lblInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 640, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInCancelarActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Seguro desea "
                + "Cancelar?","",JOptionPane.YES_NO_OPTION);
            if (cancelar==0) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                this.dispose();
            
            }
    }//GEN-LAST:event_btInCancelarActionPerformed

    private void btlnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlnConfirmarActionPerformed
             
        verificarInventario();
        int inventario = Integer.parseInt(lblInventario.getText());
        int cantidad = Integer.parseInt(lblCantidad.getText());
        int codigo_barras = cbxProductos.getItemAt(cbxProductos.getSelectedIndex()).getCodigo_Barras();
               
        if (cantidad>0) {
            if (cantidad>inventario || inventario== 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de productos que "
                    + "intenta vender es superior a la disponible en "
                    + "inventario actualmente");
            
            }else{
                Connection con = Conexion.getConexion();
                Statement stmt;
                ResultSet rs = null;
            
                try {
                    stmt = con.createStatement();
                    int res=stmt.executeUpdate("INSERT INTO `venta` (`num_venta`,"
                            + " `fecha_venta`, `idinventario`, `cantidad`, `importe`) "
                            + "VALUES (NULL, current_timestamp(),"
                            + " '"+codigo_barras+"', '"+lblCantidad.getText()+"',"
                                    + " '"+lblImporte.getText()+"');" );
                    
                    if (res > 0) {
                        
                        actualizarInventario();
                        int respuesta = JOptionPane.showConfirmDialog(null, "¡Venta "
                                + "Realizada Exitosamente!\n\n¿Desea Imprimir Recibo"
                                + "?","",JOptionPane.YES_NO_OPTION);
                        
                        limpiarCampos();                                                
                        
                    }            
                            
                } catch (SQLException e) {
                    System.err.println(e);
                    
                  }                
            }
                actualizarNumVenta();
                
        }else
            JOptionPane.showMessageDialog(null, "Por favor digite una cantidad");
                
    }//GEN-LAST:event_btlnConfirmarActionPerformed

    private void cbxProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProductosItemStateChanged
   
    }//GEN-LAST:event_cbxProductosItemStateChanged

    private void lblMasCantidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMasCantidadMousePressed
        
        String max = "99";
        int cantidad = Integer.parseInt(lblCantidad.getText());
        
            if (cantidad == 99) {
                lblCantidad.setText(max);
                calcularImporte();
                
            }else
                cantidad++;
                lblCantidad.setText(Integer.toString(cantidad));
                buscar();
                calcularImporte();
                       
    }//GEN-LAST:event_lblMasCantidadMousePressed

    private void MenosCantidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenosCantidadMousePressed
        
        String zero = "0";
        int cantidad = Integer.parseInt(lblCantidad.getText());
        
            if (cantidad == 0) {
                lblCantidad.setText(zero);
                buscar();
                calcularImporte();
            
            }else
                cantidad--;
                lblCantidad.setText(Integer.toString(cantidad));
                buscar();
                calcularImporte();
                        
    }//GEN-LAST:event_MenosCantidadMousePressed

    private void cbxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductosActionPerformed
        limpiarCampos();
        
    }//GEN-LAST:event_cbxProductosActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVenta().setVisible(true);
            }
        });
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenosCantidad;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btInCancelar;
    private javax.swing.JButton btlnConfirmar;
    private javax.swing.JComboBox<Producto> cbxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAtendió;
    private javax.swing.JLabel lbDeVenta;
    private javax.swing.JLabel lbFechaDe;
    private javax.swing.JLabel lbNumero1;
    private javax.swing.JLabel lbRegistro1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbl$;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblMasCantidad;
    public static javax.swing.JLabel lblNumerodeVenta;
    private javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JTextField txtCodigo_Barras;
    private javax.swing.JLabel txtFecha;
    // End of variables declaration//GEN-END:variables
}
