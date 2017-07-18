package com.frogger.models;

import java.io.IOException;

import com.frogger.game.Game;
import com.frogger.utils.Position;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class Wood {
	Position position = new Position();
	Image img;
	boolean direction;
	private int size;
	public Wood(boolean direction) {
		// TODO Auto-generated constructor stub
		this.direction = direction;
		try {
			img = Image.createImage("/images/wood.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Position getPosition() {
		return position;
	}
	public void setPosition(int x,int y) {
		position.setX(x);
		position.setY(y);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int _size) {
		this.size = _size;
	}
	
	public void move(int x){
		int newX;
		if(direction){
			newX = this.position.getX()-x;
			//System.out.println("newX: " + newX);
			if (newX < 0-img.getWidth()) {
				newX = Game.Gwidth;
			}
		}else{
			newX = this.position.getX()+x;
			//System.out.println("newX: " + newX);
			if (newX > Game.Gwidth) {
				newX = 0 - img.getWidth();
			}
		}
		this.position.setX(newX);	}

	public Image getImage() {
		return img;
	}

	public void setImage(Image img) {
		this.img = img;
	}
	public void draw(GraphicsContext g) {
		g.drawImage(img, position.getX(), position.getY(), GraphicsContext.TOP);
		// TODO Auto-generated method stub
		
	}
}
