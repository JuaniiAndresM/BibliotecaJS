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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
	public Login() {
		setForeground(Color.LIGHT_GRAY);
		setTitle("Biblioteca J.S");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 253, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_2 = new Label("Biblioteca J.S");
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 25));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 10, 233, 453);
		panel.add(label_2);
		
		Button button_6 = new Button("Atras");
		button_6.setBounds(259, 428, 102, 35);
		contentPane.add(button_6);
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.DARK_GRAY);
		button_6.setActionCommand("Salir");
		
		Button button_7 = new Button("Iniciar Sesi\u00F3n");
		button_7.setBounds(373, 292, 110, 35);
		contentPane.add(button_7);
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(Color.DARK_GRAY);
		button_7.setActionCommand("Salir");
		
		textField = new JTextField();
		textField.setBounds(373, 165, 200, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Usuario:");
		label.setForeground(Color.WHITE);
		label.setBounds(373, 137, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Contrase\u00F1a:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(373, 212, 62, 22);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(373, 240, 200, 35);
		contentPane.add(passwordField);
		
		Label label_3 = new Label("Iniciar Sesi\u00F3n");
		label_3.setAlignment(Label.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 25));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(259, 61, 408, 70);
		contentPane.add(label_3);
	}
}
