package br.com.ambiciousteam.pfbistro.abstractFactory;

import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public class FactoryImpl implements FactoryIF {

	@Override
	public Administrator createAdministrator(String name, String password) {
		
		Administrator admin = new Administrator();
		admin.setAdminName(name);
		admin.setAdminPassoword(password);
		return admin;
	}

	@Override
	public Product createProduct(String name, double price, String category) {
		
		Product product = new Product();
		product.setProductCategory(category);
		product.setProductPrice(price);
		product.setProductName(name);
		return product;
	}

}
