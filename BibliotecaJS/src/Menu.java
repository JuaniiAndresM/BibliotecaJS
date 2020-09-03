import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Menu {
	public void actionPerformed(ActionEvent e) {
		Conexion con = new Conexion();
		Connection conexionConnection = con.conectarConBase();
		String tituloString = null, autorString = null, editorialString = null;
		int costo = 0;
		Statement oStatement;
		try {
		String queryString;
		queryString = "INSERT INTO Libros (Titulo,Autor,Editorial,Costo)"
		+ "values("
		+ " '"+ tituloString + "',"
		+ " '"+ autorString + "',"
		+ " '"+ editorialString + "',"
		+ " '"+ costo + "'"
		+ ")";
		System.out.println(queryString);
		oStatement = conexionConnection.createStatement();
		int cant = oStatement.executeUpdate(queryString);
		System.out.printf("%d lineas agredas/n",cant);
		} catch (Exception e1) {
			System.out.println();
		}
	}
}
