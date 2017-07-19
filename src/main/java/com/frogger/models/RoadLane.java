package com.frogger.models;

import java.util.ArrayList;

import com.frogger.game.Game;
import com.frogger.setting.Setting;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public class RoadLane extends Lane{

	private ArrayList <Car> cars = new ArrayList<>();
	private boolean createCar = true;
	public RoadLane(int pos) {
		super(pos);
		initCars();
		speed = Game.random.nextInt(2) + 1;
		
		// TODO Auto-generated constructor stub
	}
	
	private void initCars() {
		int startX = Game.random.nextInt(Game.Gwidth);
		int nbCar = Setting.getInstance().getMaxCar();
		for(int i = 1 ; i < nbCar+1 ; i ++) {
			Car car = new Car();
			int newSpace = Game.random.nextInt(35) + car.getImage().getWidth() + 10;
			car.setPosition(startX - car.getImage().getWidth() + (car.getImage().getWidth() * i) + (newSpace * i), position.getY());
			cars.add(car);
		}
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public boolean isCreateCar() {
		return createCar;
	}
	public void setCreateCar(boolean createCar) {
		this.createCar = createCar;
	}
	
	@Override
	public void draw(GraphicsContext g) {
		// TODO Auto-generated method stub
		g.setColor(Colors.BLACK);
		g.drawRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
		g.setColor(Colors.GRAY);
		g.fillRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
		for(Car car: cars) {
			car.move(speed);
			car.draw(g);
		}
	}

	@Override
	public int collision(Frog frog) {
		for(Car car: cars) {
			int minFX = frog.getPosition().getX();
			int maxFX = minFX + frog.getImg().getWidth();
			int minCX = car.getPosition().getX();
			int maxCX = minCX + car.getImage().getWidth();
			
			if(minFX >= minCX && minFX <= maxCX || maxFX >= minCX && maxFX <= maxCX) {
				return COLLISION_CAR;
			}
		}
		return COLLISION_NOTHING;
	}
	
}
