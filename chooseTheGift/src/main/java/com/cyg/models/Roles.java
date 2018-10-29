package com.cyg.models;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="roles")
@Access(AccessType.FIELD)

public class Roles extends IdEntity {
	
	@Column(name = "roles_rolecode")
	private String roles_rolecode;

	@Column(name = "roles_rolename")
	private String roles_rolename;
	
	@OneToMany(targetEntity=User.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> user;
//	User user;
//	
	public Roles() {}
	
	public String getRoles_rolecode() {
		return roles_rolecode;
	}

	public void setRoles_rolecode(String roles_rolecode) {
		this.roles_rolecode = roles_rolecode;
	}

	public String getRoles_rolename() {
		return roles_rolename;
	}
	
	public Roles(String roles_rolecode, String roles_rolename) {
		
		this.roles_rolecode = roles_rolecode;
		this.roles_rolename = roles_rolename;
	}

	public String toString(){
		String info = String.format("Roles: %s", this.roles_rolename);
		return info;
	}

}
