package com.frogger.models;

public class Lane {
		private boolean direction;
		private double speed = 1;
	public Lane() {
		// TODO Auto-generated constructor stub
	}
	
	public Lane(boolean direction, double speed) {
		super();
		this.direction = direction;
		this.speed = speed;
	}

	public boolean isDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
