package br.com.ambiciousteam.pfbistro.view.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;

@SuppressWarnings("serial")
public class ViewSelectUser extends JFrame {

	/**
	 * Create the frame.
	 */
	public ViewSelectUser() {
		setBounds(100, 100, 341, 221);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		final JPanel panelSelectUser = new JPanel();
		panelSelectUser.setBounds(10, 11, 305, 160);
		getContentPane().add(panelSelectUser);
		panelSelectUser.setLayout(null);

		JButton btnSelectAdmin = new JButton("Administrador");
		getRootPane().setDefaultButton(btnSelectAdmin);
		btnSelectAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ViewLogin().setVisible(true);
				} catch (MsgErrorException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnSelectAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelectAdmin.setBounds(22, 104, 126, 45);
		panelSelectUser.add(btnSelectAdmin);

		JButton btnSelectClient = new JButton("Cliente");
		btnSelectClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ViewClient().setVisible(true);
				dispose();

			}
		});
		btnSelectClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelectClient.setBounds(158, 104, 126, 45);
		panelSelectUser.add(btnSelectClient);

		JLabel lblSelectType = new JLabel("Selecione o tipo de acesso");
		lblSelectType.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectType.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectType.setBounds(0, 65, 305, 28);
		panelSelectUser.add(lblSelectType);

		JPanel panelWait = new JPanel();
		panelWait.setBounds(10, 11, 305, 160);
		getContentPane().add(panelWait);
		panelWait.setLayout(null);

		JLabel lblWait = new JLabel("Selecione o tipo de acesso");
		lblWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblWait.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWait.setBounds(0, 65, 305, 28);
		panelWait.add(lblWait);

	}
}
