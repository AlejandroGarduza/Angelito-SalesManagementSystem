package Entidades;

import angelitogui_netbeans.Conexion;
import angelitogui_netbeans.RegistrarVenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase es donde se realiza la consulta a la tabla de productos
 * de la empresa
 * 
 * @author jonce
 */
public class modeloProducto {
    
     public ArrayList<Producto> getProducto(){
        Connection con = Conexion.getConexion();
        Statement stmt;
        ResultSet rs = null;
    
    ArrayList<Producto> listaProductos = new ArrayList<>();
    
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT codigo_barras, producto, precio FROM producto");
            
            while (rs.next()) {
                
                Producto producto = new Producto();
                producto.setCodigo_Barras(rs.getInt("codigo_barras"));
                producto.setProducto(rs.getString("producto"));
                producto.setPrecio(rs.getInt("precio"));
                
                listaProductos.add(producto);                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }return listaProductos;
        
    }
       
}
