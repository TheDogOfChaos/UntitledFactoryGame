package io.thedogofchaos.fmp;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import static java.lang.System.out;

public class FMPGame extends Game {
	private TiledMapRenderer renderer;
	private OrthographicCamera camera;
	private BitmapFont font;
	private SpriteBatch batch;
	private TiledMap map;
	private Stage stage;

	public static InputMultiplexer inputMultiplexer = new InputMultiplexer();
	
	public FMPGame() {

	}
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 1024, 1024);
		camera.update();
		font = new BitmapFont();
		batch = new SpriteBatch();
		stage = new Stage(new ScreenViewport());
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
		map = WorldGenerator.GenerateWorld(128,128, 16,16, 5, 1, genType);
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	@Override
	public void render () {

		ScreenUtils.clear(100f / 255f, 100f / 255f, 250f / 255f, 1f);
		camera.update();
		renderer.setView(camera);
		renderer.render();
		stage.act();
		stage.draw();
		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
