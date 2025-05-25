package com.MVC.consumeapi.model;

import java.util.Date;

public class WethDate {
	public Date date;
	public double value;
	
	public WethDate(Date date, double value) {
		super();
		this.date = date;
		this.value = value;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "WethDate [date=" + date + ", value=" + value + "]";
	}

}
