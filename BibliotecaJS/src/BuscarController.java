import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

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
    void buscar(ActionEvent event) {
    }

    @FXML
    void cerrar(ActionEvent event) {

    }
    
    LoginController logincontroller = new LoginController();

    @FXML
    void login(ActionEvent event) throws IOException {
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
    void menu_agregar(ActionEvent event) throws IOException {
		Parent menu_agregar = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
		
		Scene scene = new Scene(menu_agregar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void menu_buscar(ActionEvent event) throws IOException {
		Parent menu_buscar = FXMLLoader.load(getClass().getResource("Buscar.fxml"));
		
		Scene scene = new Scene(menu_buscar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void menu_cerrarsesion(ActionEvent event) {

    }

    @FXML
    void menu_consultar(ActionEvent event) {

    }

    @FXML
    void menu_eliminar(ActionEvent event) {

    }

    @FXML
    void menu_modificar(ActionEvent event) {

    }

}
