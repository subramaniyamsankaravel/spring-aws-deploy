package com.mindtree.minds.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Minds {
	@Id
	private int mindId;
	private String mindName;
	private String trackName;
	private String role;
	private String phoneNumber;

	public Minds() {
		// TODO Auto-generated constructor stub
	}

	public Minds(int mindId, String mindName, String trackName, String role, String phoneNumber) {
		super();
		this.mindId = mindId;
		this.mindName = mindName;
		this.trackName = trackName;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public int getMindId() {
		return mindId;
	}

	public void setMindId(int mindId) {
		this.mindId = mindId;
	}

	public String getMindName() {
		return mindName;
	}

	public void setMindName(String mindName) {
		this.mindName = mindName;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
