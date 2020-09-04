import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private Button btn_atras;
	@FXML
	private PasswordField lbl_contraseña;
	@FXML
	private TextField lbl_usuario;
	@FXML
	private Button btn_login;
	@FXML
	public void atras(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(main);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void login(ActionEvent event) throws IOException {
		String usuario = this.lbl_usuario.getText();
		String contraseña = this.lbl_contraseña.getText();
		
		if(usuario.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase("admin")) {
			Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			Scene scene = new Scene(main);
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else {
			System.out.println("Usuario o contraseña incorrecta.");
		}
		/*
		Conexion con = new Conexion();
		
		Connection conexionConnection = con.conectarConBase();
		
		try {
		String nombre_usuario;
		String user_contraseña;
		
		nombre_usuario = "SELECT * FROM Usuarios";
		
		System.out.println(nombre_usuario);
		
		} catch(Exception e){
			System.out.println("Error al Conectar.");
		}
		*/
	}
}
