package br.com.ambiciousteam.pfbistro.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.abstractFactory.FactoryIF;
import br.com.ambiciousteam.pfbistro.abstractFactory.FactoryImpl;
import br.com.ambiciousteam.pfbistro.dao.DaoIF;
import br.com.ambiciousteam.pfbistro.dao.DaoImpl;
import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public class LogicImpl implements LogicIF {

	private static final int MINIMUN_NUMBER_OF_USER = 1;
	private DaoIF<Serializable> dao;
	private FactoryIF factory;

	public LogicImpl() {
		factory = new FactoryImpl();
		dao = new DaoImpl();
	}

	@Override
	public boolean createAndCadastreProduct(String name, double price,
			String category) {
		try {
			if (checkProductNames(name) == true) {
				Product newProduct = factory.createProduct(name, price,
						category);
				dao.create(newProduct);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Verify if name passed as parameter matches with any name storages in the
	 * database
	 * 
	 * @param adminName
	 * @return
	 */
	public boolean checkAdminNames(String adminName) {
		List<String> listAdminstrator = dao.getAdminsNames();
		for (String admins : listAdminstrator) {
			if (adminName.equals(admins)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Verify if product passed as parameter matches with any product storages
	 * in the database
	 * 
	 * @param adminName
	 * @return
	 */
	public boolean checkProductNames(String productName) {
		List<String> listProducts = dao.getProductsNames();
		for (String products : listProducts) {
			if (productName.equals(products)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean registeringAdmin(String name, String password) {
		try {
			if (checkAdminNames(name) == true) {
				Administrator newAdmin = factory.createAdministrator(name,
						password);
				dao.create(newAdmin);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Product> searchAllProducts(String category) {
		// TODO Auto-generated method stub
		return dao.getProductByCategory(category);
	}

	@Override
	public double calculate(ArrayList<Product> listProductsSelected) {
		double sum = 0;

		for (Product p : listProductsSelected) {
			sum += p.getProductPrice();
		}
		return sum;
	}

	@Override
	public boolean login(String use, String password) {
		List<Administrator> listAdminstrator = dao.getListAdministrator();
		for (Administrator administrator : listAdminstrator) {
			if ((administrator.getAdminName().equals(use))
					&& administrator.getAdminPassword().equals(password)
					&& (!administrator.getAdminName().equals(""))
					&& !administrator.getAdminPassword().equals("")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void verifyExistAdministrator() throws MsgErrorException {
		createAdminDefault("master", "master");
	}

	private void createAdminDefault(String name, String password)
			throws MsgErrorException {
		List<Administrator> listAdminstrator = dao.getListAdministrator();
		if (listAdminstrator.size() < MINIMUN_NUMBER_OF_USER) {
			Administrator admin = new Administrator();
			admin.setAdminName(name);
			admin.setAdminPassword(password);
			dao.create(admin);
		} else {
		}

	}
}
