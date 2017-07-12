package com.frogger;

import java.io.IOException;

import com.frogger.views.MenuPage;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.style.State;
import ej.style.Stylesheet;
import ej.style.background.NoBackground;
import ej.style.background.SimpleImageBackground;
import ej.style.outline.ComplexOutline;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.StateSelector;
import ej.style.selector.TypeSelector;
import ej.style.selector.combinator.AndCombinator;
import ej.style.selector.combinator.ChildCombinator;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.navigation.navigator.HistorizedNavigator;
import ej.widget.navigation.page.Page;

public class Program implements Activity {
	
	private static HistorizedNavigator navigator;

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		MicroUI.start();
		navigator = new HistorizedNavigator();
		navigator.show(new MenuPage());
				
		Desktop desktop = new Desktop();

		Panel panel = new Panel();
		panel.setWidget(navigator);
		panel.show(desktop,true);
		try{
			InitializeStyle(desktop);
		}catch(IOException e){
			e.printStackTrace();
		}
		desktop.show();
		
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}
	
	public static void show(Page page){
		navigator.show(page);
	}
	public static void back(){
		navigator.back();
	}
	
	private static void InitializeStyle(Desktop desktop) throws IOException {
		Stylesheet sts = StyleHelper.getStylesheet();
		EditableStyle btnStyle = new EditableStyle();
		EditableStyle clickedStyle = new EditableStyle();
		EditableStyle lblClickedStyle = new EditableStyle();
		EditableStyle transpStyle = new EditableStyle();
		EditableStyle nobodyStyle = new EditableStyle();
		EditableStyle someoneStyle = new EditableStyle();
		
		TypeSelector btnSelector = new TypeSelector(Button.class);
		TypeSelector lblSelector = new TypeSelector(Label.class);
		ClassSelector nobodySelector = new ClassSelector("NOBODY");
		ClassSelector someoneSelector = new ClassSelector("SOMEONE");
		ChildCombinator parentBtnSelector = new ChildCombinator(btnSelector, lblSelector);
		AndCombinator parentBtnClickedSelector =  new AndCombinator(parentBtnSelector, new StateSelector(State.Active));
		AndCombinator clickedSelector = new AndCombinator(btnSelector, new StateSelector(State.Active));
		
		SimpleImageBackground btnImgBkg = new SimpleImageBackground
				(Image.createImage("/images/button.png"), GraphicsContext.HCENTER | GraphicsContext.VCENTER, true);
		SimpleOutline btnPadding = new SimpleOutline(12);
		
		SimpleImageBackground clickedImgBkg = new SimpleImageBackground
				(Image.createImage("/images/button_clicked.png"), GraphicsContext.HCENTER | GraphicsContext.VCENTER, true);
		ComplexOutline clickedPadding = new ComplexOutline(17, 12, 12, 12);
		
		nobodyStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		nobodyStyle.setPadding(btnPadding);
		nobodyStyle.setBackgroundColor(Colors.RED);
		
		someoneStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		someoneStyle.setPadding(btnPadding);
		someoneStyle.setBackgroundColor(Colors.GREEN);
		
		btnStyle.setBackground(btnImgBkg);
		btnStyle.setPadding(btnPadding);
		btnStyle.setForegroundColor(Colors.BLACK);
		btnStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		clickedStyle.setBackground(clickedImgBkg);
		clickedStyle.setForegroundColor(Colors.YELLOW);
		clickedStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		lblClickedStyle.setPadding(clickedPadding);
		
		transpStyle.setBackground(NoBackground.NO_BACKGROUND);
		
		sts.addRule(btnSelector, btnStyle);
		sts.addRule(clickedSelector, clickedStyle);
		sts.addRule(parentBtnSelector, transpStyle);
		sts.addRule(parentBtnClickedSelector, lblClickedStyle);
		sts.addRule(someoneSelector, someoneStyle);
		sts.addRule(nobodySelector, nobodyStyle);
	}


}
