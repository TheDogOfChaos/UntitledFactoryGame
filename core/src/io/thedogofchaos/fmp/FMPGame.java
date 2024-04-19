package io.thedogofchaos.fmp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import io.thedogofchaos.fmp.screen.MainMenu;

public class FMPGame extends Game {
	public static SpriteBatch spriteBatch;
	public static BitmapFont bitmapFont;
	public static OrthographicCamera gameCamera;
	public static Stage actorStage;
	public static Table uiTable;

	public FMPGame() {
		System.out.println("[INFO] Game Loading...");
	}

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		bitmapFont.dispose();
	}
}
