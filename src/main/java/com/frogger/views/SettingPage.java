package com.frogger.views;


import com.frogger.Program;
import com.frogger.setting.Setting;

import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;

public class SettingPage extends Page {
	Button back = new Button("Back");
	
	Button removeWater = new Button("-");
	Button removeRoad = new Button("-");
	Button removeCar = new Button("-");
	Button removeLife = new Button("-");
	Button removeWood = new Button("-");

	
	Button addWater = new Button("+");
	Button addRoad = new Button("+");
	Button addCar = new Button("+");
	Button addLife = new Button("+");
	Button addWood = new Button("+");

	Label roadLabel = new Label();
	Label waterLabel = new Label();
	Label carLabel = new Label();
	Label woodLabel = new Label();
	Label lifeLabel = new Label();
	Label road = new Label();
	Label water = new Label();
	Label maxCar = new Label();
	Label maxWood = new Label();
	Label life = new Label();

	List containerRoad;
	List containerWater;
	List containerCar;
	List containerLife;
	List containerWood;
	List container;
	
	Setting setting = Setting.getInstance();

	public SettingPage() {
		
		containerRoad = new List(true);
		containerWater = new List(true);
		containerCar = new List(true);
		containerWood = new List(true);
		containerLife = new List(true);
		container = new List(false);

		lifeLabel = new Label("LIFE     :");
		roadLabel = new Label("ROAD  :"); 
		waterLabel = new Label("RIVER :");
		carLabel = new Label("CARS   :");
		woodLabel = new Label("WOOD  :");
		  
		life = new Label(String.valueOf(setting.getLife()));
		road = new Label(String.valueOf(setting.getNbRoad()));
		water = new Label(String.valueOf(setting.getNbWater()));
		maxCar = new Label(String.valueOf(setting.getMaxCar()));
		maxWood = new Label(String.valueOf(setting.getMaxWood()));

		removeLife.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.removeLife();
				life.setText(String.valueOf(setting.getLife()));
			}
		});
		
		removeCar.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.removeMaxCar();
				maxCar.setText(String.valueOf(setting.getMaxCar()));
			}
		});
		
		removeWood.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.removeMaxWood();
				maxWood.setText(String.valueOf(setting.getMaxWood()));
			}
		});
		
		removeRoad.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.removeRoad();
				road.setText(String.valueOf(setting.getNbRoad()));
			}
		});
		
		removeWater.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.removeWater();
				water.setText(String.valueOf(setting.getNbWater()));
			}
		});
		
		addLife.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.addLife();
				life.setText(String.valueOf(setting.getLife()));
			}
		});
		
		addCar.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.addMaxCar();
				maxCar.setText(String.valueOf(setting.getMaxCar()));
			}
		});
		
		addWood.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.addMaxWood();
				maxWood.setText(String.valueOf(setting.getMaxWood()));
			}
		});
		
		addRoad.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.addRoad();
				road.setText(String.valueOf(setting.getNbRoad()));
			}
		});
		
		addWater.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				setting.addWater();
				water.setText(String.valueOf(setting.getNbWater()));
			}
		});
				
		back.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Program.back();				
			}
		});
		
		removeLife.addClassSelector("SETTING");
		removeRoad.addClassSelector("SETTING");
		removeWater.addClassSelector("SETTING");
		removeCar.addClassSelector("SETTING");
		removeWood.addClassSelector("SETTING");


		addLife.addClassSelector("SETTING");
		addRoad.addClassSelector("SETTING");
		addWater.addClassSelector("SETTING");
		addCar.addClassSelector("SETTING");
		addWood.addClassSelector("SETTING");

		
		containerLife.add(lifeLabel);
		containerLife.add(removeLife);
		containerLife.add(life);
		containerLife.add(addLife);

		containerRoad.add(roadLabel);
		containerRoad.add(removeRoad);
		containerRoad.add(road);
		containerRoad.add(addRoad);
		
		containerWater.add(waterLabel);
		containerWater.add(removeWater);
		containerWater.add(water);
		containerWater.add(addWater);
		
		containerCar.add(carLabel);
		containerCar.add(removeCar);
		containerCar.add(maxCar);
		containerCar.add(addCar);
		
		containerWood.add(woodLabel);
		containerWood.add(removeWood);
		containerWood.add(maxWood);
		containerWood.add(addWood);

		container.add(containerLife);
		container.add(containerRoad);
		container.add(containerWater);
		container.add(containerCar);
		container.add(containerWood);
		container.add(back);
		

		setWidget(container);	
	}
}
