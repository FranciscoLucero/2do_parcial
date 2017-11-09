package controllers;
import models.*;
import views.*;

public class ControllerPrincipal {
    ModelPrincipal model_principal;
    ViewPrincipal view_principal;
    ViewClientes view_clientes;
    ViewPeliculas view_peliculas;
    
    public ControllerPrincipal(ModelPrincipal model_principal, Object views[]){
        this.model_principal = model_principal;
        this.view_principal = (ViewPrincipal) views[0];
        this.view_clientes = (ViewClientes) views[1];
        this.view_peliculas = (ViewPeliculas) views[2];
        this.view_principal.jmi_clientes.addActionListener(e -> jmi_clientes());
        this.view_principal.jmi_peliculas.addActionListener(e -> jmi_peliculas());
        this.view_principal.jmi_salir.addActionListener(e -> jmi_salir());
        initView();
    }//ControllerPrincipal
    
     private void initView() {
        this.view_principal.setTitle("2do Parcial");
        this.view_principal.setLocationRelativeTo(null);
        this.view_principal.setVisible(true);
    }//initView

    private void jmi_clientes() {
        view_principal.setContentPane(view_clientes);
        view_principal.revalidate();
        view_principal.repaint();
    }//jmi_clientes

    private void jmi_peliculas() {
        view_principal.setContentPane(view_peliculas);
        view_principal.revalidate();
        view_principal.repaint();
    }//jmi_peliculas

    private void jmi_salir() {
//        view_principal.setContentPane(view_OrdenaryPromedio);
//        view_principal.revalidate();
//        view_principal.repaint();
    }//jmi_salir
}//class
