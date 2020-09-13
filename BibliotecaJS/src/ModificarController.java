import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class ModificarController implements Initializable {
	LoginController logincontroller = new LoginController();
	static String codigo;
	static String titulo;
	static String editorial;
	static String material;
	static String publicacion;
	static String caducidad;
	static String tomo;
	static String paginas;
	static String precio;
	static String notas;
	static String autor;
	static int codigoLibro;
	
	@FXML
	private JFXButton button_modificar;
	@FXML
	private JFXButton menu_configuracion;
	@FXML
	private JFXButton button_reset;
	@FXML
	private TextArea field_notas;
	@FXML
	private JFXDatePicker date_caducidad;
	@FXML
	private TextField field_titulo;
	@FXML
	private TextField field_material;
	@FXML
	private TextField field_autor;
	@FXML
	private TextField field_tipo;
	@FXML
	private TextField field_publicacion;
	@FXML
	private TextField field_codigo;
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
	private JFXButton menu_login;
	@FXML
	private JFXButton menu_registrar;
	@FXML
	private TextField field_editorial;
	@FXML
	private TextField field_tomo;
	@FXML
	private TextField field_paginas;
	@FXML
	private TextField field_precio;
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

	// Event Listener on Button[#button_modificar].onAction
	@FXML
	public void modificar(ActionEvent event) throws SQLException, IOException {
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
				if(codigo != codigoLibro) {
					Conexion con = new Conexion();
			        Connection conexionConnection = con.conectarConBase();
				        
			        try {
			        	String buscar = "SELECT * FROM Archivos";
			        	Statement stmt = conexionConnection.createStatement();
			            ResultSet cant = stmt.executeQuery(buscar);
			            while(cant.next()) {
			            	if(codigo == Integer.parseInt(cant.getString("codigo"))){
			            		error = true;
			            		lbl_error.setVisible(true);
			            		lbl_exito.setVisible(false);
			            	}
			            	else {
			            		lbl_error.setVisible(false);
			            		error = false;
			            	}
			            }
			        }catch(Exception e) {
			        	System.out.println("Error");
			        }	
				}
				
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
			        
		        String archivoInsert;
			    archivoInsert = "UPDATE Archivos SET codigo = '"+codigo+"', titulo = '"+titulo+"', editorial = '"+editorial+"',"
			    + " tipo_material = '"+tipo+"', fecha_publicacion = '"+publicacion+"', fecha_caducidad = '"+caducidad+"',"
			    + " tomo = '"+tomo+"', paginas = '"+paginas+"', precio = '"+precio+"', notas = '"+notas+"', autor = '"+autor+"'WHERE codigo ='"+codigoLibro+"'";
			            	
			    Statement stmt2 = conexionConnection.createStatement();
				stmt2.executeUpdate(archivoInsert);
				
				lbl_exito.setVisible(true);
				lbl_error.setVisible(false);        						
				lbl_errorprecio.setVisible(false);
				lbl_errorcodigo.setVisible(false);
				lbl_errorpaginas.setVisible(false);
				
				codigoLibro = codigo;
				conexionConnection.close();
			}
	}
	// Event Listener on Button[#menu_buscar].onAction
	@FXML
	public void reset(ActionEvent event) {
		date_caducidad.setValue(null);
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
	@FXML
	public void menu_configuracion(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("Configuracion.fxml"));

        Scene scene = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codigoLibro = Integer.parseInt(getCodigo());
		field_codigo.setText(getCodigo());
		field_titulo.setText(getTitulo());
		field_editorial.setText(getEditorial());
		field_material.setText(getMaterial());
		field_publicacion.setText(getPublicacion());
		date_caducidad.setPromptText(getCaducidad());
		field_tomo.setText(getTomo());
		field_paginas.setText(getPaginas());
		field_precio.setText(getPrecio());
		field_notas.setText(getNotas());
		field_autor.setText(getAutor());
		
		if(logincontroller.VerificarSesion() == true) {
			if(logincontroller.VerificarAdmin() == true) {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(true);
				menu_eliminar.setVisible(true);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(true);
				menu_consultar.setVisible(true);
				menu_configuracion.setVisible(true);
			}
			else {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(false);
				menu_eliminar.setVisible(false);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(false);
				menu_consultar.setVisible(true);
				menu_configuracion.setVisible(false);
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
			menu_configuracion.setVisible(false);
		}
		
	}
	public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
	
	public void setCodigo(String codigoSQL) {
		ModificarController.codigo = codigoSQL;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setTitulo(String tituloSQL) {
		ModificarController.titulo = tituloSQL;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setEditorial(String editorialSQL) {
		ModificarController.editorial = editorialSQL;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setMaterial(String materialSQL) {
		ModificarController.material = materialSQL;
	}
	public String getMaterial() {
		return material;
	}
	public void setPublicacion(String publicacionSQL) {
		ModificarController.publicacion = publicacionSQL;
	}
	public String getPublicacion() {
		return publicacion;
	}
	public void setCaducidad(String caducidadSQL) {
		ModificarController.caducidad = caducidadSQL;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setTomo(String tomoSQL) {
		ModificarController.tomo = tomoSQL;
	}
	public String getTomo() {
		return tomo;
	}
	public void setPaginas(String paginasSQL) {
		ModificarController.paginas = paginasSQL;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPrecio(String precioSQL) {
		ModificarController.precio = precioSQL;
	}
	public String getPrecio() {
		return precio;
	}
	public void setNotas(String notasSQL) {
		ModificarController.notas = notasSQL;
	}
	public String getNotas() {
		return notas;
	}
	public void setAutor(String autorSQL) {
		ModificarController.autor = autorSQL;
	}
	public String getAutor() {
		return autor;
	}
}
