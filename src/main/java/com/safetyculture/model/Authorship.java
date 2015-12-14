package com.safetyculture.model;

public class Authorship {
	private String author;
	private String owner;
	private String device_id;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String deviceId) {
		device_id = deviceId;
	}
	
	@Override
	public String toString() {
		return "Authorship [author=" + author + ", device_id=" + device_id
				+ ", owner=" + owner + "]";
	}
	
	

}
