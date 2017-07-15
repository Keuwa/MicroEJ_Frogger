package com.frogger.views;

import com.frogger.Program;
import com.frogger.game.Game;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;

public class GamePage extends Page{
	
	// container
	Split splitGame;
	List list;

	// widget
	Label score;
	Label life;
	Button back;
	Game game;
	
	// timer
	Timer timer;
	
	//attribut
	Boolean live = false;
	
	public GamePage() {
		
		// init params
		splitGame = new Split(true,0.75f);
		list = new List(false);
		game = new Game(6, 4);
		score = new Label("");
		life = new Label("");
		back = new Button("Back");
		timer = new Timer();
		live = true;
		
		// implement event
		back.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				live = false;
				Program.back();				
			}
		});
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				if (live == true) {
					try {
						game.run();
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					score.setText("Score: " + String.valueOf(game.getScore())); 
					life.setText("Life: " + String.valueOf(game.getLife()));
					repaint();	
				}
			}
			
		}, 0, 50);
		
		// set container
		list.add(life);
		list.add(score);
		list.add(back);
		splitGame.setFirst(game);
		splitGame.setLast(list);
		//set widget
		this.setWidget(splitGame);

	}
}
