package com.frogger.utils;

public class Position {
		private int x;
		private int y;
	public Position() {
		this.x = 0;
		this.y = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
