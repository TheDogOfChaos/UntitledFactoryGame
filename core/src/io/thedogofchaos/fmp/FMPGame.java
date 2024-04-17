package io.thedogofchaos.fmp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.thedogofchaos.fmp.screen.MainMenu;

public class FMPGame extends Game {
	public SpriteBatch spriteBatch;
	public BitmapFont bitmapFont;

	public FMPGame() {
		System.out.println("And we're rolling!");
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
