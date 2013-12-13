package br.com.ambiciousteam.pfbistro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "Administrator")
public class Administrator implements Serializable{
	
	@Id
	@GeneratedValue (strategy  = GenerationType.SEQUENCE)
	@Column (name  = "adminstratorId")
	private long id;
	
	@Column(name = "adminName", length = 30, nullable = false)
	private String adminName;
	
	@Column (name = "adminPassword" , length = 30 , nullable = false)
	private String adminPassword;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPasswrd() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
}
