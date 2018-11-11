package com.cyg.models;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="project")
@Access(AccessType.FIELD)

public class Project extends IdEntity {
	
	@Column(name = "title",length = 45)
	private String title;
	@Column(name = "totalmoney")
	private int totalMoney;

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
	
	public Project(String title, int totalMoney) {
	this.title = title;
	this.totalMoney = totalMoney;
}
	
	public String toString(){
		String info = String.format("Project %s : %s", this.getId(), this.title);
		return info;
}

}
