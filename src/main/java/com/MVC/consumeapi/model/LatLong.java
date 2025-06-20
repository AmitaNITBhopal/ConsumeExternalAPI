package com.MVC.consumeapi.model;

public class LatLong {
	private String name;
	private Double latitude;
    private Double longitude;
    private String country;
    private String state;
    
    public LatLong(String name, Double latitude, Double longitude, String country, String state) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.state = state;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "LatLong [name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", country=" + country + ", state=" + state
				+ "]";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
