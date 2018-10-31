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

@Entity
@Table(name="project")
@Access(AccessType.FIELD)

public class Project extends IdEntity {
	
	@Column(name = "title",length = 45)
	private String title;
	@Column(name = "totalmoney")
	private int totalMoney;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ProjectsUsers> projectsUsers;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ProjectsIdeas> projectsIdeas;
	
	public Project() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTotalmoney() {
		return totalMoney;
	}
	public void setTotalmoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
//	public Project(String title, int totalMoney, List<ProjectsUsers> projectsUsers, List<ProjectsIdeas> projectsIdeas) {
//		this.title = title;
//		this.totalMoney = totalMoney;
//		this.projectsUsers = projectsUsers;
//		this.projectsIdeas = projectsIdeas;
//}
	
//	public Project(String title, int totalMoney, List<ProjectsUsers> projectsUsers) {
//	this.title = title;
//	this.totalMoney = totalMoney;
//	this.projectsUsers = projectsUsers;
//}
	
	public Project(String title, int totalMoney) {
	this.title = title;
	this.totalMoney = totalMoney;
}
	
	public String toString(){
		String info = String.format("Project %s : %s", this.getId(), this.title);
		return info;
}

}
