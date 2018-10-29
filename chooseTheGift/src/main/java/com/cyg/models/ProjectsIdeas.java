package com.cyg.models;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="projects_ideas")
@Access(AccessType.FIELD)

public class ProjectsIdeas {
	
	@EmbeddedId
	private ProjectsIdeasId projectsIdeasId;
	
	public ProjectsIdeas() {}

	public ProjectsIdeasId getProjectsIdeasId() {
		return projectsIdeasId;
	}

	public void setProjectsIdeasId(ProjectsIdeasId projectsIdeasId) {
		this.projectsIdeasId = projectsIdeasId;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_projects", insertable = false, updatable = false)
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_ideas", insertable = false, updatable = false)
	private Idea idea;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public ProjectsIdeas(ProjectsIdeasId projectsIdeasId, Project project, Idea idea) {
		super();
		this.projectsIdeasId = projectsIdeasId;
		this.project = project;
		this.idea = idea;
	}
}
