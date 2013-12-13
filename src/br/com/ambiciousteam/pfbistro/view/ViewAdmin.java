package br.com.ambiciousteam.pfbistro.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ambiciousteam.pfbistro.enummeration.EnumCategories;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdminImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ViewAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField inputNameAdmin;
	private JTextField inputNameProduct;
	private JTextField inputPriceProduct;
	private JPasswordField passwordField;
	private JComboBox<String> comboBoxCategory;
	private FacadeAdmin facade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin frame = new ViewAdmin();
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
	public ViewAdmin() {
		facade = new FacadeAdminImpl();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 291);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);


		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 672, 400);
		panel.add(tabbedPane);

		JLayeredPane tabAdmin = new JLayeredPane();
		tabbedPane.addTab("Administrador", null, tabAdmin, null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 431, 236);
		tabAdmin.add(panel_1);
		panel_1.setLayout(null);

		inputNameAdmin = new JTextField();
		inputNameAdmin.setBounds(94, 11, 130, 20);
		panel_1.add(inputNameAdmin);
		inputNameAdmin.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 14, 46, 14);
		panel_1.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 46, 46, 14);
		panel_1.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(94, 42, 130, 20);
		panel_1.add(passwordField);

		JButton btnSalvarAdministrador = new JButton("Salvar");
		btnSalvarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = inputNameAdmin.getText();
					char[] arrayPassword = passwordField.getPassword();
					String password = "";
					for (int i = 0; i < arrayPassword.length; i++) {
						
						password += ""+arrayPassword[i];
						
						System.out.println(password);
					}
							
					if (facade.registeringAdmin(name, password)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Administrador cadastrado com sucesso");
						// limpando
						inputNameAdmin.setText("");
					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Administrador Não cadastrado!!!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
				}
			}
		});
		btnSalvarAdministrador.setBounds(94, 72, 130, 23);
		panel_1.add(btnSalvarAdministrador);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Produto", null, layeredPane_1, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 431, 236);
		layeredPane_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(7, 10, 120, 14);
		panel_2.add(lblNome);

		inputNameProduct = new JTextField();
		inputNameProduct.setBounds(76, 7, 190, 20);
		panel_2.add(inputNameProduct);
		inputNameProduct.setColumns(10);

		JLabel lblPreoProduto = new JLabel("Pre\u00E7o");
		lblPreoProduto.setBounds(7, 35, 84, 14);
		panel_2.add(lblPreoProduto);

		inputPriceProduct = new JTextField();
		inputPriceProduct.setBounds(76, 32, 190, 20);
		panel_2.add(inputPriceProduct);
		inputPriceProduct.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(7, 60, 62, 14);
		panel_2.add(lblCategoria);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBounds(76, 60, 190, 20);
		comboBoxCategory.addItem(EnumCategories.DRINKS.getCategory());
		comboBoxCategory.addItem(EnumCategories.SNACK.getCategory());
		panel_2.add(comboBoxCategory);
		
		JButton btnSaveProduct = new JButton("Salvar");
		btnSaveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String name = inputNameProduct.getText();
					double price = Double.parseDouble(inputPriceProduct
							.getText());
					String category = comboBoxCategory.getSelectedItem().toString();
					if (facade.registeringProduct(name, price, category)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Produto cadastrado com sucesso");
						// limpando 
						inputNameProduct.setText("");
						inputPriceProduct.setText("");

					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Produto Não cadastrado!!!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Produto Não cadastrado!!!", "Preço Inválido",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSaveProduct.setBounds(120, 88, 89, 23);
		panel_2.add(btnSaveProduct);


		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Cardápio", null, layeredPane_2, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 431, 236);
		layeredPane_2.add(panel_3);
	}
}
