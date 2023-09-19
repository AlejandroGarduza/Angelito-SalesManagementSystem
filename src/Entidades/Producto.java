package Entidades;

/**
 * Esta clase es auxiliar para poder mapear la tabla de productos
 * dentro de la base de datos de la empresa "Angelito" y de esta manera
 * lograr trabajar de una manera correcta con POO.
 * 
 * @author jonce
 */
public class Producto {
    private int codigo_Barras;
    private String producto;
    private int precio;
        
    // 3 constructores para una sobrecarga de Métodos/Constructor
    public Producto(){
       
    }
            
    public Producto(int codigo_Barras, String producto, int precio){
    
        this.codigo_Barras = codigo_Barras;
        this.producto = producto;
        this.precio = precio;
    
    }
    
    public Producto(int codigo_Barras){
    
    this.codigo_Barras = codigo_Barras;
    }       
    
    @Override
    public String toString(){
        
        return codigo_Barras +"-"+producto;
        
    }
    
    //Getters & Setters
    public int getCodigo_Barras() {
        return codigo_Barras;
    }

    public void setCodigo_Barras(int codigo_Barras) {
        this.codigo_Barras = codigo_Barras;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
