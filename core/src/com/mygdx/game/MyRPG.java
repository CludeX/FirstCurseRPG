package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.AssetMGMT.AssetCenter;
import com.mygdx.game.screens.GameScreen;

/* First Curse */


public class MyRPG extends Game {
	
	@Override
	public void create() {
		
		AssetCenter.init();
		
		
		
		setScreen(new GameScreen());
		
	}
	
	
	
}