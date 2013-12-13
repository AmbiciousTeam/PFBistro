package br.com.ambiciousteam.pfbistro.logic;

import br.com.ambiciousteam.pfbistro.model.Administrator;

public interface LogicIF {
	
	public boolean login(Administrator admin);
	
	boolean createAndCadastreProduct( String name, double price, String Category );
	
	public boolean registeringAdmin( String name, String password );
	
	
}
