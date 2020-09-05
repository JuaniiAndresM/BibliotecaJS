import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private JFXButton btn_atras;

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

    }
    
    boolean sesion = false;
    
    
    @FXML
    public void login(ActionEvent event) throws IOException {
    	String usuario = this.lbl_usuario.getText();
        String contraseña = this.lbl_contraseña.getText();

        if(usuario.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase("admin")) {
                sesion = true;
                System.out.println(sesion);
                System.out.println("Iniciado Correctamente.");
                Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));

                Scene scene = new Scene(main);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        }
        else {
            System.out.println("Usuario o contraseña incorrecta.");
        }
        /*
        Conexion con = new Conexion();

        Connection conexionConnection = con.conectarConBase();

        try {
        String nombre_usuario;
        String user_contraseña;

        nombre_usuario = "SELECT * FROM Usuarios";

        System.out.println(nombre_usuario);

        } catch(Exception e){
            System.out.println("Error al Conectar.");
        }
        */

    }
    public boolean VerificarSesion(){
        return sesion;
    }

}