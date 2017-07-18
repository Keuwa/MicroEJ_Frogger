package com.frogger.models;

import com.frogger.game.Game;
import com.frogger.utils.Position;

import ej.microui.display.GraphicsContext;

public abstract class Lane {
		protected boolean direction = true;
		public static final int COLLISION_NOTHING = 0;
		public static final int COLLISION_CAR = 1;
		public static final int COLLISION_WOOD = 2;
		public static final int COLLISION_WATER = 3;
		public static final int COLLISION_END = 4;

		protected int speed = 1;
		Position position = new Position();
		
	public Lane(int pos) {
		position.setX(0);
		position.setY(Game.Gheight - Game.Gheight/Map.nbLanes*pos);
	}
	
	public Lane(int pos, boolean direction, int speed) {
		this(pos);
		this.direction = direction;
		this.speed = speed;
	}


	public boolean getDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public abstract void draw(GraphicsContext g);

	/*
	 * return collision action
	 */
	public abstract int collision(Frog frog);
	
}
