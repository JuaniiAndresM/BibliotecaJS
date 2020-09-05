import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	String nombreBaseString = "bibliotecajs";
	String usuarioString = "root";
	String passwordString = "root";
	java.sql.Connection conector;

public Connection conectarConBase() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		nombreBaseString = "jdbc:mysql://localhost:3306/"+nombreBaseString;
		conector = DriverManager.getConnection(nombreBaseString,usuarioString,passwordString);
		if (conector != null)
		JOptionPane.showMessageDialog(null, "Conexi�n Exitosa");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error en la conexion con el Driver");
	} catch (SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error en la conexion con el Base");
	}
		return conector;
	}

	public void desconectar() throws SQLException {
		if (conector != null) {
			conector.close();
		}
	}
}