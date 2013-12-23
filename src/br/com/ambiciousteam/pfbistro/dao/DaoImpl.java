package br.com.ambiciousteam.pfbistro.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.ambiciousteam.pfbistro.model.Administrator;
import br.com.ambiciousteam.pfbistro.model.Product;

public class DaoImpl implements DaoIF<Serializable> {
	private EntityManager entityManager;
	private final int MINIMUN_NUMBER_OF_USER = 1;

	public DaoImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PFBistro");
		entityManager = emf.createEntityManager();
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Serializable create(Serializable entity) {
		getEntityManager().getTransaction().begin();

		try {
			getEntityManager().persist(entity);
			getEntityManager().getTransaction().commit();

		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
		return entity;
	}

	@Override
	public void remove(Serializable entity) {

	}

	@Override
	public void update(Serializable entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable getById(Class<Serializable> classe, long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serializable> getAll(Class<Serializable> classe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		String hql = "FROM Product WHERE productcategory = '" + category + "'";
		Query createQuery = getEntityManager().createQuery(hql);
		return createQuery.getResultList();
	}

	/**
	 * Returns an ArrayList of products names storage in the database.
	 * 
	 * @return
	 */
	@Override
	public ArrayList<String> getProductsNames() {
		ArrayList<String> productName = new ArrayList<>();
		String hql = "FROM Product";
		Query createQuery = getEntityManager().createQuery(hql);
		List<Product> products = createQuery.getResultList();
		for (Product product : products) {
			productName.add(product.getProductName());
		}
		return productName;
	}

	/**
	 * Returns an ArrayList of administrators names storage in the database.
	 * 
	 * @return
	 */
	@Override
	public ArrayList<String> getAdminsNames() {
		ArrayList<String> adminName = new ArrayList<>();
		String hql = "FROM Administrator";
		Query createQuery = getEntityManager().createQuery(hql);
		List<Administrator> admins = createQuery.getResultList();
		for (Administrator administrator : admins) {
			adminName.add(administrator.getAdminName());
		}
		return adminName;
	}

	@Override
	public List<Administrator> getListAdministrator() {
		String query = "FROM Administrator";
		Query createQuery = getEntityManager().createQuery(query);
		return createQuery.getResultList();
	}
}
