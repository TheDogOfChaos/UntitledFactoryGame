package io.thedogofchaos.fmp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Arrays;

public class FMPGame extends Game {
	private TiledMapRenderer renderer;
	private OrthographicCamera camera;
	private BitmapFont font;
	private SpriteBatch batch;
	private TiledMap map;
	private Stage stage;
	
	public FMPGame() {

	}
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 320, 320);
		camera.update();
		font = new BitmapFont();
		batch = new SpriteBatch();

		Skin skin = new Skin(Gdx.files.internal("metal-ui/metal-ui.json"));
		stage = new Stage(new ScreenViewport());
		Table table = new Table();
		table.setDebug(true);
		table.setFillParent(true);
		Gdx.input.setInputProcessor(stage);
		stage.addActor(table);


		map = WorldGenerator.GenerateWorld(64,64, 16,16, 7);
		renderer = new OrthogonalTiledMapRenderer(map);

		TextButton textButton = new TextButton("refresh", skin);
		textButton.add(table);
		textButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				map = WorldGenerator.GenerateWorld(64,64, 16,16, 7);
			}
		});

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
