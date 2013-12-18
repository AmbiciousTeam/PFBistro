package br.com.ambiciousteam.pfbistro.dao;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.ambiciousteam.pfbistro.model.Product;

/**
 * Table model for use showing the products storaged in database.
 * 
 * @author Cassio
 */
public class MenuTableModel extends AbstractTableModel {

	private static final int COLID = 0;
	private static final int COLCATEGORY = 1;
	private static final int COLNAME = 2;
	private static final int COLPRICE = 3;

	private List<Product> items;

	public MenuTableModel(List<Product> items) {
		this.items = items;
	}

	@Override
	public int getColumnCount() {
		return items.size();
	}

	@Override
	public int getRowCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = items.get(rowIndex);
		if(columnIndex == COLID){
			return product.getId();
		}else if(columnIndex == COLNAME){
			return product.getProductName();
		}else if(columnIndex == COLPRICE){
			return product.getProductPrice();
		}else if(columnIndex == COLCATEGORY){
			return product.getProductCategory();
		}
		return null;
	}

	@Override
	public String getColumnName(int columns) {
		String column = "";
		switch (columns) {
		case COLID:
			column = "Código";
			break;
		case COLNAME:
			column = "Nome";
			break;
		case COLPRICE:
			column = "Preço";
			break;
		case COLCATEGORY:
			column = "Categoria";
			break;
		default:
			throw new IllegalArgumentException("Coluna inválida!");
		}
		return column;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		if(columnIndex == COLID){
			return Long.class;
		}else if(columnIndex == COLNAME){
			return String.class;
		}else if(columnIndex == COLPRICE){
			return String.class;
		}else if(columnIndex == COLCATEGORY){
			return String.class;
		}
		return null;
	}
	
	public Product get(int row){
		return items.get(row);
	}
	
}