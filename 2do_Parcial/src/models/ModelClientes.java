package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelClientes {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void Conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/2do_parcial","root","75:)82paco");
            st = conexion.createStatement();
            llenarValores();
            seleccionarTodos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 101");
        }
    }//Conectar
    
    public void llenarValores(){
        try{
            setId_cliente(rs.getInt("id_cliente"));
            setNombre(rs.getString("nombre"));
            setTelefono(rs.getString("telefono"));
            setEmail(rs.getString("email"));
            setDireccion(rs.getString("direccion"));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 102");
        }
    }//llenarValores
    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 103");
        }
    }//moverPrimero
    
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 104");
        }
    }//moverUltimo
    
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                llenarValores();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 105");
        }
    }//moverSiguiente
    
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                llenarValores();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 106");
        }
    }//moverAnterior
    
    public void seleccionarTodos(){
        try{
            sql = "SELECT * FROM clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107");
        }
    }//seleccionarTodos
    
    public void insertar(){
        try{
            sql = "INSERT INTO peliculas(nombre,telefono,email,direccion) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(0, nombre);
            ps.setString(1, telefono);
            ps.setString(2, email);
            ps.setString(3, direccion);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108");
        }
    }//insertar
    
    public void borrar(int id_persona){
        try{
            sql = "SELECT FROM clientes WHERE id_cliente=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(0, id_cliente);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 109");
        }
    }//borrar
    
    public void actualizar(int id_cliente, String nombre, String telefono, String email, String direccion){
        try{
            sql = "UPDATE personas SET nombre=?, telefono=?, email=?, direccion=? WHERE id_cliente=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(4,id_cliente);
            ps.setString(0, nombre);
            ps.setString(1, telefono);
            ps.setString(2, email);
            ps.setString(3, direccion);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 110");
        }
    }//actualizar
}//class