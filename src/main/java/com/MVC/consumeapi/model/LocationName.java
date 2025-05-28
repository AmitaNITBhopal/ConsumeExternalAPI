package com.MVC.consumeapi.model;

public class LocationName {
	private String City;
	
	public LocationName(String city, String country) {
		super();
		City = city;
		Country = country;
	}
	public LocationName() {
		// TODO Auto-generated constructor stub
	}
	private String Country;
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	@Override
	public String toString() {
		return "LocationName [City=" + City + ", Country=" + Country + ", getCity()=" + getCity() + ", getCountry()="
				+ getCountry() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
