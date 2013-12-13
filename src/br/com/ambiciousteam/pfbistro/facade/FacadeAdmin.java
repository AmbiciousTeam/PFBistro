package br.com.ambiciousteam.pfbistro.facade;


public interface FacadeAdmin {
	
	public boolean login(String user, String password);
	
	public boolean registeringProduct( String name, double price, String Category );

	public boolean registeringAdmin( String name, String password );
	
}
