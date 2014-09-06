package com.drughire.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="blog_seq", initialValue=1, allocationSize=50)
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blog_seq")
	private Integer id;
	private String name;
	private String url;
	
	@OneToMany(mappedBy="blog")
	private List<Item> items;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
