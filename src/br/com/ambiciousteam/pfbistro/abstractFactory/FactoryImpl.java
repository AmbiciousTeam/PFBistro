package br.com.ambiciousteam.pfbistro.abstractFactory;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public class FactoryImpl implements FactoryIF {


	@Override
	public Administrator createAdministrator(String name, String password) throws MsgErrorException {

		Administrator admin = new Administrator();
		if (!name.equals("") && !password.equals("")) {
			admin.setAdminName(name);
			admin.setAdminPassword(password);
		} else {
			throw new MsgErrorException("TODOS OS CAMPOS DEVEM SER PREENCHIDOS!");
		}
		return admin;
	}

	@Override
	public Product createProduct(String name, double price, String category) throws MsgErrorException {

		Product product = new Product();
		if (!name.equals("") && !category.equals("")) {
			product.setProductCategory(category);
			product.setProductPrice(price);
			product.setProductName(name);
		} else {
			throw new MsgErrorException("TODOS OS CAMPOS DEVEM SER PREENCHIDOS!");
		}
		return product;
	}

}
