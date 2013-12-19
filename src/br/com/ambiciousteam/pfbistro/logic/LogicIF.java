package br.com.ambiciousteam.pfbistro.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public interface LogicIF {
	
	public boolean login(Administrator admin);
	
	boolean createAndCadastreProduct( String name, double price, String Category );
	
	public boolean registeringAdmin( String name, String password );

	public List<Product> searchAllProducts(String category);

	public double calculate(ArrayList<Product> listProductsSelected);
	
	
}
