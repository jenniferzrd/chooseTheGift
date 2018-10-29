package com.cyg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyg.dao.ProjectsUsersRepo;
import com.cyg.models.Project;
import com.cyg.models.ProjectsUsers;
import com.cyg.models.ProjectsUsersId;

@Service
public class ProjectsUsersServiceImpl implements ProjectsUsersService {

	@Autowired
	private ProjectsUsersRepo projectsUsersRepository;
	
	@Override
	public List<ProjectsUsers> findAll() {
		return this.projectsUsersRepository.findAll();
	}
	
	@Override
	public ProjectsUsers save(ProjectsUsers projectsUsers) {
	return this.projectsUsersRepository.save(projectsUsers);
	}

	@Override
	public void deleteProjectsUsers(ProjectsUsersId projectsUsersId) {
		this.projectsUsersRepository.deleteById(projectsUsersId);
		
	}
}
