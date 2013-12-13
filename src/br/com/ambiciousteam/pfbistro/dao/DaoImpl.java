package br.com.ambiciousteam.pfbistro.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

public class DaoImpl implements DaoIF<Serializable>{
	private EntityManager entityManager;
	
	public DaoImpl() {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PFBistro");
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
		
	


}
