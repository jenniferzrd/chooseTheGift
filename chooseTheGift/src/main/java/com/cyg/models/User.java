package com.cyg.models;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;

@Entity
@Table(name="user")
@Access(AccessType.FIELD)

public class User extends IdEntity {

	private static final long serialVersionUID = 1314151617181920L;	

	@Column(name = "firstname", nullable = false, length = 45)
	private String firstname;
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastname;
	@Column(name = "money", nullable = false)
	private int money;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ProjectsUsers> projectsUsers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "roles_id", insertable = true, updatable = true)
	private Roles roles;
	
	public User() {}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public User(String firstname, String lastname, int money) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.money = money;
	}
	
//	public User(String firstname, String lastname, int money, List<ProjectsUsers> projectsUsers) {
//		super();
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.money = money;
//		this.projectsUsers = projectsUsers;
//	}

	public String toString(){
		String info = String.format("User: %s", this.firstname);
		return info;
	}
	
}
