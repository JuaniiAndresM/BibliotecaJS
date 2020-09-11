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
    private Label lbl_error;

    @FXML
    private JFXButton menu_cerrarsesion;

    @FXML
    private JFXButton menu_buscar;

    @FXML
    private JFXButton menu_inicio;

    @FXML
    private JFXButton menu_registrar;

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
					System.out.println("Algo");
					String update = "UPDATE Usuarios SET admin ='1' WHERE id = '" +cant.getString("id")+ "'";
					
					System.out.println("2");
					System.out.println(update);
					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(update);
					
					System.out.println("3");
					
				}
				if(usuario.equals(logincontroller.getNombre())) {
					System.out.println("Nombre igual.");
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
				System.out.println("Usuario: " + usuario);
				System.out.println(cant.getString("nombre"));
				
				if(usuario.equals(cant.getString("nombre")) && !usuario.equals(logincontroller.getNombre())) {
					System.out.println("Algo");
					String update = "UPDATE Usuarios SET admin ='0' WHERE id = '" +cant.getString("id")+ "'";
					
					System.out.println("2");
					System.out.println(update);
					Statement stmt2 = conexionConnection.createStatement();
					stmt2.executeUpdate(update);
					
					System.out.println("3");
				}
				if(usuario.equals(logincontroller.getNombre())) {
					System.out.println("Nombre igual.");
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
		
    	col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	col_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	
    	table_buscar.setItems(oblist());
		
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
