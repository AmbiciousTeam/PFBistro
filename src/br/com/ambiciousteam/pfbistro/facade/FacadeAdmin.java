package br.com.ambiciousteam.pfbistro.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Product;


public interface FacadeAdmin {
	
	public boolean login(String user, String password);
	
	public boolean registeringProduct( String name, double price, String Category );

	public boolean registeringAdmin( String name, String password ) throws MsgErrorException;

	public List<Product> getAllProducts(String category);

	public double calculateRequest(ArrayList<Product> listProductsSelected);

	public void verifyExistAdmin() throws MsgErrorException;

}
