package com.cyg.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ProjectsIdeasId implements Serializable {

	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "id_ideas", unique = true, nullable = false)
	private int id_ideas;
	
	@Column(name = "id_projects", unique = true, nullable = false)
	private int id_projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ideas() {
		return id_ideas;
	}

	public void setId_ideas(int id_ideas) {
		this.id_ideas = id_ideas;
	}

	public int getId_projects() {
		return id_projects;
	}

	public void setId_projects(int id_projects) {
		this.id_projects = id_projects;
	}

	public ProjectsIdeasId(int id, int id_ideas, int id_projects) {
		super();
		this.id = id;
		this.id_ideas = id_ideas;
		this.id_projects = id_projects;
	}
	
	public ProjectsIdeasId() {}
	
}
