package com.cyg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyg.dao.ProjectRepo;
import com.cyg.dao.ProjectsIdeasRepo;
import com.cyg.models.Project;
import com.cyg.models.ProjectsIdeas;
import com.cyg.models.ProjectsIdeasId;

@Service
public class ProjectsIdeasServiceImpl implements ProjectsIdeasService {

	@Autowired
	private ProjectsIdeasRepo projectsIdeasRepository;
	
	@Override
	public List<ProjectsIdeas> findAll() {
		return this.projectsIdeasRepository.findAll();
	}
	
	@Override
	public void deleteProjectsIdeas(ProjectsIdeasId projectsIdeasId) {
		this.projectsIdeasRepository.deleteById(projectsIdeasId);
	}
	
	@Override
	public ProjectsIdeas save(ProjectsIdeas projectsIdeas) {
	return this.projectsIdeasRepository.save(projectsIdeas);
	}
}
