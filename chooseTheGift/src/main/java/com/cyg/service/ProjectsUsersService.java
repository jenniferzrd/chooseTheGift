package com.cyg.service;

import java.util.List;

import com.cyg.models.ProjectsUsers;
import com.cyg.models.ProjectsUsersId;

public interface ProjectsUsersService {

	List<ProjectsUsers> findAll();
	ProjectsUsers save (ProjectsUsers projectsUsers);
	void deleteProjectsUsers(ProjectsUsersId projectsUsersId);
	
}
