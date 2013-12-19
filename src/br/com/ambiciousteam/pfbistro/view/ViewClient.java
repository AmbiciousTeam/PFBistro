package br.com.ambiciousteam.pfbistro.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
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
	private JList list;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ViewAdmin frame = new ViewAdmin();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public ViewClient() {
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
		panelSelectItens.add(comboMenuSelectCat);
		setSelectedCategory(comboMenuSelectCat.getSelectedItem().toString());

		comboMenuSelectCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setSelectedCategory(comboMenuSelectCat.getSelectedItem()
						.toString());
				List<Product> allProducts = facade
						.getAllProducts(getSelectedCategory());
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
		panelMountedMenu.setBounds(10, 132, 609, 202);
		panelMenuReg.add(panelMountedMenu);
		panelMountedMenu.setLayout(null);

		list = new JList();

		scrollMenuItens = new JScrollPane();
		scrollMenuItens.setBounds(0, 0, 609, 202);
		// scrollMenuItens.add(list);
		panelMountedMenu.add(scrollMenuItens);
		scrollMenuItens.setColumnHeaderView(list);
		scrollMenuItens.setViewportView(list);

		JButton btnMenuInsert = new JButton("Inserir");
		btnMenuInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuInsert.setBounds(528, 25, 81, 22);
		panelSelectItens.add(btnMenuInsert);
		btnMenuInsert.addActionListener(new ActionListener() {

			// auxiliary attribute to insert data (products) in the list
			DefaultListModel modelo = new DefaultListModel();

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(comboMenuSelectItem.getSelectedItem());
				list.setModel(modelo);
			}
		});

	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
}