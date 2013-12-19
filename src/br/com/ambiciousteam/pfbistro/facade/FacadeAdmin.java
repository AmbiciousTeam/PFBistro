package br.com.ambiciousteam.pfbistro.facade;

import java.util.List;

import br.com.ambiciousteam.pfbistro.model.Product;


public interface FacadeAdmin {
	
	public boolean login(String user, String password);
	
	public boolean registeringProduct( String name, double price, String Category );

	public boolean registeringAdmin( String name, String password );

	List<Product> getAllProducts(String category);
	
}
