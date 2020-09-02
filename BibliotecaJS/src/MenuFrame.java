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

public class MenuFrame extends JFrame {

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
		panel.setBounds(0, 0, 204, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button_3 = new Button("Agregar");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.DARK_GRAY);
		button_3.setActionCommand("Salir");
		button_3.setBounds(10, 233, 184, 35);
		panel.add(button_3);
		
		Label label = new Label("Opciones Admin:");
		label.setAlignment(Label.CENTER);
		label.setForeground(Color.WHITE);
		label.setBounds(10, 205, 184, 22);
		panel.add(label);
		
		Label label_1 = new Label("Opciones Bibliotecario:");
		label_1.setAlignment(Label.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 96, 184, 22);
		panel.add(label_1);
		
		Button button_4 = new Button("Agregar");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setActionCommand("Salir");
		button_4.setBounds(10, 123, 184, 35);
		panel.add(button_4);
		
		Button button_5 = new Button("Consultar");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(Color.DARK_GRAY);
		button_5.setActionCommand("Salir");
		button_5.setBounds(10, 164, 184, 35);
		panel.add(button_5);
		
		Button button = new Button("Modificar");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.DARK_GRAY);
		button.setActionCommand("Salir");
		button.setBounds(10, 274, 184, 35);
		panel.add(button);
		
		Button button_2 = new Button("Consultar");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.DARK_GRAY);
		button_2.setActionCommand("Salir");
		button_2.setBounds(10, 315, 184, 35);
		panel.add(button_2);
		
		Button button_1 = new Button("Agregar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_1_actionPerformed(e);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setActionCommand("Salir");
		button_1.setBounds(10, 55, 184, 35);
		panel.add(button_1);
		
		Button button_6 = new Button("Salir");
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.DARK_GRAY);
		button_6.setActionCommand("Salir");
		button_6.setBounds(10, 428, 184, 35);
		panel.add(button_6);
		
		Label label_2 = new Label("Biblioteca J.S");
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 25));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 10, 184, 22);
		panel.add(label_2);
		
		Button button_7 = new Button("Iniciar Sesi\u00F3n");
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(Color.DARK_GRAY);
		button_7.setActionCommand("Salir");
		button_7.setBounds(10, 387, 184, 35);
		panel.add(button_7);
	}
	protected void do_button_1_actionPerformed(ActionEvent e) {
	}
}
