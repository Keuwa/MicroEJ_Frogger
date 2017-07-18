package com.frogger.game;

import java.util.Random;
import com.frogger.models.Map;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import ej.style.Element;
import ej.style.State;

public class Game extends Widget implements Element {

	public static int MIN_HEIGHT = 100;
	public static int MIN_WIDTH = 100;
	public static int Gheight;
	public static int Gwidth;
	int jumps = 0;
	int score = 0;
	int originY = 0;
	int newY = 0;
	Map map;
	public static Random random = new Random();
	
	public Game(int nbLigneRoad, int nbLigneWater) {
		super();
		
		map = new Map(nbLigneRoad, nbLigneWater);
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
		return map.getFrog().getLife();
	}

	
	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public boolean handleEvent(int event) {
		//System.out.println("event");
		
		if(Event.getType(event) == Event.POINTER){
			Pointer p = (Pointer)EventGenerator.get(Event.getGeneratorID(event));

			if (Pointer.isPressed(event) == true) {
				originY = p.getAbsoluteY();
			}

			
			if(Pointer.isReleased(event) == true) {
				newY = p.getAbsoluteY();
				
				if(originY - newY > 100) {
					map.moveFrogUp();
				} 
				else if (newY - originY > 100) {
					map.moveFrogDown();
				}
			}
		}
		return false;
	}


	@Override
	public void render(GraphicsContext g) {
		if (getLife() <= 0) {
			// FIN DU GAME
		} 
		else {
			map.draw(g);
		}
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
		map.initMap();
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
