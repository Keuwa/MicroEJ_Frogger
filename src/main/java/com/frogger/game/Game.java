package com.frogger.game;

import java.util.ArrayList;
import java.util.Random;

import com.frogger.models.Lane;
import com.frogger.models.Map;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Buttons;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import ej.style.Element;
import ej.style.State;

public class Game extends Widget implements Element {

	static int MIN_HEIGHT = 100;
	static int MIN_WIDTH = 100;
	int Gheight;
	int Gwidth;
	int jumps = 0;
	int score = 0;
	int life = 3;
	Map map;
	Random random;
	
	public Game(int nbLigneRoad, int nbLigneWater) {
		super();
		random = new Random();
		//int nbRoad = random.nextInt(nbLigne/2)+1;
		map = new Map();
		map.initMap(nbLigneRoad, nbLigneWater);
		System.out.println("mochi");
	}


	public int getJumps() {
		return jumps;
	}



	public void setJumps(int jumps) {
		this.jumps = jumps;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getLife() {
		return life;
	}



	public void setLife(int life) {
		this.life = life;
	}



	public Map getMap() {
		return map;
	}



	public void setMap(Map map) {
		this.map = map;
	}



	public Random getRandom() {
		return random;
	}



	public void setRandom(Random random) {
		this.random = random;
	}



	@Override
	public boolean handleEvent(int event) {
		System.out.println("mi");

		// TODO Auto-generated method stub
		System.out.print("yoloo");
		if(Event.getType(event) == Event.POINTER){
			Pointer p = (Pointer)EventGenerator.get(Event.getGeneratorID(event));
			if(Buttons.getAction(event) == Pointer.DRAGGED){
				System.out.print("dragged");
			}
		}
		return false;
	}

	@Override
	public void render(GraphicsContext g) {
		//GetRelative pour avoir la position par raport a la ou est le widget
		ArrayList<Lane> lanes =  map.getLanes();
		int i = 1;
		for (Lane lane : lanes) {
			String className = lane.getClass().getSimpleName();
			System.out.print(className);
			if(className.equals("RoadLane")) {
				g.setColor(Colors.GRAY);
			}
			else if(className.equals("SafeLane")) {
				g.setColor(Colors.GREEN);
			}
			else if(className.equals("WaterLane")) {
				g.setColor(Colors.BLUE);
			}
			else if(className.equals("FinishLane")) {
				g.setColor(Colors.MAGENTA);
			}
			g.fillRect(0, Gheight - Gheight/lanes.size()*i , Gwidth, Gheight/lanes.size());
			i++;
		}
		//g.setBackgroundColor(Colors.BLUE);
		//g.setColor(Colors.NAVY);
		//g.fillRect(0, 0, Gwidth, Gheight);
		System.out.print("render");

	}

	public void drawLine(String type){
		
	}
	
	public void drawCar(){
		
	}
	
	public void drawWood(){
		
	}
	
	public void drawFrog(){
		
	}
	
	@Override
	public void validate(int widthHint, int heightHint) {
		// TODO Auto-generated method stub
		setPreferredSize(MIN_WIDTH,MIN_HEIGHT);
		
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		Gwidth = width;
		Gheight = height;
	}
	
	
	
	@Override
	public boolean hasClassSelector(String classSelector) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInState(State state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAttribute(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getParentElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element[] getChildrenElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getChild(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildrenCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void run() {
		// TODO Auto-generated method stub
	}


}
