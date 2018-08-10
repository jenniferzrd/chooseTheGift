package com.cyg.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="idea")
@Access(AccessType.FIELD)
public class Idea extends IdEntity {
	
	@Column(name = "title", nullable = false, length = 45)
	private String title;
	
	@Column(name = "img", nullable = false, length = 45)
	private String img;
	
	@Column(name = "comment", nullable = false, length = 45)
	private String comment;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "jaime")
	private boolean jaime;

	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getComment() {
		return comment;
	}
	public void setDesc(String comment) {
		this.comment = comment;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean isJaime() {
		return jaime;
	}
	public void setJaime(boolean jaime) {
		this.jaime = jaime;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
