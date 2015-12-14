package com.safetyculture.model;

public class TemplateMetadata {
	private String name;
	private String description;
	private Media image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Media getImage() {
		return image;
	}
	public void setImage(Media image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "TemplateMetadata [description=" + description + ", image="
				+ image + ", name=" + name + "]";
	}
	
	

}
