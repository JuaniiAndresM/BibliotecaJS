import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

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

public class UsuariosRegistradosController implements Initializable {
	LoginController logincontroller = new LoginController();

    @FXML
    private JFXButton btn_admin;
    
    @FXML
    private Label lbl_error;
    
    @FXML
    private JFXButton menu_atras;

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private TableView<Usuarios> table_buscar;
    
    @FXML
	private TableColumn<Usuarios, String> col_nombre;
    
    @FXML
	private TableColumn<Usuarios, String> col_tipo;

    @FXML
    private JFXButton btn_bibliotecario;
    
	Conexion con = new Conexion();
	Connection conexionConnection = con.conectarConBase();
	
    @FXML
    void admin(ActionEvent event) throws IOException, SQLException {
		
    	String usuario = table_buscar.getSelectionModel().getSelectedItem().getNombre();
    	
    	String buscar = "SELECT * FROM Usuarios";
		Statement stmt = conexionConnection.createStatement();
		ResultSet cant = stmt.executeQuery(buscar);
		
		try {
			while(cant.next()) {
				if(usuario.equals(cant.getString("nombre")) && !usuario.equals(logincontroller.getNombre())) {
					String update = "UPDATE Usuarios SET admin ='1' WHERE id = '" +cant.getString("id")+ "'";
					
					System.out.println(update);
					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(update);
					
				}
				if(usuario.equals(logincontroller.getNombre())) {
					lbl_error.setVisible(true);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error");
		}
		
		Parent infobuscar = FXMLLoader.load(getClass().getResource("UsuariosRegistrados.fxml"));

		Scene scene = new Scene(infobuscar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

    }

    @FXML
    void bibliotecario(ActionEvent event) throws SQLException, IOException {
		
    	String usuario = table_buscar.getSelectionModel().getSelectedItem().getNombre();
    	
    	String buscar = "SELECT * FROM Usuarios";
		Statement stmt = conexionConnection.createStatement();
		ResultSet cant = stmt.executeQuery(buscar);
		
		try {
			while(cant.next()) {
				
				if(usuario.equals(cant.getString("nombre")) && !usuario.equals(logincontroller.getNombre())) {
					
					String update = "UPDATE Usuarios SET admin ='0' WHERE id = '" +cant.getString("id")+ "'";
					System.out.println(update);
					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(update);
				}
				if(usuario.equals(logincontroller.getNombre())) {
					lbl_error.setVisible(true);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error");
		}
		
		Parent infobuscar = FXMLLoader.load(getClass().getResource("UsuariosRegistrados.fxml"));

		Scene scene = new Scene(infobuscar);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

    }

    @FXML
	public void menu_atras(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Configuracion.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	col_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	
    	table_buscar.setItems(oblist());
	}
	
	public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
	
	public ObservableList<Usuarios> oblist(){
		ObservableList<Usuarios> oblist = FXCollections.observableArrayList();
		oblist.removeAll(oblist);
		
		try {
			String buscar = "SELECT * FROM Usuarios";
			oblist = FXCollections.observableArrayList();
			
			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();
			
			ResultSet cant = conexionConnection.createStatement().executeQuery(buscar);
			
			while(cant.next()) {
				oblist.add(new Usuarios(cant.getString("nombre"), cant.getString("admin")));
			}
		}catch(Exception e) {
			System.out.println("Error");			
		}
		
		return oblist;
	}

}
