package br.com.ambiciousteam.pfbistro.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.ambiciousteam.pfbistro.enummeration.EnumCategories;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
import br.com.ambiciousteam.pfbistro.facade.FacadeAdminImpl;
import br.com.ambiciousteam.pfbistro.model.Product;

@SuppressWarnings("serial")
public class ViewClient extends JFrame {

	private JPanel contentPane;
	private FacadeAdmin facade;
	private JComboBox<String> comboMenuSelectCat;
	private JComboBox<Product> comboMenuSelectItem;
	private String selectedCategory;
	private JScrollPane scrollMenuItens;
	private JList<Product> list;
	private ArrayList<Product> listProductsSelected;

	/**
	 * Create the frame.
	 */
	public ViewClient() {
		listProductsSelected = new ArrayList<Product>();
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
		tabbedAdminFullReg.addTab("Cardápio", null, paneMenuReg, null);

		JPanel panelMenuReg = new JPanel();
		panelMenuReg.setLayout(null);
		panelMenuReg.setBounds(0, 0, 629, 345);
		paneMenuReg.add(panelMenuReg);

		JLabel lblCadastroDeCardpio = new JLabel("Card\u00E1pio");
		lblCadastroDeCardpio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCardpio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeCardpio.setBounds(106, 11, 513, 45);
		panelMenuReg.add(lblCadastroDeCardpio);

		JPanel panelSelectItens = new JPanel();
		panelSelectItens.setBounds(10, 67, 609, 54);
		panelMenuReg.add(panelSelectItens);
		panelSelectItens.setLayout(null);

		JLabel lblMenuSelectCat = new JLabel("Selecione uma categoria");
		lblMenuSelectCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSelectCat.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblMenuSelectCat.setBounds(0, 0, 180, 14);
		panelSelectItens.add(lblMenuSelectCat);

		comboMenuSelectItem = new JComboBox<>();
		comboMenuSelectItem.setBounds(190, 25, 330, 20);

		comboMenuSelectCat = new JComboBox<String>();
		comboMenuSelectCat.setBounds(0, 25, 180, 20);
		comboMenuSelectCat.addItem(EnumCategories.DRINKS.getCategory());
		comboMenuSelectCat.addItem(EnumCategories.SNACK.getCategory());
		comboMenuSelectCat.addItem(EnumCategories.PIZZA.getCategory());
		comboMenuSelectCat.addItem(EnumCategories.DESSERT.getCategory());
		panelSelectItens.add(comboMenuSelectCat);
		setSelectedCategory(comboMenuSelectCat.getSelectedItem().toString());

		comboMenuSelectCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setSelectedCategory(comboMenuSelectCat.getSelectedItem()
						.toString());
				comboMenuSelectItem.removeAllItems();			
				List<Product> allProducts = facade.getAllProducts(getSelectedCategory());
				for (Product product : allProducts) {
					comboMenuSelectItem.addItem(product);
				}

			}
		});

		JLabel lblMenuSelectItem = new JLabel("Selecione um item");
		lblMenuSelectItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSelectItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMenuSelectItem.setBounds(190, 0, 328, 14);
		panelSelectItens.add(lblMenuSelectItem);

		panelSelectItens.add(comboMenuSelectItem);

		JPanel panelMountedMenu = new JPanel();
		panelMountedMenu.setBackground(Color.WHITE);
		panelMountedMenu.setBounds(10, 132, 505, 202);
		panelMenuReg.add(panelMountedMenu);
		panelMountedMenu.setLayout(null);

		scrollMenuItens = new JScrollPane();
		scrollMenuItens.setBounds(0, 0, 505, 202);

		list = new JList<Product>();
		list.setBounds(10, 132, 505, 202);
		
		scrollMenuItens.setViewportView(list);
		panelMountedMenu.add(scrollMenuItens);
		panelMountedMenu.add(scrollMenuItens);
		
		
		
		JButton btnMenuInsert = new JButton("Inserir");
		btnMenuInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuInsert.setBounds(528, 25, 81, 22);
		panelSelectItens.add(btnMenuInsert);
		btnMenuInsert.addActionListener(new ActionListener() {

			// auxiliary attribute to insert data (products) in the list
			DefaultListModel<Product> modelo = new DefaultListModel<Product>();

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Product selectedItem = (Product) comboMenuSelectItem.getSelectedItem();
				if(selectedItem != null){
				
				listProductsSelected.add(selectedItem);
				modelo.addElement(selectedItem);
				list.setModel(modelo);}
			}
		});

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double calculateRequest = facade.calculateRequest(listProductsSelected);
				
				JOptionPane.showMessageDialog(getContentPane(), "Valor do pedido  = R$ "+ calculateRequest);
			}
		});
		btnCalcular.setBounds(525, 132, 94, 33);
		panelMenuReg.add(btnCalcular);
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
}