import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConsultarMenuController implements Initializable{
	LoginController logincontroller = new LoginController();
	static String codigo;
	static String titulo;
	static String editorial;
	static String material;
	static String publicacion;
	static String caducidad;
	static String tomo;
	static String paginas;
	static String precio;
	static String notas;
	static String autor;
	
    @FXML
    private JFXButton btn_cerrar;
    
    @FXML
    private JFXButton menu_configuracion;

    @FXML
    private JFXTextField field_codigo;

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
    private JFXButton menu_cerrarsesion;

    @FXML
    private JFXButton menu_buscar;

    @FXML
    private JFXButton menu_inicio;

    @FXML
    private JFXButton menu_registrar;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_exito;

    @FXML
    private JFXTextField field_titulo;

    @FXML
    private JFXTextField field_editorial;
    
    @FXML
    private JFXTextField field_autor;

    @FXML
    private JFXTextField field_material;
    
    @FXML
    private JFXTextField field_publicacion;

    @FXML
    private JFXTextField field_caducidad;

    @FXML
    private JFXTextField field_tomo;

    @FXML
    private JFXTextField field_paginas;

    @FXML
    private JFXTextField field_precio;

    @FXML
    private JFXTextArea field_notas;
    
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
	@FXML
	public void menu_configuracion(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("Configuracion.fxml"));

        Scene scene = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		field_codigo.setText(getCodigo());
		
		field_titulo.setText(getTitulo());
		
		if(getEditorial().toString().equals("")) {
			field_editorial.setText("No disponible");
		}else {
			field_editorial.setText(getEditorial());
		}
		field_material.setText(getMaterial());
		if(getPublicacion().toString().equals("")) {
			field_publicacion.setText("No disponible");
		}else {
			field_publicacion.setText(getPublicacion());
		}
		if(getAutor().toString().equals("null")) {
			field_autor.setText("No disponible");
		}else {
			field_autor.setText(getAutor());
		}
		if(getCaducidad().toString().equals("null")) {
			field_caducidad.setText("No disponible");
		}else {
			field_caducidad.setText(getCaducidad());
		}
		if(getTomo().toString().equals("")) {
			field_tomo.setText("No disponible");
		}else {
			field_tomo.setText(getTomo());
		}
		if(getPaginas().toString().equals("0")) {
			field_paginas.setText("No disponible");
		}else {
			field_paginas.setText(getPaginas());
		}
		if(getPrecio().toString().equals("0")) {
			field_precio.setText("No disponible");
		}else {
			field_precio.setText(getPrecio());
		}
		if(getNotas().toString().equals("null")) {
			field_notas.setText("No disponible");
		}else {
			field_notas.setText(getNotas());
		}
		
		if(logincontroller.VerificarSesion() == true) {
			if(logincontroller.VerificarAdmin() == true) {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(true);
				menu_eliminar.setVisible(true);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(true);
				menu_consultar.setVisible(true);
				menu_configuracion.setVisible(true);
			}
			else {
				menu_login.setVisible(false);
				menu_cerrarsesion.setVisible(true);
				menu_registrar.setVisible(false);
				menu_eliminar.setVisible(false);
				menu_agregar.setVisible(true);
				menu_modificar.setVisible(false);
				menu_consultar.setVisible(true);
				menu_configuracion.setVisible(false);
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
			menu_configuracion.setVisible(false);
		}
		
	}
	public void cerrar(ActionEvent event) {
		 Platform.exit();
	}
	
	public void setCodigo(String codigoSQL) {
		ConsultarMenuController.codigo = codigoSQL;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setTitulo(String tituloSQL) {
		ConsultarMenuController.titulo = tituloSQL;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setEditorial(String editorialSQL) {
		ConsultarMenuController.editorial = editorialSQL;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setMaterial(String materialSQL) {
		ConsultarMenuController.material = materialSQL;
	}
	public String getMaterial() {
		return material;
	}
	public void setPublicacion(String publicacionSQL) {
		ConsultarMenuController.publicacion = publicacionSQL;
	}
	public String getPublicacion() {
		return publicacion;
	}
	public void setCaducidad(String caducidadSQL) {
		ConsultarMenuController.caducidad = caducidadSQL;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setTomo(String tomoSQL) {
		ConsultarMenuController.tomo = tomoSQL;
	}
	public String getTomo() {
		return tomo;
	}
	public void setPaginas(String paginasSQL) {
		ConsultarMenuController.paginas = paginasSQL;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPrecio(String precioSQL) {
		ConsultarMenuController.precio = precioSQL;
	}
	public String getPrecio() {
		return precio;
	}
	public void setNotas(String notasSQL) {
		ConsultarMenuController.notas = notasSQL;
	}
	public String getNotas() {
		return notas;
	}
	public void setAutor(String autorSQL) {
		ConsultarMenuController.autor = autorSQL;
	}
	public String getAutor() {
		return autor;
	}
	

}
