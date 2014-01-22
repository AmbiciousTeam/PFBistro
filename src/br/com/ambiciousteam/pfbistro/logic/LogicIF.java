package br.com.ambiciousteam.pfbistro.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Product;

public interface LogicIF {

	/**
	 * cria e cadastra produto
	 * 
	 * @param name
	 * @param price
	 * @param Category
	 * @return
	 */
	boolean createAndCadastreProduct(String name, double price, String Category);

	/**
	 * registra administrado
	 * 
	 * @param name
	 * @param password
	 * @return true caso nao der nada errado
	 * @throws MsgErrorException
	 */
	public boolean registeringAdmin(String name, String password)
			throws MsgErrorException;

	/**
	 * busca todos os produtos por categoria
	 * 
	 * @param category
	 * @return
	 */
	public List<Product> searchAllProducts(String category);

	/**
	 * calcula o preço do produto
	 * 
	 * @param listProductsSelected
	 * @return
	 */
	public double calculate(ArrayList<Product> listProductsSelected);

	/**
	 * login do usuario
	 * 
	 * @param use
	 * @param password
	 * @return true caso o login esteja correto
	 */
	boolean login(String use, String password);

	/**
	 * verifica se existe administrado ja cadastrado
	 * 
	 * @throws MsgErrorException
	 */
	public void verifyExistAdministrator() throws MsgErrorException;

}
