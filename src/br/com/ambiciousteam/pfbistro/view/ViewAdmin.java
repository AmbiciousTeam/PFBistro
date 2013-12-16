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
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ViewAdmin extends JFrame {

	private JPanel contentPane;
	private FacadeAdmin facade;
	private JTable table;
	private JTextField fieldProdName;
	private JTextField fieldProdPrice;
	private JTextField fieldAdminName;
	private JPasswordField fieldAdminPasswd;
	private JComboBox<String> comboProdCategory;

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

		JLayeredPane paneMenuReg = new JLayeredPane();
		tabbedAdminFullReg.addTab("Card�pio", null, paneMenuReg, null);

		JPanel panelMenuReg = new JPanel();
		panelMenuReg.setLayout(null);
		panelMenuReg.setBounds(0, 0, 629, 345);
		paneMenuReg.add(panelMenuReg);

		JLabel lblCadastroDeCardpio = new JLabel("Cadastro de card\u00E1pio");
		lblCadastroDeCardpio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCardpio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeCardpio.setBounds(106, 11, 513, 45);
		panelMenuReg.add(lblCadastroDeCardpio);
		
		JPanel panelSelectItens = new JPanel();
		panelSelectItens.setBounds(10, 67, 250, 267);
		panelMenuReg.add(panelSelectItens);
		panelSelectItens.setLayout(null);
		
		JLabel lblMenuSelectCat = new JLabel("Selecione uma categoria");
		lblMenuSelectCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSelectCat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMenuSelectCat.setBounds(10, 11, 230, 14);
		panelSelectItens.add(lblMenuSelectCat);
		
		JComboBox comboMenuSelectCat = new JComboBox();
		comboMenuSelectCat.setBounds(20, 36, 220, 20);
		panelSelectItens.add(comboMenuSelectCat);
		
		JLabel lblMenuSelectItem = new JLabel("Selecione um item");
		lblMenuSelectItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSelectItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMenuSelectItem.setBounds(10, 77, 230, 14);
		panelSelectItens.add(lblMenuSelectItem);
		
		JComboBox comboMenuSelectItem = new JComboBox();
		comboMenuSelectItem.setBounds(20, 102, 220, 20);
		panelSelectItens.add(comboMenuSelectItem);
		
		JButton btnMenuSave = new JButton("Salvar");
		btnMenuSave.setBounds(41, 233, 89, 23);
		panelSelectItens.add(btnMenuSave);
		
		JButton btnMenuCancel = new JButton("Cancelar");
		btnMenuCancel.setBounds(130, 233, 89, 23);
		panelSelectItens.add(btnMenuCancel);
		
		JButton btnMenuInsert = new JButton("Inserir");
		btnMenuInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuInsert.setBounds(41, 199, 178, 23);
		panelSelectItens.add(btnMenuInsert);
		
		JPanel panelMountedMenu = new JPanel();
		panelMountedMenu.setBounds(270, 67, 349, 267);
		panelMenuReg.add(panelMountedMenu);
		panelMountedMenu.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(618, 67, -346, 267);
		panelMenuReg.add(scrollPane);

		JLayeredPane paneProductReg = new JLayeredPane();
		paneProductReg.setBackground(Color.LIGHT_GRAY);
		tabbedAdminFullReg.addTab("Produto", null, paneProductReg, null);

		JPanel panelProdReg = new JPanel();
		panelProdReg.setBounds(0, 0, 629, 345);
		paneProductReg.add(panelProdReg);
		panelProdReg.setLayout(null);

		JPanel panelProdItens = new JPanel();
		panelProdItens.setBounds(119, 67, 390, 125);
		panelProdReg.add(panelProdItens);
		panelProdItens.setLayout(null);

		JLabel lblProdName = new JLabel("Nome ");
		lblProdName.setBounds(10, 42, 62, 14);
		panelProdItens.add(lblProdName);

		fieldProdName = new JTextField();
		fieldProdName.setColumns(10);
		fieldProdName.setBounds(79, 39, 300, 20);
		panelProdItens.add(fieldProdName);

		JLabel lblProdPrice = new JLabel("Pre\u00E7o");
		lblProdPrice.setBounds(10, 67, 62, 14);
		panelProdItens.add(lblProdPrice);

		fieldProdPrice = new JTextField();
		fieldProdPrice.setColumns(10);
		fieldProdPrice.setBounds(79, 64, 120, 20);
		panelProdItens.add(fieldProdPrice);

		JLabel lblProdCategory = new JLabel("Categoria");
		lblProdCategory.setBounds(10, 11, 62, 14);
		panelProdItens.add(lblProdCategory);

		comboProdCategory = new JComboBox<String>();
		comboProdCategory.setBounds(79, 11, 300, 20);
		comboProdCategory.addItem(EnumCategories.DRINKS.getCategory());
		comboProdCategory.addItem(EnumCategories.SNACK.getCategory());
		panelProdItens.add(comboProdCategory);

		JButton btnProdSave = new JButton("Salvar");
		btnProdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = fieldProdName.getText();
					double price = Double.parseDouble(fieldProdPrice
							.getText());
					String category = comboProdCategory.getSelectedItem().toString();
					if (facade.registeringProduct(name, price, category)) {
						JOptionPane.showMessageDialog(getContentPane(),"Produto cadastrado com sucesso");
						// limpando 
						fieldProdName.setText("");
						fieldProdPrice.setText("");
					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Produto N�o cadastrado!!!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Produto N�o cadastrado!!!", "Pre�o Inv�lido",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnProdSave.setBounds(153, 95, 130, 23);
		panelProdItens.add(btnProdSave);

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

		table = new JTable();
		table.setBounds(10, 326, 609, -87);
		panelAdminReg.add(table);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(119, 67, 390, 125);
		panelAdminReg.add(panel);

		JLabel lblAdminName = new JLabel("Usuario");
		lblAdminName.setBounds(10, 11, 62, 14);
		panel.add(lblAdminName);

		fieldAdminName = new JTextField();
		fieldAdminName.setColumns(10);
		fieldAdminName.setBounds(79, 11, 300, 20);
		panel.add(fieldAdminName);

		JLabel lblAdminPasswd = new JLabel("Senha");
		lblAdminPasswd.setBounds(10, 42, 42, 14);
		panel.add(lblAdminPasswd);

		fieldAdminPasswd = new JPasswordField();
		fieldAdminPasswd.setBounds(79, 39, 300, 20);
		panel.add(fieldAdminPasswd);

		JButton btnAdminSave = new JButton("Salvar");
		btnAdminSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = fieldAdminName.getText();
					char[] arrayPassword = fieldAdminPasswd.getPassword();
					String password = "";
					for (int i = 0; i < arrayPassword.length; i++) {
						password += arrayPassword[i];
					}
					if (facade.registeringAdmin(name, password)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Administrador cadastrado com sucesso");
						// limpando
						fieldProdName.setText("");
					} else {
						JOptionPane.showMessageDialog(getContentPane(),

								"Administrador N�o cadastrado!!!", "Erro",

								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
				}
			}
		});
		btnAdminSave.setBounds(153, 85, 130, 23);
		panel.add(btnAdminSave);
	}
}