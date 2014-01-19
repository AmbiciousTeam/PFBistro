package br.com.ambiciousteam.pfbistro.abstractFactory;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public interface FactoryIF {
	/**
	 * Metodo para criar um administrador
	 * @param name, nome do administrador
	 * @param password, senha do administrador
	 * @return um objeto do tipo administrado
	 * @throws MsgErrorException
	 */
	Administrator createAdministrator(String name, String password) throws MsgErrorException;
	/**
	 * Metodo para criar um produto
	 * @param name, nome do produto
	 * @param price, preco do produto
	 * @param category, categoria do produto
	 * @return um objeto do tipo produto
	 * @throws MsgErrorException
	 */
	Product createProduct (String name, double price, String category) throws MsgErrorException;
		
}
