package com.frogger.models;

import java.io.IOException;

import com.frogger.game.Game;
import com.frogger.utils.Position;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class Car {
	Position position = new Position();
	int size;
	Image img;
	
	public Car() {
		// TODO Auto-generated constructor stub
		try {
			img = Image.createImage("/images/car.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public Car(Position pos, int size) {
		super();
		this.position = pos;
		this.size = size;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Image getImage() {
		return img;
	}
	
	public void move(int x){
		int newX = this.position.getX()-x;
		//System.out.println("newX: " + newX);
		if (newX < 0-img.getWidth()) {
			newX = Game.Gwidth;
		}
		this.position.setX(newX);
	}

	public void draw(GraphicsContext g) {
		g.drawImage(img, position.getX(), position.getY(), GraphicsContext.TOP);
		// TODO Auto-generated method stub
		
	}

}
