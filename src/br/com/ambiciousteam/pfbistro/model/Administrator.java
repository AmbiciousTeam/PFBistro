package br.com.ambiciousteam.pfbistro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Administrator")
public class Administrator {
		
	
	
	
	@Id
	@GeneratedValue (strategy  = GenerationType.SEQUENCE)
	@Column (name  = "adminstratorId")
	private long id;
	
	@Column(name = "adminName", length = 30, nullable = false)
	private String adminName;
	
	@Column (name = "adminPassoword" , length = 30 , nullable = false)
	private String adminPassoword;

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

	public String getAdminPassoword() {
		return adminPassoword;
	}

	public void setAdminPassoword(String adminPassoword) {
		this.adminPassoword = adminPassoword;
	}
	
	
	
}
