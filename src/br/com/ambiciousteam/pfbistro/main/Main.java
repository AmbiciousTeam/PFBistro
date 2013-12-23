/**
 * 
 */
package br.com.ambiciousteam.pfbistro.main;

import java.awt.EventQueue;

import br.com.ambiciousteam.pfbistro.dao.DaoImpl;
import br.com.ambiciousteam.pfbistro.view.ViewSelectUser;

/**
 * @author Eclipse
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSelectUser frame = new ViewSelectUser();
					frame.setVisible(true);
//					DaoImpl dao = new DaoImpl();
//					System.out.println(dao.getAdminsNames());
//					System.out.println(dao.getProductsNames());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
