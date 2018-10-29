package com.cyg.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyg.models.ProjectsIdeas;
import com.cyg.service.ProjectsIdeasService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ProjectsIdeasController {

		@Autowired
		protected ProjectsIdeasService projectsIdeasService;
		protected ObjectMapper mapper;
		
		@RequestMapping(value = "/getProjectsIdeas", method = RequestMethod.GET)
		public List<ProjectsIdeas> getProjectsIdeas() {
			return this.projectsIdeasService.findAll();
		}
		
		@RequestMapping(value = "/deleteProjectsIdeas", method = RequestMethod.POST)
		public void deleteProjectsIdeas(@RequestBody String projectsIdeasJson) throws Exception {
			this.mapper = new ObjectMapper();

			ProjectsIdeas projectsIdeas = this.mapper.readValue(projectsIdeasJson, ProjectsIdeas.class);
			this.projectsIdeasService.deleteProjectsIdeas(projectsIdeas.getProjectsIdeasId());
		}
		
		@RequestMapping(value = "/saveOrUpdateProjectsIdeas", method = RequestMethod.POST)
		public void saveOrUpdateProjectsIdeas(@RequestBody String projectsIdeasJson) 
		throws JsonParseException, JsonMappingException, IOException {
			
			this.mapper = new ObjectMapper();
			ProjectsIdeas projectsIdeas = this.mapper.readValue(projectsIdeasJson, ProjectsIdeas.class);
			this.projectsIdeasService.save(projectsIdeas);
		}
}
