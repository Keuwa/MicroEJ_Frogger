package com.frogger.models;

import com.frogger.utils.Position;

public class Car {
	Position pos;
	int size;
	
	public Car() {
		// TODO Auto-generated constructor stub
		
	}
		
	public Car(Position pos, int size) {
		super();
		this.pos = pos;
		this.size = size;
	}

	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void move(int x){
		this.pos.setX(this.pos.getX()+x); 
	}

}
