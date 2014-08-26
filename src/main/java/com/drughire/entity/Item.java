package com.drughire.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	private String title;
	private String link;
	@Column(name = "published_date")
	private Date publishedDate;

	@ManyToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}
