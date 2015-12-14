package com.safetyculture.model;

import java.util.Arrays;

public class Location {
	private String administrative_area;
	private String country;
	private String[] formatted_address;
//	private String geometry;
	private String iso_country_code;
	private String locality;
	private String name;
	private String postal_code;
	private String sub_administrative_area;
	private String sub_locality;
	private String sub_thoroughfare;
	private String thoroughfare;
	public String getAdministrative_area() {
		return administrative_area;
	}
	public void setAdministrative_area(String administrativeArea) {
		administrative_area = administrativeArea;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String[] formattedAddress) {
		formatted_address = formattedAddress;
	}
	public String getIso_country_code() {
		return iso_country_code;
	}
	public void setIso_country_code(String isoCountryCode) {
		iso_country_code = isoCountryCode;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postalCode) {
		postal_code = postalCode;
	}
	public String getSub_administrative_area() {
		return sub_administrative_area;
	}
	public void setSub_administrative_area(String subAdministrativeArea) {
		sub_administrative_area = subAdministrativeArea;
	}
	public String getSub_locality() {
		return sub_locality;
	}
	public void setSub_locality(String subLocality) {
		sub_locality = subLocality;
	}
	public String getSub_thoroughfare() {
		return sub_thoroughfare;
	}
	public void setSub_thoroughfare(String subThoroughfare) {
		sub_thoroughfare = subThoroughfare;
	}
	public String getThoroughfare() {
		return thoroughfare;
	}
	public void setThoroughfare(String thoroughfare) {
		this.thoroughfare = thoroughfare;
	}
	@Override
	public String toString() {
		return "Location [administrative_area=" + administrative_area
				+ ", country=" + country + ", formatted_address="
				+ Arrays.toString(formatted_address) + ", iso_country_code="
				+ iso_country_code + ", locality=" + locality + ", name="
				+ name + ", postal_code=" + postal_code
				+ ", sub_administrative_area=" + sub_administrative_area
				+ ", sub_locality=" + sub_locality + ", sub_thoroughfare="
				+ sub_thoroughfare + ", thoroughfare=" + thoroughfare + "]";
	}
	
	

}
