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

import com.cyg.models.Roles;
import com.cyg.service.RolesService;
import com.cyg.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class RolesController {
	
	@Autowired
	protected RolesService rolesService;
	protected ObjectMapper mapper;

	@RequestMapping(value = "/getRoles", method = RequestMethod.GET)
	public List<Roles> getUsers() {
		return this.rolesService.findAll();
	}
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public void deleteRole(@RequestBody String rolesJson) throws Exception {
		this.mapper = new ObjectMapper();

		Roles roles = this.mapper.readValue(rolesJson, Roles.class);

		if (roles.getRoles_rolecode() == null) {
			throw new Exception("Id null");
		}
		this.rolesService.deleteRole(roles.getId());
	}
	
	@RequestMapping(value = "/saveOrUpdateRoles", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRoles(@RequestBody String rolesJson) 
	throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		
		Roles roles = this.mapper.readValue(rolesJson, Roles.class);
		
		if (!this.validate(roles)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Veuillez remplir les champs");
		}
		
		this.rolesService.save(roles);

		return new RestResponse(HttpStatus.OK.value(), "Succès");
	}
	
	private boolean validate(Roles roles) {
		boolean isValid = true;

		if (StringUtils.trimToNull(roles.getRoles_rolename()) == null) {
			isValid = false;
		}
		return isValid;
	}
}
