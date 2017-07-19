package com.frogger.models;

import java.util.ArrayList;

import com.frogger.game.Game;
import com.frogger.setting.Setting;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public class WaterLane extends Lane{

	private ArrayList<Wood> woods = new ArrayList<>();
	
	public WaterLane(int pos) {
		super(pos);
		direction = (pos%2 == 0)?true:false; 
		initWoods();
		speed = Game.random.nextInt(2) + 1;

		// TODO Auto-generated constructor stub
	}
	
	private void initWoods() {
		int startX = Game.random.nextInt(Game.Gwidth);
		int nbWood = Setting.getInstance().getMaxWood();
		for(int i = 1 ; i < nbWood; i ++) {
			Wood wood = new Wood(direction);
			int newSpace = Game.random.nextInt(35) + wood.getImage().getWidth();
			wood.setPosition(startX - wood.getImage().getWidth() + (wood.getImage().getWidth() * i) + (newSpace * i), position.getY());
			woods.add(wood);
		}
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Wood> getWoods() {
		return woods;
	}
	
	public void setWoods(ArrayList<Wood> woods) {
		this.woods = woods;
	}

	@Override
	public void draw(GraphicsContext g) {
		g.setColor(Colors.NAVY);
		g.drawRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
		g.setColor(Colors.BLUE);
		g.fillRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
		for(Wood wood: woods) {
			wood.move(speed);
			wood.draw(g);
		}
	}

	@Override
	public int collision(Frog frog) {
		// TODO Auto-generated method stub
		for(Wood wood: woods) {
			int minFX = frog.getPosition().getX();
			int maxFX = minFX + frog.getImg().getWidth();
			int minCX = wood.getPosition().getX();
			int maxCX = minCX + wood.getImage().getWidth();
			if(minFX >= minCX && minFX <= maxCX || maxFX >= minCX && maxFX <= maxCX) {
				return COLLISION_WOOD;
			}
		}
		return COLLISION_WATER;
	}
}
