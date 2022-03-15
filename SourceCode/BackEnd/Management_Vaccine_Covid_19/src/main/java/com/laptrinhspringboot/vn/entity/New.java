package com.laptrinhspringboot.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class New extends Base{

	@Column(name = "title", columnDefinition = "VARCHAR(255) NOT NULL")
	private String title;

	@Column(name = "content", columnDefinition = "VARCHAR(255) NOT NULL")
	private String content;

	@Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
	private String description;

}
