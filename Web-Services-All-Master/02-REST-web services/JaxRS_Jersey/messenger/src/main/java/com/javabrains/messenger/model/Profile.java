package com.javabrains.messenger.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private long id;
	private String profileName;
	private Date created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Profile() {

	}

	public Profile(long id, String profileName, Date created) {
		this.id = id;
		this.profileName = profileName;
		this.created = created;
	}

}
