/**
 * 
 */
package br.com.ambiciousteam.pfbistro.enummeration;

/**
 * @author Eclipse
 *
 */
public enum EnumCategories {
	
	DRINKS("Bebidas"), SNACK("Lanches");
	
	private String category;
	
	private EnumCategories(String s) {
		this.category = s;
		
	}
	
	public String getCategory() {
		return category;
	}
}