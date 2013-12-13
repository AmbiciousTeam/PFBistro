package br.com.ambiciousteam.pfbistro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "Product")
public class Product implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (name = "productId")
	private long id;
	
	@Column (name = "productPrice", nullable = false)
	private double productPrice;
	
	@Column (name = "productName", nullable = false)
	private String productName;
	
	@Column (name = "productCategory", nullable = false)
	private String productCategory;
	
	@ManyToOne
	@JoinColumn (name = "administratorId")
	private Administrator administrator;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	
	
}
