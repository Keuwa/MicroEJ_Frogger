package com.frogger.score;

import java.util.ArrayList;

public class ScoreList {
	
	public static ScoreList instance = new ScoreList();
	
	public static ScoreList getInstance() {
		return instance;
	}
	
	ArrayList<Integer>score = new ArrayList<>();
	
	private ScoreList() {
		// TODO Auto-generated constructor stub
		this.addScore(1);
		this.addScore(2);
	}
	
	public void addScore(int _score){
		Integer s = new Integer(_score);
		score.add(s);
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}
	

}
