package br.com.ambiciousteam.pfbistro.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ambiciousteam.pfbistro.facade.FacadeAdmin;

public class ActionNewProduct implements ActionListener {
	
	@SuppressWarnings("unused")
	private FacadeAdmin facade;
	
	public ActionNewProduct(FacadeAdmin facade) {
		this.facade = facade;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	
}
