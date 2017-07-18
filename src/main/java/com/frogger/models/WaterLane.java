package com.frogger.models;

import java.util.ArrayList;

import com.frogger.game.Game;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public class WaterLane extends Lane{

	private ArrayList<Wood> woods;
	
	public WaterLane(int pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Wood> getWoods() {
		return woods;
	}
	
	public void setWoods(ArrayList<Wood> woods) {
		this.woods = woods;
	}

	@Override
	public void draw(GraphicsContext g) {
		g.setColor(Colors.BLUE);
		g.fillRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
	}

	@Override
	public int collision(Frog frog) {
		// TODO Auto-generated method stub
		return COLLISION_WATER;
	}
}
