package com.MVC.consumeapi.model;

import java.util.ArrayList;

public class LatLongList {
	private ArrayList<LatLong> list;

	public LatLongList(ArrayList<LatLong> list) {
		super();
		this.list = list;
	}

	public ArrayList<LatLong> getList() {
		return list;
	}

	public void setList(ArrayList<LatLong> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "LatLongList [list=" + list + "]";
	}
}
