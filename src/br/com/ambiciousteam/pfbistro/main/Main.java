/**
 * 
 */
package br.com.ambiciousteam.pfbistro.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Eclipse
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PFBistro");
		
		emf.close();

	}

}
