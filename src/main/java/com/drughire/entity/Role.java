package com.drughire.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="role_seq", initialValue=1, allocationSize=50)
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_seq")
	private Integer id;
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
