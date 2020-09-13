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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class AgregarController implements Initializable {
	LoginController logincontroller = new LoginController();
	@FXML
	private JFXButton button_agregar;
	@FXML
	private JFXButton button_reset;
	@FXML
	private TextArea field_notas;
	@FXML
	private JFXDatePicker date_caducidad;
	@FXML
	private TextField field_titulo;
	@FXML
	private TextField field_autor;
	@FXML
	private JFXComboBox<String> field_material;
	@FXML
	private TextField field_publicacion;
	@FXML
	private TextField field_codigo;
	@FXML
	private Label lbl_error;
	@FXML
	private Label lbl_precio;
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
	@FXML
	private JFXButton menu_configuracion;
	
	boolean paginasSelect = true;
	boolean tomoSelect = true;
	boolean precioSelect = true;
	
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
				System.out.println("Paginas: " + paginasSelect);
				if(paginasSelect == true) {
					paginas = Integer.parseInt(this.field_paginas.getText());
				}
				try {
					System.out.println("Precio: " + precioSelect);
					if(precioSelect == true) {
						precio = Integer.parseInt(this.field_precio.getText());
					}
					
				} catch (NumberFormatException e) {
					error = true;
					lbl_errorprecio.setVisible(true);
					lbl_errorcodigo.setVisible(false);
					lbl_errorpaginas.setVisible(false);
				}
			} catch (NumberFormatException e) {
				error = true;
				lbl_errorprecio.setVisible(false);
				lbl_errorcodigo.setVisible(false);
				lbl_errorpaginas.setVisible(true);
			}
		} catch (NumberFormatException e) {
			error = true;
			lbl_errorprecio.setVisible(false);
			lbl_errorcodigo.setVisible(true);
			lbl_errorpaginas.setVisible(false);
		}
		titulo = this.field_titulo.getText();
		autor = this.field_autor.getText();
		tipo = this.field_material.getValue();
		publicacion = this.field_publicacion.getText();
		caducidad = this.date_caducidad.getValue();
		editorial = this.field_editorial.getText();
		tomo = this.field_tomo.getText();
		notas = this.field_notas.getText();

		if (error == false) {
			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();

			try {
				String buscar = "SELECT * FROM Archivos";
				Statement stmt = conexionConnection.createStatement();
				ResultSet cant = stmt.executeQuery(buscar);
				boolean encontrado = false;
				while (cant.next() && encontrado == false) {
					if (codigo == Integer.parseInt(cant.getString("codigo"))) {
						encontrado = true;
						lbl_error.setVisible(true);
						lbl_exito.setVisible(false);
					}
				}
				if (encontrado == false) {

					String archivoInsert;
					archivoInsert = "INSERT INTO Archivos (codigo, titulo, editorial, tipo_material, fecha_publicacion, fecha_caducidad, tomo, paginas, precio, notas, autor)"
							+ "values(" + " '" + codigo + "'," + " '" + titulo + "'," + " '" + editorial + "'," + " '"
							+ tipo + "'," + " '" + publicacion + "'," + " '" + caducidad + "'," + " '" + tomo + "',"
							+ " '" + paginas + "'," + " '" + precio + "'," + " '" + notas + "'," + " '" + autor + "'"
							+ ")";

					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(archivoInsert);

					lbl_exito.setVisible(true);
					lbl_error.setVisible(false);
					lbl_errorprecio.setVisible(false);
					lbl_errorcodigo.setVisible(false);
					lbl_errorpaginas.setVisible(false);
				}
			} catch (Exception e) {
				System.out.println("Error");
			}
			conexionConnection.close();
		}

	}
	@FXML
	public void reset(ActionEvent event) {
		date_caducidad.setValue(null);
	}
	@FXML
	public void menu_inicio(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Main.fxml"));

		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void menu_buscar(ActionEvent event) throws IOException {
		Parent buscar = FXMLLoader.load(getClass().getResource("Buscar.fxml"));

		Scene scene = new Scene(buscar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_consultar].onAction
	@FXML
	public void menu_consultar(ActionEvent event) throws IOException {
		Parent menu_consultar = FXMLLoader.load(getClass().getResource("Consultar.fxml"));

		Scene scene = new Scene(menu_consultar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_agregar].onAction
	@FXML
	public void menu_agregar(ActionEvent event) throws IOException {
		Parent agregar = FXMLLoader.load(getClass().getResource("Agregar.fxml"));

		Scene scene = new Scene(agregar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_modificar].onAction
	@FXML
	public void menu_modificar(ActionEvent event) throws IOException {
		Parent modificar = FXMLLoader.load(getClass().getResource("ModificarMenu.fxml"));

		Scene scene = new Scene(modificar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_eliminar].onAction
	@FXML
	public void menu_eliminar(ActionEvent event) throws IOException {
		Parent menu_eliminar = FXMLLoader.load(getClass().getResource("Eliminar.fxml"));

		Scene scene = new Scene(menu_eliminar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	public void registrar(ActionEvent event) throws IOException {
		Parent registrar = FXMLLoader.load(getClass().getResource("Registrar.fxml"));

		Scene scene = new Scene(registrar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_login].onAction
	@FXML
	public void login(ActionEvent event) throws IOException {

		if (logincontroller.VerificarSesion() == true) {
			System.out.println("Ya se inicio sesión.");
		} else if (logincontroller.VerificarSesion() == false) {
			System.out.println("No se inicio sesión.");
		}

		Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));

		Scene scene = new Scene(login);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// Event Listener on Button[#btn_cerrarsesion].onAction
	@FXML
	public void menu_cerrarsesion(ActionEvent event) throws IOException {
		logincontroller.setSesion(false);

		Parent login = FXMLLoader.load(getClass().getResource("Main.fxml"));

		Scene scene = new Scene(login);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

	@FXML
	void material(ActionEvent event) {

		String opcion = field_publicacion.getSelectedText().toString();
		if (opcion.equals("Libro")) {
			field_titulo.setVisible(true);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		field_material.setItems(opciones());
		
		field_material.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
			String tipo = newValue;
			
			try {
				
				Conexion con = new Conexion();
				Connection conexionConnection = con.conectarConBase();
				String buscar = "SELECT * FROM tipodemateriales";
				
				ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
				
				boolean encontrado = false;
				
				while(cant.next()) {			
					if(tipo.equals(cant.getString("tipo"))) {
						encontrado = true;
						break;
					}
				}
				
				if(encontrado == true) {
					if(cant.getString("paginas").equals("0")) {
						setPaginas(false);
						field_paginas.setText("");
						field_paginas.setEditable(false);
						field_paginas.setDisable(true);
					}
					else {
						setPaginas(true);
						field_paginas.setEditable(true);
						field_paginas.setDisable(false);
					}
					
					
					if(cant.getString("tomo").equals("0")) {
						setTomo(false);
						field_tomo.setText("");
						field_tomo.setEditable(false);
						field_tomo.setDisable(true);
					}
					else {
						setTomo(true);
						field_tomo.setEditable(true);
						field_tomo.setDisable(false);
					}
					
					
					if(cant.getString("precio").equals("0")) {
						setPrecio(false);
						field_precio.setText("");
						field_precio.setEditable(false);
						field_precio.setDisable(true);
						lbl_precio.setVisible(false);
					}
					else {
						setPrecio(true);
						field_precio.setEditable(true);
						field_precio.setDisable(false);
						lbl_precio.setVisible(true);
					}
				}
				
			}catch(SQLException e) {
				System.out.println("Error");
			}
		});
		
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

	public ObservableList<String> opciones() {
		ObservableList<String> opciones = FXCollections.observableArrayList();
		opciones.removeAll(opciones);

		try {
			String buscar = "SELECT * FROM tipodemateriales";
			opciones = FXCollections.observableArrayList();

			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();

			ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);

			while (cant.next()) {
				opciones.add(cant.getString("tipo"));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

		return opciones;
	}
	public void setPaginas(boolean paginas) {
		this.paginasSelect = paginas;
	}
	public boolean getPaginasSelect() {
		return paginasSelect;
	}
	public void setTomo(boolean tomo) {
		this.tomoSelect = tomo;
	}
	public boolean getTomoSelect() {
		return tomoSelect;
	}
	public void setPrecio(boolean precio) {
		this.precioSelect = precio;
	}
	public boolean getPrecioSelect() {
		return precioSelect;
	}
}
