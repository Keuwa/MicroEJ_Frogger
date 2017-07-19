package com.frogger.models;

import java.io.IOException;
import java.util.ArrayList;

import com.frogger.game.Game;

import ej.microui.display.GraphicsContext;

public class Map {
	ArrayList<Lane> lanes;
	public static int nbLanes;
	public static int nbRoad;
	public static int nbWater;
	Frog frog;

	public Map(int _nbRoad,int _nbWater) {
		// TODO Auto-generated constructor stub
		nbRoad = _nbRoad;
		nbWater = _nbWater;
		nbLanes = nbRoad + nbWater + 3;
		lanes = new ArrayList<>();
		try {
			frog = new Frog();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void initMap() {
		int i = 1;
		lanes.clear();
		lanes.add(new SafeLane(i++));
		System.out.println("i: " + i);
		for(int j = 0;j<nbRoad;j++){
			lanes.add(new RoadLane(i++));
		}
		lanes.add(new SafeLane(i++));
		for(int j = 0;j<nbWater;j++){
			lanes.add(new WaterLane(i++));
		}
		lanes.add(new FinishLane(i));
		
		frog.setPosition(Game.Gwidth/2, lanes.get(0).getPosition().getY());
	}
	
	public ArrayList<Lane> getLanes() {
		return lanes;
	}
	
	public boolean moveFrogUp() {
		int move = frog.getPosition().getY()-Game.Gheight/Map.nbLanes;
		if (move > 0) {
			frog.setPosition(frog.getPosition().getX(), move);
			return true;
		}
		return false;
	}
	
	public boolean moveFrogDown() {
		int move = frog.getPosition().getY()+Game.Gheight/Map.nbLanes;
		if (move < Game.Gheight) {
			frog.setPosition(frog.getPosition().getX(), move);
			return true;
		}
		return false;
	}
	
	public boolean moveFrogRight() {
		int move = frog.getPosition().getX()-Game.Gheight/15;
		if (move > 0) {
			frog.setPosition(move, frog.getPosition().getY());
			return true;
		}
		return false;
	}
	
	public boolean moveFrogLeft() {
		int move = frog.getPosition().getX()+Game.Gheight/15;
		if (move < Game.Gwidth) {
			frog.setPosition(move, frog.getPosition().getY());
			return true;
		}
		return false;
	}
	
	public Frog getFrog() {
		return frog;
	}

	public void setFrog(Frog frog) {
		this.frog = frog;
	}

	public void draw(GraphicsContext g) {
		for (Lane lane : lanes) {
			lane.draw(g);
		}
		int currentLane = nbLanes - 1 - (int)((float)frog.getPosition().getY() / (float)Game.Gheight * (float)nbLanes);
		int collision = lanes.get(currentLane).collision(frog);
		switch (collision) {
		case Lane.COLLISION_CAR:
			frog.looseLife();
			frog.setPosition(Game.Gwidth/2, lanes.get(0).getPosition().getY());
			// end game
			break;
		case Lane.COLLISION_WATER:
			// end game
			frog.looseLife();
			frog.setPosition(Game.Gwidth/2, lanes.get(0).getPosition().getY());
			break;
		case Lane.COLLISION_WOOD:
			// end move frog with wood
			if(lanes.get(currentLane).getDirection()){
				if(frog.getPosition().getX()-lanes.get(currentLane).getSpeed()<0-frog.getImg().getWidth()){
					frog.looseLife();
					frog.setPosition(Game.Gwidth/2, Game.Gheight - frog.getImg().getHeight());
				}else{
					frog.setPosition(frog.getPosition().getX()-lanes.get(currentLane).getSpeed(), frog.getPosition().getY());
				}
			}else{
				if(frog.getPosition().getX()-lanes.get(currentLane).getSpeed()>Game.Gwidth){
					frog.looseLife();
					frog.setPosition(Game.Gwidth/2, Game.Gheight - frog.getImg().getHeight());
				}else{
					frog.setPosition(frog.getPosition().getX()+lanes.get(currentLane).getSpeed(), frog.getPosition().getY());
				}
			}
			break;
		case Lane.COLLISION_END:
				frog.isArrived = true;
			// end game with score ++
			break;
		default:
			// nothing
			break;
		}
		frog.draw(g);
	}


}
