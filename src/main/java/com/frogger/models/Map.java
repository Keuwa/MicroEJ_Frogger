package com.frogger.models;

import java.util.ArrayList;

public class Map {
	ArrayList<Lane> lanes;

	public Map() {
		// TODO Auto-generated constructor stub
		lanes = new ArrayList<>();
	}
	
	public void initMap(int nbRoad,int nbWater){
		lanes.clear();
		lanes.add(new SafeLane());
		for(int i = 0;i<nbRoad;i++){
			lanes.add(new RoadLane());
		}
		lanes.add(new SafeLane());
		for(int i = 0;i<nbWater;i++){
			lanes.add(new WaterLane());
		}
		lanes.add(new FinishLane());
	}

}
