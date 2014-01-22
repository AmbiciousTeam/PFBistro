package br.com.ambiciousteam.pfbistro.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.logic.LogicIF;
import br.com.ambiciousteam.pfbistro.logic.LogicImpl;
import br.com.ambiciousteam.pfbistro.model.Product;

public class FacadeAdminImpl implements FacadeAdmin {

	private LogicIF logic;

	public FacadeAdminImpl() {
		logic = new LogicImpl();
	}

	@Override
	public boolean registeringProduct(String name, double price, String Category) {
		return logic.createAndCadastreProduct(name, price, Category);

	}

	@Override
	public boolean registeringAdmin(String name, String password)
			throws MsgErrorException {
		return logic.registeringAdmin(name, password);
	}

	@Override
	public List<Product> getAllProducts(String category) {

		return logic.searchAllProducts(category);
	}

	@Override
	public double calculateRequest(ArrayList<Product> listProductsSelected) {
		return logic.calculate(listProductsSelected);

	}

	@Override
	public boolean login(String user, String password) {
		return logic.login(user, password);
	}

	@Override
	public void verifyExistAdmin() throws MsgErrorException {
		logic.verifyExistAdministrator();
	}
}
