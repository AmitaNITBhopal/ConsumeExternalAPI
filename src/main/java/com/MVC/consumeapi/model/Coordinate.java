package com.MVC.consumeapi.model;

import java.util.ArrayList;

public class Coordinate {
	public double lat;
    public double lon;
    public ArrayList<WethDate> dates;
    
    
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public ArrayList<WethDate> getDates() {
		return dates;
	}
	public void setDates(ArrayList<WethDate> dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "Coordinate [lat=" + lat + ", lon=" + lon + ", dates=" + dates + "]";
	}
    
    

}
