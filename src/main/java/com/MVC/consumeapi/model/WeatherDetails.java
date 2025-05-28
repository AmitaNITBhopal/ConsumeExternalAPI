package com.MVC.consumeapi.model;

import java.util.ArrayList;
import java.util.Date;

public class WeatherDetails {
	public String version;
	public String user;
    public Date dateGenerated;
    public String status;
    public ArrayList<Datum> data;
    
    public WeatherDetails(String version, String user, Date dateGenerated, String status, ArrayList<Datum> data) {
		super();
		this.version = version;
		this.user = user;
		this.dateGenerated = dateGenerated;
		this.status = status;
		this.data = data;
	}
    
	@Override
	public String toString() {
		return "WeatherDetails [version=" + version + ", user=" + user + ", dateGenerated=" + dateGenerated + ", status="
				+ status + ", data=" + data + "]";
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getDateGenerated() {
		return dateGenerated;
	}
	public void setDateGenerated(Date dateGenerated) {
		this.dateGenerated = dateGenerated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
