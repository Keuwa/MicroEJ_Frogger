package com.frogger;

import ej.style.font.FontProfile;
import ej.style.font.loader.AbstractFontLoader;

public class FroggerFontLoader extends AbstractFontLoader {

	private static final int LARGE_HEIGHT = 50;
	private static final int MEDIUM_HEIGHT = 30;
	
	@Override
	protected int getFontHeight(FontProfile fontProfile) {
		switch (fontProfile.getSize()) {
		case LENGTH:
			return fontProfile.getSizeValue();
		case LARGE:
			return LARGE_HEIGHT;
		case MEDIUM:
			return MEDIUM_HEIGHT;
		default:
			return MEDIUM_HEIGHT;
		}
	}

}
