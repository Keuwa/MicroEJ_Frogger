package com.frogger.models;

import java.io.IOException;

import com.frogger.utils.Position;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class Frog {
	Position position = new Position();
	int life = 5;
	boolean bonusLife = false;
	Image img;
	boolean isArrived;
	
	public Frog() throws IOException {
		// TODO Auto-generated constructor stub
		img = Image.createImage("/images/frog_idle.png");
		isArrived = false;
	}
	
	
	public Frog(int _life,int x,int y) {
		super();
		position.setX(x);
		position.setY(y);
		life = _life;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}


	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}

	public int getLife() {
		return life;
	}
	public void setLife(int _life) {
		life = _life;
	}
	public boolean isBonusLife() {
		return bonusLife;
	}
	public void setBonusLife(boolean bonusLife) {
		this.bonusLife = bonusLife;
	}
	
	public void looseLife() {
		life = life > 1 ? life-1 : 0;
	}
	
	public void draw(GraphicsContext g) {
		g.drawImage(img,position.getX(), position.getY(), GraphicsContext.TOP);
	}


	public boolean isArrived() {
		return isArrived;
	}


	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}
	
	
	

}
