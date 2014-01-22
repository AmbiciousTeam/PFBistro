/**
 * 
 */
package br.com.ambiciousteam.pfbistro.main;

import java.awt.EventQueue;

import br.com.ambiciousteam.pfbistro.view.swing.ViewSelectUser;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
