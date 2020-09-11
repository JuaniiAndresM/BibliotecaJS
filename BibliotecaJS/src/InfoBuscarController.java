import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InfoBuscarController implements Initializable{
	LoginController logincontroller = new LoginController();
	static String codigo;

    @FXML
    private JFXTextField field_codigo;

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
    private JFXButton menu_inicio;

    @FXML
    private JFXButton menu_registrar;

    @FXML
    private JFXTextField field_titulo;

    @FXML
    private JFXTextField field_editorial;

    @FXML
    private JFXTextField field_material;

    @FXML
    private JFXTextField field_publicacion;

    @FXML
    private JFXTextField field_caducidad;

    @FXML
    private JFXTextField field_tomo;

    @FXML
    private JFXTextField field_paginas;

    @FXML
    private JFXTextField field_precio;

    @FXML
    private JFXTextArea field_notas;

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private JFXTextField field_autor;

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
		
		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		try {
			
			String buscar = "SELECT * FROM Archivos";
			Statement stmt = conexionConnection.createStatement();
			ResultSet cant = stmt.executeQuery(buscar);
			
			while(cant.next()) {
				System.out.println("Codigo Entrante: " + codigo);
				System.out.println("Codigo Encontrado: " + cant.getString("codigo"));
				
				if(codigo.equals(cant.getString("codigo"))) {
					System.out.println("Entra");
					field_codigo.setText(cant.getString("codigo"));
					field_titulo.setText(cant.getString("titulo"));
					if(cant.getString("editorial").toString().equals("null")){
						field_editorial.setText("No disponible");
					}
					else {
						field_editorial.setText(cant.getString("editorial"));
					}
					field_material.setText(cant.getString("tipo_material"));
					field_publicacion.setText(cant.getString("fecha_publicacion"));
					field_autor.setText(cant.getString("autor"));
					if (cant.getString("fecha_caducidad").toString().equals("null")) {
						field_caducidad.setText("No disponible");
					} else {
						field_caducidad.setText(cant.getString("fecha_caducidad"));
					}
	
					field_tomo.setText(cant.getString("tomo"));
					field_paginas.setText(cant.getString("paginas"));
					field_precio.setText(cant.getString("precio"));
					field_notas.setText(cant.getString("notas"));
					}
				}
		}catch(SQLException e) {
			System.out.println("Error");
		}		
		
		if(logincontroller.VerificarSesion() == true) {
			if(logincontroller.VerificarAdmin() == true) {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(true);
				menu_eliminar.setVisible(true);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(true);
				menu_consultar.setVisible(true);
			}
			else {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(false);
				menu_eliminar.setVisible(false);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(false);
				menu_consultar.setVisible(true);
			}
	}
		else {
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
	public void setCodigo(String codigoSQL) {
		InfoBuscarController.codigo = codigoSQL;
	}
}
