package br.com.ambiciousteam.pfbistro.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.ambiciousteam.pfbistro.enummeration.EnumCategories;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdminImpl;
import br.com.ambiciousteam.pfbistro.model.Product;

@SuppressWarnings("serial")
public class ViewAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panelTableProd;
	private FacadeAdmin facade;
	private JTable tableAdminData;
	private JTextField fieldProdName;
	private JTextField fieldProdPrice;
	private JTextField fieldAdminName;
	private JPasswordField fieldAdminPassword;
	private JComboBox<String> comboProdCategory;
	private JTable tableProductData;
	private JScrollPane scrollTableProduct;
	private JScrollPane scrollTableAdmin;
	private String selectedCategory;


	/**
	 * Create the frame.
	 */
	public ViewAdmin(FacadeAdmin f) {
		this.facade = f;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panelTabbedFullReg = new JPanel();
		panelTabbedFullReg.setBounds(0, 0, 634, 372);
		contentPane.add(panelTabbedFullReg);
		panelTabbedFullReg.setLayout(null);

		JTabbedPane tabbedAdminFullReg = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdminFullReg.setBounds(0, 0, 634, 373);
		panelTabbedFullReg.add(tabbedAdminFullReg);


		JLayeredPane paneProductReg = new JLayeredPane();
		paneProductReg.setBackground(Color.LIGHT_GRAY);
		tabbedAdminFullReg.addTab("Produto", null, paneProductReg, null);

		JPanel panelProdReg = new JPanel();
		panelProdReg.setBounds(0, 0, 629, 345);
		paneProductReg.add(panelProdReg);
		panelProdReg.setLayout(null);

		JPanel panelProdItens = new JPanel();
		panelProdItens.setBounds(10, 67, 609, 115);
		panelProdItens.setBorder(BorderFactory.createTitledBorder(""));
		panelProdReg.add(panelProdItens);
		panelProdItens.setLayout(null);

		JLabel lblProdName = new JLabel("Nome ");
		lblProdName.setBounds(110, 42, 62, 14);
		panelProdItens.add(lblProdName);

		fieldProdName = new JTextField();
		fieldProdName.setColumns(10);
		fieldProdName.setBounds(172, 39, 300, 20);
		panelProdItens.add(fieldProdName);

		JLabel lblProdPrice = new JLabel("Pre\u00E7o");
		lblProdPrice.setBounds(110, 67, 62, 14);
		panelProdItens.add(lblProdPrice);

		fieldProdPrice = new JTextField();
		fieldProdPrice.setColumns(10);
		fieldProdPrice.setBounds(172, 64, 120, 20);
		panelProdItens.add(fieldProdPrice);

		JLabel lblProdCategory = new JLabel("Categoria");
		lblProdCategory.setBounds(110, 14, 62, 14);
		panelProdItens.add(lblProdCategory);

		comboProdCategory = new JComboBox<String>();
		comboProdCategory.setBounds(172, 11, 300, 20);
		comboProdCategory.addItem(EnumCategories.DRINKS.getCategory());
		comboProdCategory.addItem(EnumCategories.SNACK.getCategory());
		comboProdCategory.addItem(EnumCategories.PIZZA.getCategory());
		comboProdCategory.addItem(EnumCategories.DESSERT.getCategory());
		panelProdItens.add(comboProdCategory);

		JButton btnProdSave = new JButton("Salvar");
		btnProdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = fieldProdName.getText().toUpperCase();
					
					double price = Double.parseDouble(fieldProdPrice.getText());
					String category = comboProdCategory.getSelectedItem().toString();
					if (facade.registeringProduct(name , price, category)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Produto cadastrado com sucesso");
						// limpando
						fieldProdName.setText("");
						fieldProdPrice.setText("");
						fieldProdName.requestFocus();
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
		btnProdSave.setBounds(256, 87, 130, 23);
		panelProdItens.add(btnProdSave);

		panelTableProd = new JPanel();
		panelTableProd.setLayout(null);
		panelTableProd.setBounds(10, 192, 609, 142);

		panelProdReg.add(panelTableProd);

		tableProductData = new JTable();
		tableProductData.setBounds(10, 132, 609, 202);

		scrollTableProduct = new JScrollPane(tableProductData);
		scrollTableProduct.setBounds(0, 0, 609, 142);
		panelTableProd.add(scrollTableProduct);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setBounds(106, 11, 513, 45);
		panelProdReg.add(lblCadastroDeProdutos);
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLayeredPane paneAdminReg = new JLayeredPane();
		tabbedAdminFullReg.addTab("Administrador", null, paneAdminReg, null);

		JPanel panelAdminReg = new JPanel();
		panelAdminReg.setBounds(0, 0, 629, 345);
		paneAdminReg.add(panelAdminReg);
		panelAdminReg.setLayout(null);

		JLabel lblAdminReg = new JLabel("Cadastro de Administradores");
		lblAdminReg.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdminReg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminReg.setBounds(106, 11, 513, 45);
		panelAdminReg.add(lblAdminReg);

		JPanel panelAdminItens = new JPanel();
		panelAdminItens.setLayout(null);
		panelAdminItens.setBounds(10, 67, 609, 115);
		panelAdminItens.setBorder(BorderFactory.createTitledBorder(""));
		panelAdminReg.add(panelAdminItens);

		JLabel lblAdminName = new JLabel("Usuario");
		lblAdminName.setBounds(105, 11, 62, 14);
		panelAdminItens.add(lblAdminName);

		fieldAdminName = new JTextField();
		fieldAdminName.setColumns(10);
		fieldAdminName.setBounds(174, 11, 300, 20);
		panelAdminItens.add(fieldAdminName);

		JLabel lblAdminPasswd = new JLabel("Senha");
		lblAdminPasswd.setBounds(105, 42, 42, 14);
		panelAdminItens.add(lblAdminPasswd);

		fieldAdminPassword = new JPasswordField();
		fieldAdminPassword.setBounds(174, 39, 300, 20);
		panelAdminItens.add(fieldAdminPassword);

		JButton btnAdminSave = new JButton("Salvar");
		btnAdminSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = fieldAdminName.getText();
					char[] arrayPassword = fieldAdminPassword.getPassword();
					String password = "";
					for (int i = 0; i < arrayPassword.length; i++) {
						password += arrayPassword[i];
					}
					if (facade.registeringAdmin(name, password)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Administrador cadastrado com sucesso");
						// limpando
						fieldAdminName.setText("");
						fieldAdminPassword.setText("");
					} else {
						JOptionPane.showMessageDialog(getContentPane(),

						"Administrador Não cadastrado!!!", "Erro",

						JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
				}
			}
		});
		btnAdminSave.setBounds(248, 85, 130, 23);
		panelAdminItens.add(btnAdminSave);

		JPanel panelTableAdmin = new JPanel();
		panelTableAdmin.setLayout(null);
		panelTableAdmin.setBounds(10, 192, 609, 142);
		panelAdminReg.add(panelTableAdmin);

		scrollTableAdmin = new JScrollPane((Component) null);
		scrollTableAdmin.setBounds(0, 0, 609, 142);

		tableAdminData = new JTable();
		tableAdminData.setBounds(0, 0, 609, -130);
		tableAdminData.setBorder(new LineBorder(Color.black));
		tableAdminData.setGridColor(Color.black);
		tableAdminData.setShowGrid(true);

		scrollTableAdmin.add(tableAdminData);

		panelTableAdmin.add(scrollTableAdmin);

	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
}