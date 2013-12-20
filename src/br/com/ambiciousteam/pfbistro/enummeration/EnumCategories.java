/**
 * 
 */
package br.com.ambiciousteam.pfbistro.enummeration;

/**
 * @author Eclipse
 *
 */
public enum EnumCategories {
	
	DRINKS("BEBIDAS"), SNACK("LANCHES"), PIZZA("PIZZA"), DESSERT("SOBREMESA");
	
	private String category;
	
	private EnumCategories(String s) {
		this.category = s;
		
	}
	
	public String getCategory() {
		return category;
	}
}