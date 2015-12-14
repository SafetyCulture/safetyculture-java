package com.safetyculture.model;

public class AuditAssets {
	
	private String barcode;
	private Long cost;
//	private String custom_fields;
	private Long depreciation;
	private Long depth;
	private String description;
	private Long height;
	private String id;
	private String identifier;
	private String make;
//	private String media;
	private String model;
	private String serial_number;
	private String time_stamp;
	private String title;
	private Long weight;
	private Long width;
	private Long year_of_manufacture;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Long getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(Long depreciation) {
		this.depreciation = depreciation;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getHeight() {
		return height;
	}
	public void setHeight(Long height) {
		this.height = height;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serialNumber) {
		serial_number = serialNumber;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String timeStamp) {
		time_stamp = timeStamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	public Long getWidth() {
		return width;
	}
	public void setWidth(Long width) {
		this.width = width;
	}
	public Long getYear_of_manufacture() {
		return year_of_manufacture;
	}
	public void setYear_of_manufacture(Long yearOfManufacture) {
		year_of_manufacture = yearOfManufacture;
	}
	@Override
	public String toString() {
		return "AuditAssets [barcode=" + barcode + ", cost=" + cost
				+ ", depreciation=" + depreciation + ", depth=" + depth
				+ ", description=" + description + ", height=" + height
				+ ", id=" + id + ", identifier=" + identifier + ", make="
				+ make + ", model=" + model + ", serial_number="
				+ serial_number + ", time_stamp=" + time_stamp + ", title="
				+ title + ", weight=" + weight + ", width=" + width
				+ ", year_of_manufacture=" + year_of_manufacture + "]";
	}
	
	
	

}
