package com.cyg.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectsUsersId implements Serializable {

		@Column(name = "id", unique = true, nullable = false)
		private int id;
		
		@Column(name = "id_users", unique = true, nullable = false)
		private int id_users;
		
		@Column(name = "id_plan", unique = true, nullable = false)
		private int id_plan;
		
		public ProjectsUsersId(int id, int id_users, int id_plan) {
			this.id = id;
			this.id_users = id_users;
			this.id_plan = id_plan;
		}
		
		public ProjectsUsersId() {
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId_users() {
			return id_users;
		}

		public void setId_users(int id_users) {
			this.id_users = id_users;
		}

		public int getId_plan() {
			return id_plan;
		}

		public void setId_plan(int id_plan) {
			this.id_plan = id_plan;
		}
		
}
