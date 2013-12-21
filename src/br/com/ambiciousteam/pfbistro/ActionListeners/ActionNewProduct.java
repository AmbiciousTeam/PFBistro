//package br.com.ambiciousteam.pfbistro.ActionListeners;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;
//
//public class ActionNewProduct implements ActionListener {
//	
//	@SuppressWarnings("unused")
//	private FacadeAdmin facade;
//	
//	public ActionNewProduct(FacadeAdmin facade) {
//		this.facade = facade;
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent save) {
//		
//		try {
//			String name = fieldProdName.getText().toUpperCase();
//			
//			double price = Double.parseDouble(fieldProdPrice.getText());
//			String category = comboProdCategory.getSelectedItem().toString();
//			if (facade.registeringProduct(name , price, category)) {
//				JOptionPane.showMessageDialog(getContentPane(),
//						"Produto cadastrado com sucesso");
//				// limpando
//				fieldProdName.setText("");
//				fieldProdPrice.setText("");
//				fieldProdName.requestFocus();
//			} else {
//				JOptionPane.showMessageDialog(getContentPane(),
//						"Produto Não cadastrado!!!", "Erro",
//						JOptionPane.ERROR_MESSAGE);
//			}
//		} catch (NumberFormatException e2) {
//			JOptionPane.showMessageDialog(getContentPane(),
//					"Produto Não cadastrado!!!", "Preço Inválido",
//					JOptionPane.ERROR_MESSAGE);
//		}
//	}
//	}
// }
