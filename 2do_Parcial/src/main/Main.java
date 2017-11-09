package main;
import controllers.*;
import models.*;
import views.*;

public class Main {
    public static void main(String flgm[]) {
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes = new ControllerClientes(model_clientes, view_clientes);
        
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
        
         Object views[] = new Object[3];
         
         views[0] = view_principal;
         views[1] = view_clientes ;
         views[2] = view_peliculas;
         
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);
    }
}