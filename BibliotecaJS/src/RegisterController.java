import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController{
	ObservableList<String> list = FXCollections.observableArrayList("Admin", "Bibliotecario");

    @FXML
    private JFXButton btn_atras;

    @FXML
    private JFXTextField lbl_usuario;

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private JFXPasswordField lbl_contraseña;

    @FXML
    private Text lbl_exito;
    
    @FXML
    private Text lbl_error;
    
    @FXML
    private CheckBox check_admin;

    @FXML
    private JFXButton btn_agregar;

    @FXML
    public void agregar(ActionEvent event) throws SQLException {
        String usuario = this.lbl_usuario.getText();
        String contraseña = this.lbl_contraseña.getText();
        boolean admin = this.check_admin.isSelected();
        
        System.out.println("Conectando con la Base de Datos...");
        Conexion con = new Conexion();

        Connection conexionConnection = con.conectarConBase();

        try {
        	String buscar = "SELECT * FROM Usuarios";
        	Statement stmt = conexionConnection.createStatement();
            ResultSet cant = stmt.executeQuery(buscar);
            
            boolean encontrado = false;
            while(cant.next() && encontrado == false) {
            	try{
            		if(usuario.equalsIgnoreCase(cant.getString("nombre"))) {
	            		encontrado = true;
	            		lbl_exito.setVisible(false);
	            		lbl_error.setVisible(true);
            		}
            	}catch(Exception e){
            	}
            		
            }
        	if(encontrado == false){
        		lbl_error.setVisible(false);
        		lbl_exito.setVisible(true);
        		
                System.out.println(admin);
                int tipo_usuario;
                
                if(admin == true) {
                	tipo_usuario = 1;
                }
                else {
                	tipo_usuario = 0;
                }
                
        		String usuarioInsert;
	            usuarioInsert = "INSERT INTO Usuarios (nombre, contraseña, admin)"
	            + "values("
	            + " '"+ usuario + "',"
	            + " '"+ contraseña + "',"
	            + " '"+ tipo_usuario + "'"
	            + ")";
	            
		        Statement stmt2 = conexionConnection.createStatement();
		        stmt2.executeUpdate(usuarioInsert);
        	}
            

        } catch(Exception e){
            System.out.println("Error al Conectar.");
        }
        conexionConnection.close();
    }

    @FXML
    public void atras(ActionEvent event) throws IOException {
    	Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(main);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 

    }

    @FXML
    public void cerrar(ActionEvent event) {
    	Platform.exit();
    }

}