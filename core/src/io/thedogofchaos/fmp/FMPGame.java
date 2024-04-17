package io.thedogofchaos.fmp;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.thedogofchaos.fmp.world.WorldGenerator;

import static java.lang.System.out;

public class FMPGame extends Game {
	private TiledMapRenderer mapRenderer;
	private TextureAtlas atlas;
	private BitmapFont font;
	private SpriteBatch batch;
	private Stage stage;
	public static InputMultiplexer inputMultiplexer = new InputMultiplexer();
	public FMPGame() {

	}
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		OrthographicCamera camera = new FitViewport();
		camera.update();
		font = new BitmapFont();
		batch = new SpriteBatch();
		stage = new Stage(new ScreenViewport());
		atlas = new TextureAtlas(Gdx.files.internal("sprites/atlas/tileAtlas.atlas"));
		Table table = new Table();
		table.setDebug(false);
		table.setFillParent(true);
		stage.addActor(table);

		inputMultiplexer.addProcessor(stage);
		inputMultiplexer.addProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keycode) {
				if (keycode == Input.Keys.SPACE) {
					String[] noiseType = {"perlin", "smooth", "turbulence"};
					int i = (int) Math.round(Math.random()*2);
					LoadNewMap(noiseType[i]);
					out.println("space pressed, generating new map with type " + noiseType[i]);
				}
				return true;
			}
		});
		Gdx.input.setInputProcessor(inputMultiplexer);
		LoadNewMap("perlin");
	}

	private void LoadNewMap(String genType) {
		out.println(genType);
		WorldGenerator.GenerateWorld(64,64,1, genType);
	}
	@Override
	public void render() {
		ScreenUtils.clear(0,0,0, 1f);
		camera.update();
		stage.act();
		stage.draw();
		batch.begin();
		for (int x = 0; x < Vars.mapWidth; x++) {
			for (int y = 0; y < Vars.mapHeight; y++) {
				if (Vars.mapData[0][x][y] == "stoneFloor") {
					batch.draw(atlas.findRegion("stoneFloor"), x * 16, y * 16);
				}
				if (Vars.mapData[1][x][y] == "stoneWall") {
					batch.draw(atlas.findRegion("stoneWall"), x * 16, y * 16);
				}
				if (Vars.mapData[1][x][y] == "darkStoneWall") {
					batch.draw(atlas.findRegion("darkStoneWall"), x * 16, y * 16);
				}
				if (Vars.mapData[1][x][y] == "air") {
					batch.draw(atlas.findRegion("air"), x * 16, y * 16);
				}
			}


		}
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
