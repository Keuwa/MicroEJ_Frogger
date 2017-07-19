package com.frogger.setting;

public class Setting {
	public static Setting instance = new Setting();
	
	public static Setting getInstance() {
		return instance;
	}
	
	int nbRoad = 6;
	int nbWater = 4;
	int maxCar = 4;
	int maxWood = 3;
	int life = 5;
	
	private Setting() {
		// TODO Auto-generated constructor stub
	}
	
	public void addRoad(){
		nbRoad = nbRoad < 9 ? nbRoad+1 : 10;
	}
	
	public void removeRoad(){
		nbRoad = nbRoad > 2 ? nbRoad-1 : 1;
	}

	public void addWater(){
		nbWater = nbWater < 9 ? nbWater+1 : 10;
	}
	
	public void removeWater(){
		nbWater = nbWater > 2 ? nbWater-1 : 1;
	}
	
	public void addMaxCar(){
		maxCar = maxCar < 9 ? maxCar+1 : 10;
	}
	
	public void removeMaxCar(){
		maxCar = maxCar > 2 ? maxCar-1 : 1; 
	}
	
	public void addMaxWood(){
		maxWood = maxWood < 9 ? maxWood+1 : 10;
	}
	
	public void removeMaxWood(){
		maxWood = maxWood > 2 ? maxWood-1 : 1; 
	}
	
	public void addLife(){
		life = life < 9 ? life+1 : 10;
	}
	
	public void removeLife(){
		life = life > 2 ? life-1 : 1; 
	}
	
	public int getNbRoad() {
		return nbRoad;
	}
	
	public int getNbWater() {
		return nbWater;
	}
	
	public int getMaxCar() {
		return maxCar;
	}
	
	public int getMaxWood() {
		return maxWood;
	}
	
	public int getLife() {
		return life;
	}
}
