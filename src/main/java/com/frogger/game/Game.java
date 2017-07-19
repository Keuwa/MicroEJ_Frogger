package com.frogger.game;

import java.util.Random;
import com.frogger.models.Map;
import com.frogger.score.ScoreList;

import ej.microui.display.Colors;
import ej.microui.display.Font;
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
	boolean finalScore = false;
	int jumps = 0;
	int score = 0;
	int originY = 0;
	int newY = 0;
	int originX = 0;
	int newX = 0;
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
				originX = p.getAbsoluteX();
			}

			
			if(Pointer.isReleased(event) == true) {
				newY = p.getAbsoluteY();
				newX = p.getAbsoluteX();
				
				if(originY - newY > 100) {
					boolean move = map.moveFrogUp();
					if (move == true) {
						score+=10;
					}
				} 
				else if (newY - originY > 100) {
					boolean move = map.moveFrogDown();
					if (move == true) {
						score-=10;
					}
				}
				else if(originX - newX > 50){
					map.moveFrogRight();
				}
				else if (newX - originX > 50) {
					map.moveFrogLeft();
				}
			}
		}
		return false;
	}


	@Override
	public void render(GraphicsContext g) {
		if (getLife() <= 0) {
			// LOOSE
			renderLoose(g);			
		}else if(map.getFrog().isArrived()){
			renderWin(g);
		}
		else {
			map.draw(g);
		}
	}
	
	private void renderWin(GraphicsContext g) {
		if(!finalScore) {
			score *= (map.getFrog().getLife() * 5);
			ScoreList scoreList = ScoreList.getInstance();
			scoreList.addScore(score);
			finalScore = true;
		}
		
		g.fillRect(0, 0, Game.Gwidth,  Game.Gheight);

		// use White color to render text
		g.setColor(Colors.WHITE);
		final Font sourceSansPro = Font.getFont(Font.LATIN, 24, Font.STYLE_PLAIN);		
		g.setFont(sourceSansPro);

		g.drawString("You win ! Your score is : " + score, Game.Gwidth / 2, Game.Gheight / 2,
				GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
	}


	private void renderLoose(GraphicsContext g) {
		if(!finalScore) {
			ScoreList scoreList = ScoreList.getInstance();
			scoreList.addScore(score);
			finalScore = true;
		}
		
		g.fillRect(0, 0, Game.Gwidth,  Game.Gheight);

		// use White color to render text
		g.setColor(Colors.WHITE);
		final Font sourceSansPro = Font.getFont(Font.LATIN, 24, Font.STYLE_PLAIN);		
		g.setFont(sourceSansPro);

		g.drawString("You lose !", Game.Gwidth / 2, Game.Gheight / 2,
				GraphicsContext.HCENTER | GraphicsContext.VCENTER);
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
