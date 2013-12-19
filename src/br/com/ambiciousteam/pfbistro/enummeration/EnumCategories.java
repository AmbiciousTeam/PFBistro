/**
 * 
 */
package br.com.ambiciousteam.pfbistro.enummeration;

/**
 * @author Eclipse
 *
 */
public enum EnumCategories {
	
	DRINKS("Bebidas"), SNACK("Lanches"), PIZZA("Pizza"), DESSERT("Sobremesa");
	
	private String category;
	
	private EnumCategories(String s) {
		this.category = s;
		
	}
	
	public String getCategory() {
		return category;
	}
}