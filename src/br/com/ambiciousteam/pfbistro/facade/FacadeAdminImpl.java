package br.com.ambiciousteam.pfbistro.facade;

import java.util.List;

import br.com.ambiciousteam.pfbistro.logic.LogicIF;
import br.com.ambiciousteam.pfbistro.logic.LogicImpl;
import br.com.ambiciousteam.pfbistro.model.Product;

public class FacadeAdminImpl implements FacadeAdmin {
	
	private LogicIF logic;
	
	public FacadeAdminImpl() {
		logic = new LogicImpl();
	}
	
	@Override
	public boolean login(String user, String password) {

		return false;
	}

	@Override
	public boolean registeringProduct(String name, double price, String Category) {
		return logic.createAndCadastreProduct(name, price, Category);	
		
	}

	@Override
	public boolean registeringAdmin(String name, String password) {
		return logic.registeringAdmin(name, password);	
	}
	
	@Override
	public List<Product> getAllProducts(String category) {
		
		return logic.searchAllProducts(category);
	}
	
}
