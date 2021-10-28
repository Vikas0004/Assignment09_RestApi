package com.nagarro.assignment09.entity_class;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authors 
{
	public Authors() {
		
	}
	
	public Authors(String authorName) {
		super();
		this.authorName = authorName;
	}

	
	@Id
	private String authorName;
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	}
