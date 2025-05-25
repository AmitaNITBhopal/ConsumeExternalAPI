package com.MVC.consumeapi.model;

import java.util.ArrayList;

public class Datum {

	public String parameter;
	public ArrayList<Coordinate> coordinates;
	
    public Datum(String parameter, ArrayList<Coordinate> coordinates) {
		super();
		this.parameter = parameter;
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString() {
		return "Datum [parameter=" + parameter + ", coordinates=" + coordinates + "]";
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public ArrayList<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}
}
