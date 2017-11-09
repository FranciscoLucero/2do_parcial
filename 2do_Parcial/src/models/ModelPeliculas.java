package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelPeliculas {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_peliculas;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;

    public int getId_peliculas() {
        return id_peliculas;
    }

    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
            setId_peliculas(rs.getInt("id_peliculas"));
            setNombre(rs.getString("nombre"));
            setFormato(rs.getString("formato"));
            setDuracion(rs.getString("duracion"));
            setDescripcion(rs.getString("descripcion"));
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
            sql = "SELECT * FROM peliculas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107");
        }
    }//seleccionarTodos
    
    public void insertar(){
        try{
            sql = "INSERT INTO peliculas(nombre,formato,duracion,descripcion) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(0, nombre);
            ps.setString(1, formato);
            ps.setString(2, duracion);
            ps.setString(3, descripcion);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108");
        }
    }//insertar
    
    public void borrar(int id_persona){
        try{
            sql = "SELECT FROM peliculas WHERE id_peliculas=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(0, id_peliculas);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 109");
        }
    }//borrar
    
    public void actualizar(int id_peliculas, String nombre, String formato, String duracion, String descripcion){
        try{
            sql = "UPDATE personas SET nombre=?, formato=?, duracion=?, descripcion=? WHERE id_peliculas=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(4,id_peliculas);
            ps.setString(0, nombre);
            ps.setString(1, formato);
            ps.setString(2, duracion);
            ps.setString(3, descripcion);
            ps.executeUpdate();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 110");
        }
    }//actualizar
}//class