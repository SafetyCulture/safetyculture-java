package com.safetyculture.model;

import java.util.Arrays;

public class ItemResponses {
	private String assets;
	private String text;
	private String value;
	private String name;
	private String timestamp;
	private String datetime;
	private String location_text;
	private Location location;
	private ResponseItem[] selected;
	private Double weather;
	private Media[] media;
	private Media image;
	public String getAssets() {
		return assets;
	}
	public void setAssets(String assets) {
		this.assets = assets;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLocation_text() {
		return location_text;
	}
	public void setLocation_text(String locationText) {
		location_text = locationText;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Double getWeather() {
		return weather;
	}
	public void setWeather(Double weather) {
		this.weather = weather;
	}
	public Media[] getMedia() {
		return media;
	}
	public void setMedia(Media[] media) {
		this.media = media;
	}
	public Media getImage() {
		return image;
	}
	public void setImage(Media image) {
		this.image = image;
	}

	public ResponseItem[] getSelected() {
		return selected;
	}

	public void setSelected(ResponseItem[] selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "ItemResponses{" +
				"assets='" + assets + '\'' +
				", text='" + text + '\'' +
				", value='" + value + '\'' +
				", name='" + name + '\'' +
				", timestamp='" + timestamp + '\'' +
				", datetime='" + datetime + '\'' +
				", location_text='" + location_text + '\'' +
				", location=" + location +
				", selected=" + Arrays.toString(selected) +
				", weather=" + weather +
				", media=" + Arrays.toString(media) +
				", image=" + image +
				'}';
	}
}
