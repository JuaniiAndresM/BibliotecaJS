import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		buscarAdmin();
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setTitle("BibliotecaJS");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void buscarAdmin() {
		try {
			Conexion con = new Conexion();
			Connection conexionConnection = con.conectarConBase();
	    	Statement stmt = conexionConnection.createStatement();
	    	
	    	String buscar = "SELECT * FROM Usuarios";
	    	Statement buscarAdmin = conexionConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        ResultSet cant = buscarAdmin.executeQuery(buscar);
	        
	        if(cant.first() == false) {
	        	String adminInsert = "INSERT INTO Usuarios (id, nombre, contraseña, admin)"
	            + "values('1', 'admin', 'admin', 1)";
	        	
		        stmt.executeUpdate(adminInsert);
		        
		        conexionConnection.close();
		        stmt.close();
	        }
	        else {
	        	
	        }
		}catch(SQLException e) {
			System.out.println("No se pudo conectar con la base de datos.");
		}
		
	}
}
