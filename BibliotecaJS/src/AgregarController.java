import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class AgregarController {
	LoginController logincontroller = new LoginController();
	@FXML
	private Button button_agregar;
	@FXML
	private TextArea lbl_notas;
	@FXML
	private TextField lbl_caducidad;
	@FXML
	private TextField lbl_titulo;
	@FXML
	private TextField lbl_autor;
	@FXML
	private TextField lbl_tipo;
	@FXML
	private TextField lbl_publicacion;
	@FXML
	private TextField lbl_codigo;
	@FXML
	private Label lbl_error;
	@FXML
	private Label lbl_exito;
	@FXML
	private Button menu_buscar;
	@FXML
	private Button menu_consultar;
	@FXML
	private Button menu_agregar;
	@FXML
	private Button menu_modificar;
	@FXML
	private Button menu_eliminar;
	@FXML
	private Button button_login;
	@FXML
	private TextField lbl_editorial;
	@FXML
	private TextField lbl_tomo;
	@FXML
	private TextField lbl_paginas;
	@FXML
	private TextField lbl_precio;

	// Event Listener on Button[#button_agregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
		String algo = this.lbl_codigo.getText();
		int codigo = Integer.parseInt(algo);
		String titulo = this.lbl_titulo.getText();
		String autor = this.lbl_autor.getText();
		String tipo = this.lbl_tipo.getText();
		String publicacion = this.lbl_publicacion.getText();
		String caducidad = this.lbl_caducidad.getText();
		String editorial = this.lbl_editorial.getText();
		String tomo = this.lbl_editorial.getText();
		int paginas = Integer.parseInt(this.lbl_paginas.getText());
		int precio = Integer.parseInt(this.lbl_precio.getText());
		String notas = this.lbl_notas.getText();
		
        
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
            	lbl_exito.setVisible(true);
            	lbl_error.setVisible(false);
            	
            	String archivoInsert;
            	archivoInsert = "INSERT INTO Archivos (codigo, titulo, editorial, tipo_material, fecha_publicacion, fecha_caducidad, tomo, paginas, precio, notas)"
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
	            + " '"+ notas + "'"
	            + ")";
	            
		        Statement stmt2 = conexionConnection.createStatement();
		        int cant2 = stmt2.executeUpdate(archivoInsert);
            }
        }catch(Exception e) {
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
	public void menu_cerrarsesion(ActionEvent event) {
	}
	public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
}
