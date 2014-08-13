package com.mygdx.game.AssetMGMT;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public enum UtilitySprites {

	SELECTIONSQUARE("selection", SpriteSheet.UIPACKRPG,"arrowSilver_right.png");
	
	UtilitySprites(String name,SpriteSheet sheet, int index)
	{
		this.name=name;
		this.sheet=sheet;
		this.index=index;
		
		texRegion = new TextureRegion(sheet.getTexture(),getX(),getY(),getSheet().tilesize,getSheet().tilesize);
		
	}	
	
	UtilitySprites(String name,SpriteSheet sheet, String elementId)
	{
		this.name=name;
		this.sheet=sheet;
		
		Rectangle rect = sheet.getElementRectFromXML(elementId);
		texRegion = new TextureRegion(sheet.getTexture(),(int) rect.x, (int) rect.y, (int) rect.width,(int) rect.height);
		
		
	}	
	
	
	public String name = "";
	
	public  SpriteSheet sheet = SpriteSheet.BASICSHEET;
	
	public  int index = 200;
	
	
	
	public SpriteSheet getSheet() {
		
		return sheet;
	}

	public int getX() {
		
		return (index % sheet.tilesPerRow) * sheet.tilesize;
	}
	
	public int getY() {
		
		return (index / sheet.tilesPerRow) * sheet.tilesize ;
	}

	TextureRegion texRegion = null;
	
	public TextureRegion getTextureRegion() {
		
		return texRegion;
	}
}
