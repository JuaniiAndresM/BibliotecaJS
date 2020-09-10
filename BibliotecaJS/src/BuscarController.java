import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuscarController implements Initializable {
	LoginController logincontroller = new LoginController();
	BuscarListaController blc = new BuscarListaController();
	
	@FXML
	private Label lbl_error;
	
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
	public void buscar(ActionEvent event) throws IOException, SQLException {
		boolean ingresoTitulo, ingresoAutor, ingresoFecha, ingresoEditorial, ingresoTomo, ingresoPaginas, ingresoPrecio;
		ingresoTitulo = ingresoAutor = ingresoFecha = ingresoEditorial = ingresoTomo = ingresoPaginas = ingresoPrecio = false;

		String titulo = field_titulo.getText();
		if (!titulo.equals("")) {
			ingresoTitulo = true;
		}
		String autor = field_autor.getText();
		if (!autor.equals("")) {
			ingresoAutor = true;
		}
		String publicacion = field_publicacion.getText();
		if (!publicacion.equals("")) {
			ingresoFecha = true;
		}
		String editorial = field_editorial.getText();
		if (!editorial.equals("")) {
			ingresoEditorial = true;
		}
		String tomo = field_tomo.getText();
		if (!tomo.equals("")) {
			ingresoTomo = true;
		}
		String paginas = field_paginas.getText();
		if (!paginas.equals("")) {
			ingresoPaginas = true;
		}
		String precio = field_precio.getText();
		if (!precio.equals("")) {
			ingresoPrecio = true;
		}

		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		
		String eliminarTabla = "DELETE FROM Encontrados";
		
		Statement stmt = conexionConnection.createStatement();
        int cant = stmt.executeUpdate(eliminarTabla);

		try {
			String buscar = "SELECT * FROM Archivos";
			Statement stmt2 = conexionConnection.createStatement();
			ResultSet cant2 = stmt.executeQuery(buscar);
			
			boolean continuar = false;
			while (cant2.next()) {
				boolean encontrado = false;
				boolean parametrosEncontrados = true;
				int parametros = 0;
				String resultado = "SELECT * FROM Archivos WHERE";
				if (ingresoTitulo == true) {
					if (cant2.getString("titulo").toLowerCase().contains(titulo.toLowerCase())) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						String tituloEncontrado = cant2.getString("titulo");
						resultado += " titulo ='" + tituloEncontrado + "'";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoAutor == true) {
					if (cant2.getString("autor").toLowerCase().contains(autor.toLowerCase())) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						String autorEncontrado = cant2.getString("autor");
						resultado += " autor ='" + autorEncontrado + "'";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoFecha == true) {
					if (Integer.parseInt(publicacion) == Integer.parseInt(cant2.getString("fecha_publicacion"))) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						String fechaEncontrada = cant2.getString("fecha_publicacion");
						resultado += " fecha_publicacion ='" + fechaEncontrada + "'";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoEditorial == true) {
					if (cant2.getString("editorial").toLowerCase().contains(editorial.toLowerCase())) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						String editorialEncontrada = cant2.getString("editorial");
						resultado += " editorial ='" + editorialEncontrada + "'";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoTomo == true) {
					if (Integer.parseInt(tomo) == Integer.parseInt(cant2.getString("tomo"))) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						String tomoEncontrado = cant2.getString("tomo");
						resultado += " tomo ='" + tomoEncontrado + "'";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoPaginas == true) {
					if (Integer.parseInt(cant2.getString("paginas")) <= Integer.parseInt(paginas)) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						resultado += " paginas <= " + paginas + "";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (ingresoPrecio == true) {
					if (Integer.parseInt(cant2.getString("precio")) <= Integer.parseInt(precio)) {
						parametros++;
						if(parametros > 1) {
							resultado += " AND";
						}
						encontrado = true;
						resultado += " precio <= " + precio + "";
					}
					else {
						lbl_error.setVisible(true);
						parametrosEncontrados = false;
					}
				}
				if (encontrado == true && parametrosEncontrados == true) {					
					Statement stmt3 = conexionConnection.createStatement();
					ResultSet cant3 = stmt2.executeQuery(buscar);					
					cant3 = stmt3.executeQuery(resultado);
					continuar = true;
					System.out.println(resultado);
					
					while(cant3.next()) {
						
						String ingresar = "INSERT INTO Encontrados (codigo, titulo, editorial, tipo_material, fecha_publicacion,"
								+ " fecha_caducidad, tomo, paginas, precio, notas, autor) "
								+ "values("
								+ "'"+ cant3.getString("codigo") + "',"+
								"'"+ cant3.getString("titulo") + "',"+
								"'"+ cant3.getString("editorial") + "',"+
								"'"+ cant3.getString("tipo_material") + "',"+
								"'"+ cant3.getString("fecha_publicacion") + "',"+
								"'"+ cant3.getString("fecha_caducidad") + "',"+
								"'"+ cant3.getString("tomo") + "',"+
								"'"+ cant3.getString("paginas") + "',"+
								"'"+ cant3.getString("precio") + "',"+
								"'"+ cant3.getString("notas") + "',"+
								"'"+ cant3.getString("autor") + "'"+
								")";
						
						Statement stmt4 = conexionConnection.createStatement();
						int cant4 = stmt4.executeUpdate(ingresar);
					}
					
					lbl_error.setVisible(false);
				}

			}
			if(continuar == true) {
				Parent BuscarLista = FXMLLoader.load(getClass().getResource("BuscarLista.fxml"));

				Scene scene = new Scene(BuscarLista);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			}
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		boolean sesion = logincontroller.VerificarSesion();

		if (logincontroller.VerificarSesion() == true) {
			if (logincontroller.VerificarAdmin() == true) {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(true);
				menu_eliminar.setVisible(true);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(true);
				menu_consultar.setVisible(true);
			} else {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(false);
				menu_eliminar.setVisible(false);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(false);
				menu_consultar.setVisible(true);
			}
		} else {
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
