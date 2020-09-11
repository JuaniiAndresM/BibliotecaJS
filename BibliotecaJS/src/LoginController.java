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

public class LoginController{
	public static boolean sesion = false;
    public static boolean admin = false;
    public static String nombre;
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
    private JFXPasswordField lbl_contraseña;

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
    public void login(ActionEvent event) throws IOException {
    	String usuario = this.lbl_usuario.getText();
        String contraseña = this.lbl_contraseña.getText();
        
        Conexion con = new Conexion();

        Connection conexionConnection = con.conectarConBase();
        
        try {
        	String buscar = "SELECT * FROM Usuarios";
        	Statement stmt = conexionConnection.createStatement();
            ResultSet cant = stmt.executeQuery(buscar);
            boolean encontrado = false;
            while(cant.next() && encontrado == false) {
            	if(usuario.equals(cant.getString("nombre"))) {
            		if(contraseña.equals(cant.getString("contraseña"))) {
            			if(cant.getString("nombre").equals("admin") && cant.getString("contraseña").equals("admin")) {
            				Parent main = FXMLLoader.load(getClass().getResource("LoginCambiar.fxml"));

                	        Scene scene = new Scene(main);
                	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                	        window.setScene(scene);
                	        window.show();
                    	}
            			if(cant.getString("admin").equals("1")) {
            				setAdmin(true);
            			}
            			else {
            				setAdmin(false);
            			}
            			setNombre(cant.getString("nombre"));
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
            	lbl_error.setVisible(true);
            }
        }catch(Exception e) {
        	System.out.println("Error");
        }
    }
    public void setAdmin(boolean adm) {
    	LoginController.admin = adm;
    }
    public void setSesion(boolean estado) {
    	LoginController.sesion = estado;
    }
    public boolean VerificarAdmin() {
    	return LoginController.admin;
    }
    public boolean VerificarSesion(){
    	return LoginController.sesion;
    }
    public String getNombre() {
    	return nombre;
    }
    public void setNombre(String nombre) {
    	LoginController.nombre = nombre;
    }
}