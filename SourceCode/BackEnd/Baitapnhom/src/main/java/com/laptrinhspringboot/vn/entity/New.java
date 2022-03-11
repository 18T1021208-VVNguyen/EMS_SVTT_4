package com.laptrinhspringboot.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class New extends Base{

	@Column(name = "title", columnDefinition = "VARCHAR(255) NOT NULL")
	private String title;

	@Column(name = "content", columnDefinition = "VARCHAR(255) NOT NULL")
	private String content;

	@Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
	private String description;

	public New(String title, String content, String description) {
		super();
		this.title = title;
		this.content = content;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
