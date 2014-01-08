package br.com.ambiciousteam.pfbistro.view.swing;

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

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdminImpl;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewLogin extends JFrame {
	private JTextField textFieldLoginUser;
	private JPasswordField passwordFieldLogin;
	private FacadeAdmin facade;

	/**
	 * Create the frame.
	 * @throws MsgErrorException 
	 */
	public ViewLogin() throws MsgErrorException {
		setTitle("Pais e Filhos Bistr\u00F4 Login");
		facade = new FacadeAdminImpl();
		facade.verifyExistAdmin();

		setBounds(100, 100, 337, 216);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBounds(16, 60, 289, 70);
		getContentPane().add(panel);

		JLabel lblUserLogin = new JLabel("Usuario");
		lblUserLogin.setBounds(10, 11, 62, 14);
		panel.add(lblUserLogin);

		textFieldLoginUser = new JTextField();
		textFieldLoginUser.setColumns(10);

		textFieldLoginUser.setBounds(79, 11, 200, 20);
		panel.add(textFieldLoginUser);

		JLabel lblPasswordLogin = new JLabel("Senha");
		lblPasswordLogin.setBounds(10, 42, 42, 14);
		panel.add(lblPasswordLogin);

		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(79, 39, 200, 20);
		panel.add(passwordFieldLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(16, 11, 289, 38);
		getContentPane().add(lblLogin);
		
				JButton btnLogin = new JButton("Login");
				btnLogin.setBounds(61, 141, 95, 23);
				getContentPane().add(btnLogin);
				
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new ViewSelectUser().setVisible(true);
						dispose();
					}
				});
				btnCancel.setBounds(171, 141, 95, 23);
				getContentPane().add(btnCancel);
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						char[] arrayPassword = passwordFieldLogin.getPassword();
						String password = "";
						for (int i = 0; i < arrayPassword.length; i++) {
							password += arrayPassword[i];
						}
						String user = textFieldLoginUser.getText();
						if (facade.login(user, password)) {
							new ViewAdmin(facade).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(getContentPane(),
									"Login Inválido! Tente novamente.",
									"Erro de Login", JOptionPane.ERROR_MESSAGE);
							try {
								new ViewLogin();
							} catch (MsgErrorException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});

	}
}
