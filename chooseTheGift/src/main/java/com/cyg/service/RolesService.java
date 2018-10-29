package com.cyg.service;

import java.util.List;

import com.cyg.models.Roles;

public interface RolesService {
	
	Roles save (Roles roles);
	
	List<Roles> findAll();

	void deleteRole(Long id);

}
