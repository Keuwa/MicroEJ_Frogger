package com.frogger.models;

import com.frogger.utils.Position;

public class Frog {
	Position pos;
	int life = 5;
	boolean bonusLife = false;
	public Frog() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Frog(Position pos, int life) {
		super();
		this.pos = pos;
		this.life = life;
	}


	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public boolean isBonusLife() {
		return bonusLife;
	}
	public void setBonusLife(boolean bonusLife) {
		this.bonusLife = bonusLife;
	}
	

}
