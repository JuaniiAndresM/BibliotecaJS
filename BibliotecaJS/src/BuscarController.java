import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuscarController implements Initializable {
	LoginController logincontroller = new LoginController();

    @FXML
    private JFXButton btn_cerrar;
    @FXML
    private JFXButton menu_registrar;

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
    private JFXDatePicker field_caducidad;

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
    public void buscar(ActionEvent event) throws IOException {
    	Parent login = FXMLLoader.load(getClass().getResource("BuscarLista.fxml"));

        Scene scene = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
	public void menu_inicio(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	public void menu_buscar(ActionEvent event) throws IOException {
		Parent buscar = FXMLLoader.load(getClass().getResource("Buscar.fxml"));
		
		Scene scene = new Scene(buscar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_consultar].onAction
	@FXML
	public void menu_consultar(ActionEvent event) throws IOException {
		Parent menu_consultar = FXMLLoader.load(getClass().getResource("Consultar.fxml"));

        Scene scene = new Scene(menu_consultar);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
	}
	// Event Listener on Button[#btn_agregar].onAction
	@FXML
	public void menu_agregar(ActionEvent event) throws IOException {
		Parent agregar = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
		
		Scene scene = new Scene(agregar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_modificar].onAction
	@FXML
	public void menu_modificar(ActionEvent event) throws IOException {
		Parent modificar = FXMLLoader.load(getClass().getResource("ModificarMenu.fxml"));
		
		Scene scene = new Scene(modificar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_eliminar].onAction
	@FXML
	public void menu_eliminar(ActionEvent event) throws IOException {
		Parent menu_eliminar = FXMLLoader.load(getClass().getResource("Eliminar.fxml"));
		
		Scene scene = new Scene(menu_eliminar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void registrar(ActionEvent event) throws IOException{
		Parent registrar = FXMLLoader.load(getClass().getResource("Registrar.fxml"));
		
		Scene scene = new Scene(registrar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_login].onAction
	@FXML
	public void login(ActionEvent event) throws IOException {
		if(logincontroller.VerificarSesion() == true){
			System.out.println("Ya se inicio sesión.");
		}
		else if(logincontroller.VerificarSesion() == false) {
			System.out.println("No se inicio sesión.");
		}
		
		Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   

	}
	// Event Listener on Button[#btn_cerrarsesion].onAction
	@FXML
	public void menu_cerrarsesion(ActionEvent event) throws IOException {
		logincontroller.setSesion(false);
		
		Parent login = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boolean sesion = logincontroller.VerificarSesion();
		
		if(logincontroller.VerificarSesion() == true) {
			if(logincontroller.VerificarAdmin() == true){
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(true);
				menu_eliminar.setVisible(true);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(true);
				menu_consultar.setVisible(true);
			}else{
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(false);
				menu_eliminar.setVisible(false);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(false);
				menu_consultar.setVisible(true);
			}
		}else {
			menu_login.setVisible(true);
			menu_cerrarsesion.setVisible(false);
			menu_registrar.setVisible(false);
			menu_eliminar.setVisible(false);
			menu_agregar.setVisible(false);
			menu_modificar.setVisible(false);
			menu_consultar.setVisible(false);
		}
		
	}
	public void cerrar(ActionEvent event) {
		 Platform.exit();
	}

}
