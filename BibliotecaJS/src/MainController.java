import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainController {
	LoginController logincontroller = new LoginController();
	
	@FXML
	private Button menu_buscar;
	@FXML
	private Button menu_inicio;
	@FXML
	private Button menu_consultar;
	@FXML
	private Button menu_agregar;
	@FXML
	private Button menu_modificar;
	@FXML
	private Button menu_eliminar;
	@FXML
	private Button menu_login;
	@FXML
	private Button menu_cerrarsesion;
	@FXML
	private Button btn_cerrar;

	// Event Listener on Button[#btn_buscar].onAction
	@FXML
	public void menu_inicio(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		
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
	public void menu_consultar(ActionEvent event) {
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
	public void menu_modificar(ActionEvent event) {
		boolean sesion = logincontroller.VerificarSesion();
		System.out.println(sesion);
	}
	// Event Listener on Button[#btn_eliminar].onAction
	@FXML
	public void menu_eliminar(ActionEvent event) {
	}
	// Event Listener on Button[#btn_login].onAction
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
	// Event Listener on Button[#btn_cerrarsesion].onAction
	@FXML
	public void menu_cerrarsesion(ActionEvent event) {
	}
	public void cerrar(ActionEvent event) {
	}
}
