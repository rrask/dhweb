package com.drughire.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="user_seq", initialValue=1, allocationSize=1)
@Table(name = "app_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    private Integer id;
	private String name;
	private String password;
	private String email;
	private Boolean enabled;
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Blog> blogs;
	
	
	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

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
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
