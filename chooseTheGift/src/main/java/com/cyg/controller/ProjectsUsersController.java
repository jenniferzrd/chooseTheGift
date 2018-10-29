package com.cyg.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyg.models.Project;

import com.cyg.models.ProjectsUsers;
import com.cyg.models.ProjectsUsersId;
import com.cyg.service.ProjectsUsersService;
import com.cyg.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProjectsUsersController {

	@Autowired
	protected ProjectsUsersService projectsUsersService;
	protected ObjectMapper mapper;

	@RequestMapping(value = "/getProjectsUsers", method = RequestMethod.GET)
	public List<ProjectsUsers> getProjectsUsers() {
		return this.projectsUsersService.findAll();
	}

	@RequestMapping(value = "/saveOrUpdateProjectsUsers", method = RequestMethod.POST)
	public ProjectsUsers saveOrUpdateProjectsUsers(@RequestBody String projectsUsersJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();

		ProjectsUsers projectsUsers = this.mapper.readValue(projectsUsersJson, ProjectsUsers.class);
		return this.projectsUsersService.save(projectsUsers);
	}

	 @RequestMapping(value = "/deleteProjectsUsers", method = RequestMethod.POST)
	 public void deleteProjectsUsers(@RequestBody String projectsUsersJson) throws
	 Exception {
	 this.mapper = new ObjectMapper();
	
	 ProjectsUsers projectsUsers = this.mapper.readValue(projectsUsersJson,
	 ProjectsUsers.class);
	 
	 this.projectsUsersService.deleteProjectsUsers(projectsUsers.getProjectsUsersId());
	 }

}