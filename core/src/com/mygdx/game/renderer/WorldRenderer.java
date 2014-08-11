package com.mygdx.game.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Unit;
import com.mygdx.game.entities.World;

public class WorldRenderer {

	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	
	private World world;
	private OrthographicCamera cam;

	private OrthogonalTiledMapRenderer maprenderer;
	
	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures 
	private TextureRegion bobIdleLeft;
	private TextureRegion bobIdleRight;
	private TextureRegion blockTexture;
	private TextureRegion bobFrame;
	
	 Animations 
	private Animation walkLeftAnimation;
	private Animation walkRightAnimation;
	**/
	
	
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}
	
	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
				
		cam.setToOrtho(false, 30, 20);
		
		
		
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);	
		this.cam.zoom = 0.5f;
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		loadTextures();
		
		maprenderer = new OrthogonalTiledMapRenderer(world.getMap(), 1 / 16f);
			}
	
	
	private void loadTextures() {
		
	}
	
	
	public void render() {  
		
		
		
		maprenderer.setView(cam);
		maprenderer.render();
		
		spriteBatch.begin();
			//drawTiles();
			drawUnits();
		spriteBatch.end();
		if (debug)
			drawDebug();
	}


	private void drawTiles() {
		
		
		
		/*for (Block block : world.getBlocks()) {
			spriteBatch.draw(blockTexture, block.getPosition().x * ppuX, block.getPosition().y * ppuY, Block.SIZE * ppuX, Block.SIZE * ppuY);
		}*/
	}

	private void drawUnits() {
		for(Unit unit: world.getUnits())
		{
			
			
			
			spriteBatch.draw(unit.getFrame(),unit.getPosition().x, unit.getPosition().y , unit.getDimensions().x / this.cam.zoom, unit.getDimensions().y / this.cam.zoom );
		
		
			//spriteBatch.draw(unit.getFrame(),25,25,25,25); ///testing
		}
		
		
		/*if(bob.getState().equals(State.WALKING)) {
			bobFrame = bob.isFacingLeft() ? walkLeftAnimation.getKeyFrame(bob.getStateTime(), true) : walkRightAnimation.getKeyFrame(bob.getStateTime(), true);
		}
		spriteBatch.draw(bobFrame, bob.getPosition().x * ppuX, bob.getPosition().y * ppuY, Bob.SIZE * ppuX, Bob.SIZE * ppuY);
	*/
	
	}

	private void drawDebug() {
		// render blocks
		/*debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);
		for (Block block : world.getBlocks()) {
			Rectangle rect = block.getBounds();
			float x1 = block.getPosition().x + rect.x;
			float y1 = block.getPosition().y + rect.y;
			debugRenderer.setColor(new Color(1, 0, 0, 1));
			debugRenderer.rect(x1, y1, rect.width, rect.height);
		}
		// render Bob
		Bob bob = world.getBob();
		Rectangle rect = bob.getBounds();
		float x1 = bob.getPosition().x + rect.x;
		float y1 = bob.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();*/
	}
}