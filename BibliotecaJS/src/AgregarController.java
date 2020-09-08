import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class AgregarController implements Initializable {
	LoginController logincontroller = new LoginController();
	@FXML
	private JFXButton button_agregar;
	@FXML
	private TextArea field_notas;
	@FXML
	private JFXDatePicker date_caducidad;
	@FXML
	private TextField field_titulo;
	@FXML
	private TextField field_autor;
	@FXML
	private TextField field_material;
	@FXML
	private TextField field_publicacion;
	@FXML
	private TextField field_codigo;
	@FXML
	private Label lbl_error;
	@FXML
	private Label lbl_exito;
	@FXML
	private Label lbl_errorcodigo;
	@FXML
	private Label lbl_errorpaginas;
	@FXML
	private Label lbl_errorprecio;
	@FXML
	private JFXButton menu_buscar;
	@FXML
	private JFXButton menu_consultar;
	@FXML
	private JFXButton menu_agregar;
	@FXML
	private JFXButton menu_modificar;
	@FXML
	private JFXButton menu_eliminar;
	@FXML
	private JFXButton menu_cerrarsesion;
	@FXML
	private JFXButton menu_registrar;
	@FXML
	private JFXButton menu_login;
	@FXML
	private TextField field_editorial;
	@FXML
	private TextField field_tomo;
	@FXML
	private TextField field_paginas;
	@FXML
	private TextField field_precio;

	// Event Listener on Button[#button_agregar].onAction
	@FXML
	public void agregar(ActionEvent event) throws SQLException {
		int codigo = 0;
		String titulo = null;
		String autor = null;
		String tipo = null;
		String publicacion = null;
		LocalDate caducidad = null;
		String editorial = null;
		String tomo = null;
		int paginas = 0;
		int precio = 0;
		String notas = null;
		
		boolean error = false;
		
			error = false;
			try {
				codigo = Integer.parseInt(this.field_codigo.getText());
				try {
					paginas = Integer.parseInt(this.field_paginas.getText());
					try {
						precio = Integer.parseInt(this.field_precio.getText());
					}catch(NumberFormatException e) {
						error = true;
						lbl_errorprecio.setVisible(true);
						lbl_errorcodigo.setVisible(false);
						lbl_errorpaginas.setVisible(false);
					}
				}catch(NumberFormatException e) {
					error = true;
					lbl_errorprecio.setVisible(false);
					lbl_errorcodigo.setVisible(false);
					lbl_errorpaginas.setVisible(true);
				}
			}catch(NumberFormatException e){
				error = true;
				lbl_errorprecio.setVisible(false);
				lbl_errorcodigo.setVisible(true);
				lbl_errorpaginas.setVisible(false);
			}				
			titulo = this.field_titulo.getText();
			autor = this.field_autor.getText();
			tipo = this.field_material.getText();
			publicacion = this.field_publicacion.getText();
			caducidad = this.date_caducidad.getValue();
			editorial = this.field_editorial.getText();
			tomo = this.field_tomo.getText();			
			notas = this.field_notas.getText();
			
		if(error == false) {
			Conexion con = new Conexion();
	        Connection conexionConnection = con.conectarConBase();
		        
	        try {
	        	String buscar = "SELECT * FROM Archivos";
	        	Statement stmt = conexionConnection.createStatement();
	            ResultSet cant = stmt.executeQuery(buscar);
	            boolean encontrado = false;
	            while(cant.next() && encontrado == false) {
	            	if(codigo == Integer.parseInt(cant.getString("codigo"))){
	            		encontrado = true;
	            		lbl_error.setVisible(true);
	            		lbl_exito.setVisible(false);
	            	}
	            }
	            if(encontrado == false) {
	            	
	            	String archivoInsert;
	            	archivoInsert = "INSERT INTO Archivos (codigo, titulo, editorial, tipo_material, fecha_publicacion, fecha_caducidad, tomo, paginas, precio, notas, autor)"
		            + "values("
		            + " '"+ codigo + "',"
		            + " '"+ titulo + "',"
		            + " '"+ editorial + "',"
		            + " '"+ tipo + "',"
		            + " '"+ publicacion + "',"
		            + " '"+ caducidad + "',"
		            + " '"+ tomo + "',"
		            + " '"+ paginas + "',"
		            + " '"+ precio + "',"
		            + " '"+ notas + "',"
		            + " '"+ autor + "'"
		            + ")";
	            	
			        Statement stmt2 = conexionConnection.createStatement();
			        int cant2 = stmt2.executeUpdate(archivoInsert);
			        
			        lbl_exito.setVisible(true);
	            	lbl_error.setVisible(false);
	            	lbl_errorprecio.setVisible(false);
					lbl_errorcodigo.setVisible(false);
					lbl_errorpaginas.setVisible(false);
	            }
	        }catch(Exception e) {
	        	System.out.println("Error");
	        	
	        }
	        conexionConnection.close();
		}
        
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
}
