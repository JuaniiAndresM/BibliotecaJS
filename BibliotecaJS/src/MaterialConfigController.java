import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MaterialConfigController implements Initializable {
	@FXML
	private JFXCheckBox check_paginas;

	@FXML
	private JFXCheckBox check_tomo;

	@FXML
	private JFXCheckBox check_precio;

	@FXML
	private Label lbl_existe;

	@FXML
	private Label lbl_exitoeditar;

	@FXML
	private Label lbl_exitoborrar;

	@FXML
	private Label lbl_exitoagregar;

	@FXML
	private JFXTextField field_tipo;

	@FXML
	private JFXButton btn_eliminar;

	@FXML
	private JFXButton btn_cerrar;

	@FXML
	private JFXButton menu_atras;

	@FXML
	private TableView<Opciones> table_buscar;

	@FXML
	private TableColumn<Opciones, String> col_tipo;

	@FXML
	private Label lbl_error;

	@FXML
	private JFXButton btn_modificar;

	@FXML
	private JFXButton btn_añadir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		col_tipo.setCellValueFactory(new PropertyValueFactory<>("opcion"));

		table_buscar.setItems(opciones());
		table_buscar.setOnMouseClicked (e ->{
			try {
				events();
			} catch (SQLException e1) {
				System.out.println("Error");
			}
		});
	}

	@FXML
	void añadir(ActionEvent event) throws SQLException {
		lbl_existe.setVisible(false);
		lbl_exitoagregar.setVisible(false);
		lbl_exitoborrar.setVisible(false);
		lbl_exitoeditar.setVisible(false);

		String tipo = field_tipo.getText();

		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		String buscar = "SELECT * FROM tipodemateriales";
		ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
		try {
			boolean encontrado = false;
			while (cant.next()) {
				if (cant.getString("tipo").equalsIgnoreCase(tipo)) {
					encontrado = true;
				}
			}
			if (encontrado == false) {
				int paginas = 0;
				int tomo = 0;
				int precio = 0;
				
				
				if(check_paginas.isSelected()) {
					paginas = 1;										
				}
				if(check_tomo.isSelected()){
					tomo = 1;
				}
				if(check_precio.isSelected()){
					precio = 1;
				}
				
				String usuarioInsert;
				usuarioInsert = "INSERT INTO tipodemateriales (tipo, paginas, tomo, precio)" + "values(" 
				+ " '" + tipo + "',"
				+ " '" + paginas + "',"
				+ " '" + tomo + "',"
				+ " '" + precio + "'"
				+ ")";

				Statement stmt2 = conexionConnection.createStatement();
				stmt2.executeUpdate(usuarioInsert);

				table_buscar.setItems(opciones());

				lbl_exitoagregar.setVisible(true);
				
				check_paginas.setSelected(false);
				check_tomo.setSelected(false);
				check_precio.setSelected(false);
			} else {
				lbl_existe.setVisible(true);
			}

		} catch (SQLException e) {
			System.out.println("Error");
		}

	}

	@FXML
	void eliminar(ActionEvent event) throws SQLException {

		lbl_existe.setVisible(false);
		lbl_exitoagregar.setVisible(false);
		lbl_exitoborrar.setVisible(false);
		lbl_exitoeditar.setVisible(false);

		String tipo = table_buscar.getSelectionModel().getSelectedItem().getOpcion();

		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		String buscar = "SELECT * FROM tipodemateriales";
		ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
		try {
			while (cant.next()) {
				if (tipo.equals(cant.getString("tipo"))) {
					String deleteOpcion = "DELETE FROM tipodemateriales WHERE tipo ='" + tipo + "'";

					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(deleteOpcion);

					table_buscar.setItems(opciones());

					lbl_exitoborrar.setVisible(true);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	@FXML
	void modificar(ActionEvent event) throws SQLException {

		lbl_existe.setVisible(false);
		lbl_exitoagregar.setVisible(false);
		lbl_exitoborrar.setVisible(false);
		lbl_exitoeditar.setVisible(false);

		String nuevoNombre = field_tipo.getText();
		String tipo = table_buscar.getSelectionModel().getSelectedItem().getOpcion();

		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		String buscar = "SELECT * FROM tipodemateriales";
		ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
		try {
			if (tipo != null) {
				while (cant.next()) {
					if (tipo.equals(cant.getString("tipo"))) {
						
						int paginas = 0;
						int tomo = 0;
						int precio = 0;
						
						
						if(check_paginas.isSelected()) {
							paginas = 1;										
						}
						if(check_tomo.isSelected()){
							tomo = 1;
						}
						if(check_precio.isSelected()){
							precio = 1;
						}
						
						String updateOpcion = "UPDATE tipodemateriales SET tipo ='" + nuevoNombre + "', paginas = '" + paginas + "', tomo = '" + tomo + "', precio = '" + precio + "'  WHERE tipo ='"
								+ tipo + "'";

						Statement stmt2 = conexionConnection.createStatement();
						stmt2.executeUpdate(updateOpcion);

						table_buscar.setItems(opciones());

						lbl_exitoeditar.setVisible(true);
						
						check_paginas.setSelected(false);
						check_tomo.setSelected(false);
						check_precio.setSelected(false);
					}
				}
			} else {
				

			}

		} catch (SQLException e) {
			System.out.println("Error");
		}

	}

	public ObservableList<Opciones> opciones() {
		ObservableList<Opciones> opciones = FXCollections.observableArrayList();
		opciones.removeAll(opciones);

		try {
			String buscar = "SELECT * FROM tipodemateriales";
			opciones = FXCollections.observableArrayList();

			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();

			ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);

			while (cant.next()) {
				opciones.add(new Opciones(cant.getString("tipo")));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

		return opciones;
	}

	@FXML
	public void menu_atras(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Configuracion.fxml"));

		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	public void cerrar(ActionEvent event) {
		Platform.exit();
	}
	
	private void events() throws SQLException {
		for(Opciones opciones: table_buscar.getSelectionModel().getSelectedItems()) {
			field_tipo.setText(opciones.getOpcion());
			
			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();
			String buscar = "SELECT * FROM tipodemateriales";
			ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
			try {
				while (cant.next()) {
					if (opciones.getOpcion().equals(cant.getString("tipo"))) {
						
						boolean paginas = false;
						boolean tomo = false;
						boolean precio = false;
						
						if(cant.getString("paginas").equals("1")) {
							paginas = true;							
						}
						if(cant.getString("tomo").equals("1")) {
							tomo = true;							
						}
						if(cant.getString("precio").equals("1")) {
							precio = true;							
						}
						check_paginas.setSelected(paginas);
						check_tomo.setSelected(tomo);
						check_precio.setSelected(precio);
					}
				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
			
		}
	}
}
