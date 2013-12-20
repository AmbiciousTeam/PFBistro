package br.com.ambiciousteam.pfbistro.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdminImpl;

public class ViewLogin extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private FacadeAdmin facade;
	/**
	 * Create the frame.
	 */
	public ViewLogin() {
		facade = new FacadeAdminImpl();
		facade.verifyExistAdmin();
		
		setBounds(100, 100, 337, 221);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBounds(16, 76, 289, 99);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Usuario");
		label.setBounds(10, 11, 62, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 11, 200, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Senha");
		label_1.setBounds(10, 42, 42, 14);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 39, 200, 20);
		panel.add(passwordField);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				char[] arrayPassword = passwordField.getPassword();
				String password = "";
				for (int i = 0; i < arrayPassword.length; i++) {
					password += arrayPassword[i];
				}
				String user = textField.getText();
				if(facade.login(user, password)){
					new ViewAdmin(facade).setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "LOGIN INVÁLIDO", "Erro de Login", JOptionPane.ERROR_MESSAGE);
					
					new ViewLogin();
				}
			}
		});
		button.setBounds(79, 70, 130, 23);
		panel.add(button);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(16, 11, 289, 38);
		getContentPane().add(lblLogin);

	}
}
