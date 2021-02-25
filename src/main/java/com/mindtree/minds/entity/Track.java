package com.mindtree.minds.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
	@Id
	private int trackId;
	private String trackName;
	private int no_Of_minds;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(int trackId, String trackName, int no_Of_minds) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.no_Of_minds = no_Of_minds;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public int getNo_Of_minds() {
		return no_Of_minds;
	}

	public void setNo_Of_minds(int no_Of_minds) {
		this.no_Of_minds = no_Of_minds;
	}

}
