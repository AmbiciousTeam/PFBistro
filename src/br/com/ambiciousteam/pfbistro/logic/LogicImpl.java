package br.com.ambiciousteam.pfbistro.logic;

import java.io.Serializable;
import java.util.List;

import br.com.ambiciousteam.pfbistro.abstractFactory.FactoryIF;
import br.com.ambiciousteam.pfbistro.abstractFactory.FactoryImpl;
import br.com.ambiciousteam.pfbistro.dao.DaoIF;
import br.com.ambiciousteam.pfbistro.dao.DaoImpl;
import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public class LogicImpl implements LogicIF{
	
	
	private DaoIF<Serializable> dao;
	private FactoryIF factory;
	
	public LogicImpl() {
		factory = new FactoryImpl();
		dao = new DaoImpl();
	}
	@Override
	public boolean login(Administrator admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createAndCadastreProduct(String name, double price,
			String category) {
		try {

			Product newProduct = factory.createProduct(name, price, category);
			dao.create(newProduct);	
	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean registeringAdmin(String name, String password) {
		try {

			Administrator newAdmin = factory.createAdministrator(name, password);
			dao.create(newAdmin);	
	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public List<Product> searchAllProducts(String category) {
		// TODO Auto-generated method stub
		return dao.getProductByCategory(category);
	}

}
