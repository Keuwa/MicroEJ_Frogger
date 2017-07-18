package com.frogger.models;

import com.frogger.game.Game;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public class SafeLane extends Lane {

	public SafeLane(int pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext g) {
		// TODO Auto-generated method stub
		g.setColor(Colors.GREEN);
		g.fillRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
	}

	@Override
	public int collision(Frog frog) {
		// TODO Auto-generated method stub
		return COLLISION_NOTHING;
	}
}
