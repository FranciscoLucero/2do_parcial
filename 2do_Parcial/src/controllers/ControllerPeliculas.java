package controllers;
import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {
    private ModelPeliculas model_peliculas;
    private ViewPeliculas view_peliculas;
    
    public ControllerPeliculas (ModelPeliculas model_peliculas, ViewPeliculas view_peliculas){
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        this.view_peliculas.jbtn_primero.addActionListener(e -> jbtn_mover_primero_click());
        this.view_peliculas.jbtn_siguiente.addActionListener(e -> jbtn_mover_siguiente_click());
        this.view_peliculas.jbtn_anterior.addActionListener(e -> jbtn_mover_anterior_click());
        this.view_peliculas.jbtn_ultimo.addActionListener(e -> jbtn_mover_ultimo_click());
        //this.view_peliculas.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        this.view_peliculas.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
        this.view_peliculas.jbtn_eliminar.addActionListener(e -> jbtn_eliminar_click());
        this.view_peliculas.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_click());
        initView();
    }//ControllerPersonas
    
    public void getValores(){
        view_peliculas.jtf_id_pelicula.setText(""+model_peliculas.getId_peliculas());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
        view_peliculas.jtf_formato.setText(model_peliculas.getFormato());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());
        view_peliculas.jtf_descripcion.setText(model_peliculas.getDescripcion());
    }//getValores
    
    public void setValores(){
        model_peliculas.setId_peliculas(Integer.parseInt(view_peliculas.jtf_id_pelicula.getText()));
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
        model_peliculas.setFormato(view_peliculas.jtf_formato.getText());
        model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());
        model_peliculas.setDescripcion(view_peliculas.jtf_descripcion.getText());
    }//setValores
    
    public void jbtn_nuevo_click(){
        view_peliculas.jtf_id_pelicula.setText("");
        view_peliculas.jtf_nombre.setText("");
        view_peliculas.jtf_formato.setText("");
        view_peliculas.jtf_duracion.setText("");
        view_peliculas.jtf_descripcion.setText("");
    }//jbtn_nuevo_click
    
    public void jbtn_agregar_click(){
        setValores();
        model_peliculas.insertar();
        getValores();
    }//jbtn_agregar_click
    
    public void jbtn_actualizar_click(){
        setValores();
        model_peliculas.actualizar(model_peliculas.getId_peliculas(),model_peliculas.getNombre(),
                model_peliculas.getFormato(),model_peliculas.getDuracion(),model_peliculas.getDescripcion());
        getValores();
    }//jbtn_actualizar_click
    
    public void jbtn_eliminar_click(){
        setValores();
        model_peliculas.borrar(0);
        getValores();
    }//jbtn_eliminar_click
    
    public void jbtn_mover_primero_click(){
        model_peliculas.moverPrimero();
        getValores();
    }//jbtn_mover_primero_click
    
    public void jbtn_mover_ultimo_click(){
        model_peliculas.moverUltimo();
        getValores();
    }//jbtn_mover_ultimo_click
    
    public void jbtn_mover_siguiente_click(){
        model_peliculas.moverSiguiente();
        getValores();
    }//jbtn_mover_siguiente_click
    
    public void jbtn_mover_anterior_click(){
        model_peliculas.moverAnterior();
        getValores();
    }//jbtn_mover_anterior_click
    
    public void initView(){
        model_peliculas.Conectar();
        view_peliculas.setVisible(true);
        model_peliculas.moverPrimero();
        getValores();
    }
    
}//class