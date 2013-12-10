package br.com.ambiciousteam.pfbistro.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<Serializable> {

	public EntityManager getEntityManager();

	public Serializable create(Serializable entity);

	public void remove(Serializable entity);

	public void update(Serializable entity);

	public Serializable getById(Class<Serializable> classe, long pk);

	public List<Serializable> getAll(Class<Serializable> classe);

}
