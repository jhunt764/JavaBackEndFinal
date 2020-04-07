package com.example.demo.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="post")
public class Post{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String authorId;
	public String message;
	private Timestamp dateTime;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    public Timestamp getDateTime() {
    	return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
    	this.dateTime = dateTime;
    }
	

	
}
