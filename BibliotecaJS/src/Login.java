import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField field_usuario;
	private JPasswordField field_contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setType(Type.POPUP);
		setResizable(false);
		setForeground(Color.LIGHT_GRAY);
		setTitle("Biblioteca J.S");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button boton_atras = new Button("Atras");
		boton_atras.setBounds(354, 438, 102, 35);
		contentPane.add(boton_atras);
		boton_atras.setForeground(Color.WHITE);
		boton_atras.setBackground(new Color(51, 102, 204));
		boton_atras.setActionCommand("Salir");
		
		Button boton_iniciarsesion = new Button("Iniciar Sesi\u00F3n");
		boton_iniciarsesion.setBounds(423, 293, 110, 35);
		contentPane.add(boton_iniciarsesion);
		boton_iniciarsesion.setForeground(Color.WHITE);
		boton_iniciarsesion.setBackground(new Color(51, 102, 204));
		boton_iniciarsesion.setActionCommand("Salir");
		
		field_usuario = new JTextField();
		field_usuario.setBounds(423, 165, 200, 35);
		contentPane.add(field_usuario);
		field_usuario.setColumns(10);
		
		Label label = new Label("Usuario:");
		label.setForeground(Color.DARK_GRAY);
		label.setBounds(423, 137, 200, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Contrase\u00F1a:");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setBounds(423, 212, 200, 22);
		contentPane.add(label_1);
		
		field_contraseña = new JPasswordField();
		field_contraseña.setBounds(423, 240, 200, 35);
		contentPane.add(field_contraseña);
		
		Label label_3 = new Label("Iniciar Sesi\u00F3n");
		label_3.setAlignment(Label.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 25));
		label_3.setForeground(new Color(51, 102, 204));
		label_3.setBounds(348, 61, 339, 70);
		contentPane.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 348, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_4 = new Label("Aplicaci\u00F3n de Almacenamiento de Archivos.");
		label_4.setForeground(Color.WHITE);
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(0, 244, 348, 30);
		panel.add(label_4);
		
		Label label_2 = new Label("Biblioteca J.S");
		label_2.setBounds(0, 193, 348, 68);
		panel.add(label_2);
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 25));
		label_2.setForeground(Color.WHITE);
	}
	protected void do_Atras_actionPerformed(ActionEvent e) {
	}
}
