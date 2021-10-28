package com.nagarro.entity_class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Books 
{
	@Id
	private int bookCode;
	
	private String bookName;
	
	@CreatedDate
	@Column(updatable = false, nullable = false)
	private Date createdAt;
	
	@ManyToOne
	private Authors author;

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	@Override
	public String toString() {
		return "Books [bookCode=" + bookCode + ", bookName=" + bookName + ", createdAt=" + createdAt + ", author="
				+ author + "]";
	}
	
	
}
