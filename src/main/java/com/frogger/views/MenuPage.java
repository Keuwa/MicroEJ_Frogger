package com.frogger.views;

import com.frogger.Program;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;

public class MenuPage extends Page{
	private Button button;
	private Button exitButton;
	private Button settingsButton;
	private Button scoreButton;
	private List container;
	
	public MenuPage() {
		container = new List(false);
		
		button = new Button("Game");
		button.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.show(new GamePage());
				System.out.println("clicked");
			}
		});
	
		scoreButton = new Button("Score");
		scoreButton.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.show(new GamePage());
				System.out.println("clicked");
			}
		});
		
		settingsButton = new Button("Settings");
		settingsButton.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.show(new GamePage());
				System.out.println("clicked");
			}
		});
		
		
		exitButton = new Button("Exit");
		exitButton.addOnClickListener(new OnClickListener() {
			@Override
			  public void onClick()
			  {
			    //use the ExitHandler to stop application
				System.out.println("Exit"); 
				ExitHandler exitHandler = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if (exitHandler != null)
				{
				  exitHandler.exit();
				}
			  }
		});

		container.add(button);
		container.add(scoreButton);
		container.add(settingsButton);
		container.add(exitButton);

		//setWidget(button);
		setWidget(container);	}

}