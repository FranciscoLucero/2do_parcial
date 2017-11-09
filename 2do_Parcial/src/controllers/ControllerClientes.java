package controllers;
import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {
    private ModelClientes model_clientes;
    private ViewClientes view_clientes;
    
    public ControllerClientes (ModelClientes model_clientes, ViewClientes view_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        this.view_clientes.jbtn_primero.addActionListener(e -> jbtn_mover_primero_click());
        this.view_clientes.jbtn_siguiente.addActionListener(e -> jbtn_mover_siguiente_click());
        this.view_clientes.jbtn_anterior.addActionListener(e -> jbtn_mover_anterior_click());
        this.view_clientes.jbtn_ultimo.addActionListener(e -> jbtn_mover_ultimo_click());
        //this.view_clientes.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        this.view_clientes.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
        this.view_clientes.jbtn_eliminar.addActionListener(e -> jbtn_eliminar_click());
        this.view_clientes.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_click());
        initView();
    }//ControllerPersonas
    
    public void getValores(){
        view_clientes.jtf_id_cliente.setText(""+model_clientes.getId_cliente());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
    }//getValores
    
    public void setValores(){
        model_clientes.setId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.setEmail(view_clientes.jtf_email.getText());
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
    }//setValores
    
    public void jbtn_nuevo_click(){
        view_clientes.jtf_id_cliente.setText("");
        view_clientes.jtf_nombre.setText("");
        view_clientes.jtf_telefono.setText("");
        view_clientes.jtf_email.setText("");
        view_clientes.jtf_direccion.setText("");
    }//jbtn_nuevo_click
    
    public void jbtn_agregar_click(){
        setValores();
        model_clientes.insertar();
        getValores();
    }//jbtn_agregar_click
    
    public void jbtn_actualizar_click(){
        setValores();
        model_clientes.actualizar(model_clientes.getId_cliente(),model_clientes.getNombre(),
                model_clientes.getTelefono(),model_clientes.getEmail(),model_clientes.getDireccion());
        getValores();
    }//jbtn_actualizar_click
    
    public void jbtn_eliminar_click(){
        setValores();
        model_clientes.borrar(0);
        getValores();
    }//jbtn_eliminar_click
    
    public void jbtn_mover_primero_click(){
        model_clientes.moverPrimero();
        getValores();
    }//jbtn_mover_primero_click
    
    public void jbtn_mover_ultimo_click(){
        model_clientes.moverUltimo();
        getValores();
    }//jbtn_mover_ultimo_click
    
    public void jbtn_mover_siguiente_click(){
        model_clientes.moverSiguiente();
        getValores();
    }//jbtn_mover_siguiente_click
    
    public void jbtn_mover_anterior_click(){
        model_clientes.moverAnterior();
        getValores();
    }//jbtn_mover_anterior_click
    
    public void initView(){
        model_clientes.Conectar();
        view_clientes.setVisible(true);
        model_clientes.moverPrimero();
        getValores();
    }
    
}//class