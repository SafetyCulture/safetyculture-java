package com.safetyculture.model;

public class Media {
	private String date_created;
	private String file_ext;
	private String media_id;
	private String label;
	private String href;
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String dateCreated) {
		date_created = dateCreated;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String fileExt) {
		file_ext = fileExt;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@Override
	public String toString() {
		return "Media [date_created=" + date_created + ", file_ext=" + file_ext
				+ ", href=" + href + ", label=" + label + ", media_id="
				+ media_id + "]";
	}
	
	

}
