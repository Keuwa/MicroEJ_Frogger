package com.frogger.views;

import java.util.ArrayList;

import com.frogger.Program;
import com.frogger.score.ScoreList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;

public class ScorePage extends Page{
	private Button back;
	ArrayList<Label> labels = new ArrayList<>();
	private List container;
	ScoreList scoreList = ScoreList.getInstance();

	public ScorePage() {
		container = new List(false);
		back = new Button("Back");
		for(Integer score : scoreList.getScore()){
			Label label = new Label(score.toString());
			labels.add(label); 
		}
		
		System.out.println(scoreList.getScore().toString());
		
		back.addOnClickListener(new OnClickListener() {
					@Override
					public void onClick() {
						Program.back();				
					}
				});

		for(Label label : labels){
			container.add(label); 
		}
		container.add(back);
		setWidget(container);	
		}

}
