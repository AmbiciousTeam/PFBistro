package br.com.ambiciousteam.pfbistro.facade;

import br.com.ambiciousteam.pfbistro.logic.LogicIF;
import br.com.ambiciousteam.pfbistro.logic.LogicImpl;

public class FacadeAdminImpl implements FacadeAdmin {
	
	private LogicIF logic;
	
	public FacadeAdminImpl() {
		logic = new LogicImpl();
	}
	
	@Override
	public boolean login(String user, String password) {

		return false;
	}

	@Override
	public boolean registeringProduct(String name, double price, String Category) {
		return logic.createAndCadastreProduct(name, price, Category);	
		
	}

	@Override
	public boolean registeringAdmin(String name, String password) {
		return logic.registeringAdmin(name, password);	
	}

}
