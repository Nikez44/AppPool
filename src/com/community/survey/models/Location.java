package com.community.survey.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Location {

	public static final String ID = "Id";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	public static final String ADDRESS = "Address";

	// aun falta terminar con la geo de google
	public Location(double latitude, double longitude, String address) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}
	public Location(){
		
	}
	
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getAddress() {
		return address;
	}

	@DatabaseField(columnName = ID, generatedId = true)
	@SerializedName(ID)
	private int id;
	@DatabaseField(columnName = LATITUDE)
	@SerializedName(LATITUDE)
	private double latitude;
	@DatabaseField(columnName = LONGITUDE)
	@SerializedName(LONGITUDE)
	private double longitude;
	@DatabaseField(columnName = ADDRESS)
	@SerializedName(ADDRESS)
	private String address;

}
