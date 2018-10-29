package com.cyg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyg.models.ProjectsUsers;
import com.cyg.models.ProjectsUsersId;

public interface ProjectsUsersRepo extends JpaRepository<ProjectsUsers, ProjectsUsersId>  {

}
