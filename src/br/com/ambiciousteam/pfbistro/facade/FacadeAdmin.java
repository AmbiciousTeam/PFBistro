package br.com.ambiciousteam.pfbistro.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.model.Product;


public interface FacadeAdmin {
	/**
	 * metodo para validar o login do usuario
	 * @param user, usuario
	 * @param password, senha
	 * @return true caso o usuario e senha estejam corretos
	 */
	public boolean login(String user, String password);
	
	/**
	 * registrar/armazenar um produto
	 * @param name
	 * @param price
	 * @param Category
	 * @return
	 */
	public boolean registeringProduct( String name, double price, String Category );

	/**
	 * registrar/armazenar um administrador
	 * @param name
	 * @param password
	 * @return
	 * @throws MsgErrorException
	 */
	public boolean registeringAdmin( String name, String password ) throws MsgErrorException;

	/**
	 * pegar todos os produtos por uma determinada categoria
	 * @param category
	 * @return
	 */
	public List<Product> getAllProducts(String category);
	
	/**
	 * calcula preco do pedido
	 * @param listProductsSelected
	 * @return
	 */
	public double calculateRequest(ArrayList<Product> listProductsSelected);
	
	/**
	 * verifica se existe administrador ja cadastrado
	 * @throws MsgErrorException
	 */
	public void verifyExistAdmin() throws MsgErrorException;

}
