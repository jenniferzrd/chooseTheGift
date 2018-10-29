package com.cyg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyg.models.ProjectsIdeas;
import com.cyg.models.ProjectsIdeasId;

public interface ProjectsIdeasRepo extends JpaRepository<ProjectsIdeas, ProjectsIdeasId> {

}
