import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuscarController {

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private JFXButton menu_consultar;
    
    @FXML
    private JFXButton menu_inicio;

    @FXML
    private JFXButton menu_agregar;

    @FXML
    private JFXButton menu_modificar;

    @FXML
    private JFXButton menu_eliminar;

    @FXML
    private JFXButton menu_login;

    @FXML
    private JFXButton menu_cerrarsesion;

    @FXML
    private JFXButton menu_buscar;

    @FXML
    private JFXTextField field_titulo;

    @FXML
    private JFXTextField field_autor;

    @FXML
    private JFXTextField field_material;

    @FXML
    private JFXTextField field_publicacion;

    @FXML
    private JFXTextField field_caducidad;

    @FXML
    private JFXTextField field_editorial;

    @FXML
    private JFXTextField field_tomo;

    @FXML
    private JFXTextField field_paginas;

    @FXML
    private JFXTextField field_precio;

    @FXML
    private JFXButton btn_buscar;

    @FXML
    public void buscar(ActionEvent event) {
    }

    @FXML
    public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
    
    LoginController logincontroller = new LoginController();

    @FXML
    public void menu_inicio(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
    
    @FXML
    public void login(ActionEvent event) throws IOException {
		boolean sesion = logincontroller.VerificarSesion();
		
		if(sesion == true) {
			System.out.println(sesion);
			System.out.println("Ya ha iniciado sesión.");
		}
		else if(sesion == false) {
			System.out.println(sesion);
			Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			Scene scene = new Scene(login);
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
	}

    @FXML
    public void menu_agregar(ActionEvent event) throws IOException {
		Parent menu_agregar = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
		
		Scene scene = new Scene(menu_agregar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    public void menu_buscar(ActionEvent event) throws IOException {
		Parent menu_buscar = FXMLLoader.load(getClass().getResource("Buscar.fxml"));
		
		Scene scene = new Scene(menu_buscar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    public void menu_cerrarsesion(ActionEvent event) {

    }

    @FXML
    public void menu_consultar(ActionEvent event) {

    }

    @FXML
    public void menu_eliminar(ActionEvent event) throws IOException {
		Parent menu_eliminar = FXMLLoader.load(getClass().getResource("Eliminar.fxml"));
		
		Scene scene = new Scene(menu_eliminar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

    @FXML
    public void menu_modificar(ActionEvent event) throws IOException {
		Parent agregar = FXMLLoader.load(getClass().getResource("ModificarMenu.fxml"));
		
		Scene scene = new Scene(agregar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

}
