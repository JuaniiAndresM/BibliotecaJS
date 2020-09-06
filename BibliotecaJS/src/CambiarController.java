import java.sql.Connection;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CambiarController {

    @FXML
    private JFXButton btn_atras;

    @FXML
    private JFXTextField lbl_usuarioadmin;

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private Text lbl_error;

    @FXML
    private JFXButton btn_cambiar;

    @FXML
    private JFXTextField lbl_contraseñaadmin;

    @FXML
    void atras(ActionEvent event) {

    }

    @FXML
    void cambiar(ActionEvent event) {
    	String usuario = this.lbl_usuarioadmin.getText();
        String contraseña = this.lbl_contraseñaadmin.getText();
        
        Conexion con = new Conexion();

        Connection conexionConnection = con.conectarConBase();
        
        try {
            String usuarioInsert;
            usuarioInsert = "UPDATE Usuarios SET nombre = '"+ usuario + "', contraseña = '"+ contraseña +"' WHERE nombre = 'admin'";

        System.out.println(usuarioInsert);
        Statement stmt = conexionConnection.createStatement();
        int cant = stmt.executeUpdate(usuarioInsert);
        System.out.println(cant);
        
        Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(main);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

        } catch(Exception e){
            System.out.println("Error al Conectar.");
        }

    }

    @FXML
    void cerrar(ActionEvent event) {
    	Platform.exit();
    }

}
