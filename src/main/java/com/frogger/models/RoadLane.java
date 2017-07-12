package com.frogger.models;

import java.util.ArrayList;

public class RoadLane extends Lane{

	private ArrayList <Car> cars;
	private boolean createCar = true;
	public RoadLane() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public boolean isCreateCar() {
		return createCar;
	}
	public void setCreateCar(boolean createCar) {
		this.createCar = createCar;
	}
	
}
