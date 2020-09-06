import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private JFXButton btn_atras;
	@FXML
	private Text lbl_error;
    @FXML
    private Button btn_login;

    @FXML
    private JFXTextField lbl_usuario;

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private JFXPasswordField lbl_contraseņa;

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
    
    
    
    @FXML
    public boolean sesion = false;
    public boolean admin = false;
    
    public void login(ActionEvent event) throws IOException {
    	String usuario = this.lbl_usuario.getText();
        String contraseņa = this.lbl_contraseņa.getText();
        
        Conexion con = new Conexion();

        Connection conexionConnection = con.conectarConBase();
        
        try {
        	String buscar = "SELECT * FROM Usuarios";
        	Statement stmt = conexionConnection.createStatement();
            ResultSet cant = stmt.executeQuery(buscar);
            boolean encontrado = false;
            while(cant.next() && encontrado == false) {
            	if(usuario.equals(cant.getString("nombre"))) {
            		if(contraseņa.equals(cant.getString("contraseņa"))) {
            			if(cant.getString("nombre").equals("admin") && cant.getString("contraseņa").equals("admin")) {
            				Parent main = FXMLLoader.load(getClass().getResource("LoginCambiar.fxml"));

                	        Scene scene = new Scene(main);
                	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                	        window.setScene(scene);
                	        window.show();
                    	}
            			encontrado = true;
            			setSesion(true);
            			VerificarSesion();
            			Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));

            	        Scene scene = new Scene(main);
            	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	        window.setScene(scene);
            	        window.show();        			
            		}
            	}
            }
            if(encontrado == false) {
            	setSesion(false);
            	lbl_error.setVisible(true);
            }
        }catch(Exception e) {
        	System.out.println("No se encontro el usuario.");
        }
    }
    public void setSesion(boolean estado) {
    	this.sesion = estado;
    	System.out.println(sesion);
    }
    public boolean VerificarSesion(){
    	System.out.println(sesion);
    	return this.sesion;
    }

}