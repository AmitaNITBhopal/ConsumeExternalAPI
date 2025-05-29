package com.MVC.consumeapi.model;

import java.util.Date;

public class WethDate {
	public Date date;
	public Object value;
	
	public WethDate(Date date, Object value) {
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
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "WethDate [date=" + date + ", value=" + value.toString() + "]";
	}

}
