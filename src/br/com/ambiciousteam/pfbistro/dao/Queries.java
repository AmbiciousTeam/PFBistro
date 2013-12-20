//package br.com.ambiciousteam.pfbistro.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceException;
//import javax.persistence.Query;
//
//import br.com.ambiciousteam.pfbistro.model.Product;
//import br.com.ambiciousteam.pfbistro.view.ViewAdmin;
//
//public class Queries {
//	
//	public Queries() {
////		queryProdByCat();
//	}
//	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PFBistro");
//	EntityManager em = emf.createEntityManager();
//	
////	ViewAdmin viewAdmin = new ViewAdmin(); 
//	
//	public List<Product> queryProdByCat(String c) {
//
//		String hql = "FROM Product WHERE productcategory = '"+c+"'";
//
//		Query createQuery = em.createQuery(hql);
//
//		try{
//
//			List<Product> products = createQuery.getResultList();
//
//			for ( Product product : products ) {
//				System.out.println("Product: "+ product.getProductName());
//			}
//
//		}catch(PersistenceException e){
//			e.printStackTrace();
//		}
////		em.close();
////		emf.close();
//		return createQuery.getResultList();
//	}
//}
