package com.drughire.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String Name;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Blog> blogs;
	
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
