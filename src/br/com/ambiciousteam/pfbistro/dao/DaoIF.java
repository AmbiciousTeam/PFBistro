package br.com.ambiciousteam.pfbistro.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;
/**
 * Essa classe implementa o CRUD
 * @author Wellington
 *
 * @param <Serializable>
 */
@SuppressWarnings("hiding")
public interface DaoIF<Serializable> {
	
	public EntityManager getEntityManager();
	
	/**
	 * persiste uma entidade no banco.
	 * @param entity
	 * @return
	 */
	public Serializable create(Serializable entity);
	
	/**
	 * remove uma entidade do banco
	 * @param entity
	 */
	public void remove(Serializable entity);

	/**
	 * atualiza  a entidade no BD
	 * @param entity
	 */
	public void update(Serializable entity);

	/**
	 * Busca um objeto pelo ID
	 * @param classe
	 * @param pk
	 * @return
	 */
	public Serializable getById(Class<Serializable> classe, long pk);
	
	/**
	 * busca todas as tuplas de uma classe que estão no BD
	 * @param classe
	 * @return
	 */
	public List<Serializable> getAll(Class<Serializable> classe);
	
	/**
	 * retorna todos os prdutos de uma determinada categoria
	 * @param category
	 * @return
	 */
	List<Product> getProductByCategory(String category);

	/**
	 * retorna todos os administradores
	 * @return
	 */
	List<Administrator> getListAdministrator();

	public ArrayList<String> getProductsNames();

	public ArrayList<String> getAdminsNames();
}
