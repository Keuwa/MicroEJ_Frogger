package com.frogger.models;

import com.frogger.game.Game;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public class FinishLane extends Lane {

	public FinishLane(int pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext g) {
		g.setColor(Colors.PURPLE);
		g.fillRect(position.getX(),position.getY(), Game.Gwidth, Game.Gheight/Map.nbLanes);
	}

	@Override
	public int collision(Frog frog) {
		return COLLISION_END;
	}
}
