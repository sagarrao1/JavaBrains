package com.javabrains.messenger.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

	private long id;
	private String commentMsg;
	private Date created;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getcommentMsg() {
		return commentMsg;
	}
	public void setcommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Comment() {
		
	}
	
	public Comment(long id, String commentMsg, Date created) {
		this.id = id;
		this.commentMsg = commentMsg;
		this.created = created;
	}
	
	
	
	
}
