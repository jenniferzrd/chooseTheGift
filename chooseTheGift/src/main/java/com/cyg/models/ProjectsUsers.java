package com.cyg.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="projects_users")
@Access(AccessType.FIELD)

public class ProjectsUsers {

	@EmbeddedId
	private ProjectsUsersId projectsUsersId;
	
	public ProjectsUsers() {}
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(name = "id_users", insertable = false, updatable = false)
//	private User user;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(name = "id_plan", insertable = false, updatable = false)
//	private Project project;
	
	public ProjectsUsersId getProjectsUsersId() {
		return projectsUsersId;
	}

	public void setProjectsUsersId(ProjectsUsersId projectsUsersId) {
		this.projectsUsersId = projectsUsersId;
	}
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
//	
//	public ProjectsUsers(ProjectsUsersId projectsUsersId, User user, Project project) {
//		super();
//		this.projectsUsersId = projectsUsersId;
//		this.user = user;
//		this.project = project;
//	}
}
