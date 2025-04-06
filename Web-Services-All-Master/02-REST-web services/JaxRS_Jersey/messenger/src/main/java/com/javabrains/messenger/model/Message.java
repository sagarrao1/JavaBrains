 package com.javabrains.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;	
	
	private Map<Long, Comment> comments = new HashMap<Long, Comment>();
	private List<Link> links = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public Message() {
		
	}
	
	public Message(long id, String message, Date created, String author) {
		this.id = id;
		this.message = message;
		this.created = created;
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public void addLink(String url, String rel) {
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);		
		links.add(link);
	}
	
	
	
}
