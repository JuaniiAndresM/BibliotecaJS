import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConfiguracionController {

    @FXML
    private JFXButton btn_cerrar;

    @FXML
    private JFXButton menu_inicio;

    @FXML
    private JFXButton opcion_usuarios;

    @FXML
    private JFXButton opcion_material;
    
    @FXML
    public void menu_inicio(ActionEvent event) throws IOException {
    	Parent menu = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

    }

    @FXML
    public void material(ActionEvent event) throws IOException {
    	Parent menu = FXMLLoader.load(getClass().getResource("MaterialConfig.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

    }
    
    @FXML
    public void usuarios(ActionEvent event) throws IOException {
    	Parent menu = FXMLLoader.load(getClass().getResource("UsuariosRegistrados.fxml"));
		
		Scene scene = new Scene(menu);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

    }
    
    @FXML
    public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
}
