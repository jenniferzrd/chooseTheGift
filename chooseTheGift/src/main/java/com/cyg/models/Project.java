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

}
