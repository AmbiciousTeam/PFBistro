package br.com.ambiciousteam.pfbistro.abstractFactory;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public interface FactoryIF {
	
	Administrator createAdministrator(String name, String password) throws MsgErrorException;
	
	Product createProduct (String name, double price, String category) throws MsgErrorException;
		
}
