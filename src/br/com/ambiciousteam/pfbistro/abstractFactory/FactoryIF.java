package br.com.ambiciousteam.pfbistro.abstractFactory;



import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public interface FactoryIF {
	
	Administrator createAdministrator(String name, String password);
	
	Product createProduct (String name, double price, String category);
		
}
