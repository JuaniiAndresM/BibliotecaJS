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
	private Button btn_buscar;
	@FXML
	private Button btn_consultar;
	@FXML
	private Button btn_agregar;
	@FXML
	private Button btn_modificar;
	@FXML
	private Button btn_eliminar;
	@FXML
	private Button btn_login;
	@FXML
	private Button btn_cerrarsesion;
	@FXML
	private Button btn_cerrar;

	// Event Listener on Button[#btn_buscar].onAction
	@FXML
	public void buscar(ActionEvent event) throws IOException {
		Parent buscar = FXMLLoader.load(getClass().getResource("Buscar.fxml"));
		
		Scene scene = new Scene(buscar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_consultar].onAction
	@FXML
	public void consultar(ActionEvent event) {
	}
	// Event Listener on Button[#btn_agregar].onAction
	@FXML
	public void agregar(ActionEvent event) throws IOException {
		Parent agregar = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
		
		Scene scene = new Scene(agregar);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btn_modificar].onAction
	@FXML
	public void modificar(ActionEvent event) {
		boolean sesion = logincontroller.VerificarSesion();
		System.out.println(sesion);
	}
	// Event Listener on Button[#btn_eliminar].onAction
	@FXML
	public void eliminar(ActionEvent event) {
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
	public void cerrarsesion(ActionEvent event) {
	}
	public void cerrar(ActionEvent event) {
	}
}
