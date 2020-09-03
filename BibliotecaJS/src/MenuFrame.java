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

public class MenuFrame extends JFrame {
	Login login = new Login();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setResizable(false);
		setType(Type.POPUP);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 687, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_4 = new Label("Aplicaci\u00F3n de Almacenamiento de Archivos.");
		label_4.setForeground(Color.WHITE);
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(170, 81, 348, 22);
		panel.add(label_4);
		
		Label label_2 = new Label("Biblioteca J.S");
		label_2.setBounds(160, 49, 348, 37);
		panel.add(label_2);
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 25));
		label_2.setForeground(Color.WHITE);
		
		Button boton_login = new Button("Login");
		boton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
			}
		});
		boton_login.setBackground(new Color(51, 102, 204));
		boton_login.setFont(new Font("Dialog", Font.PLAIN, 17));
		boton_login.setForeground(Color.WHITE);
		boton_login.setBounds(607, 113, 70, 22);
		panel.add(boton_login);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(51, 102, 204));
		panel_5.setBounds(0, 354, 687, 129);
		contentPane.add(panel_5);
		
		Button boton_buscar = new Button("Buscar");
		boton_buscar.setBounds(10, 182, 125, 125);
		contentPane.add(boton_buscar);
		boton_buscar.setBackground(new Color(51, 102, 204));
		boton_buscar.setForeground(Color.WHITE);
		
		Button boton_eliminar = new Button("Eliminar");
		boton_eliminar.setBounds(552, 182, 125, 125);
		contentPane.add(boton_eliminar);
		boton_eliminar.setForeground(Color.WHITE);
		boton_eliminar.setBackground(new Color(51, 102, 204));
		
		Button boton_agregar = new Button("Agregar");
		boton_agregar.setForeground(Color.WHITE);
		boton_agregar.setBackground(new Color(51, 102, 204));
		boton_agregar.setBounds(281, 182, 125, 125);
		contentPane.add(boton_agregar);
		
		Button boton_consultas = new Button("Consultas");
		boton_consultas.setForeground(Color.WHITE);
		boton_consultas.setBackground(new Color(51, 102, 204));
		boton_consultas.setBounds(145, 182, 125, 125);
		contentPane.add(boton_consultas);
		
		Button boton_modificar = new Button("Modificar");
		boton_modificar.setForeground(Color.WHITE);
		boton_modificar.setBackground(new Color(51, 102, 204));
		boton_modificar.setBounds(416, 182, 125, 125);
		contentPane.add(boton_modificar);
	}
}
