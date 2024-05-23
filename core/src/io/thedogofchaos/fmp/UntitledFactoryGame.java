/*
	Copyright (c) 2024 TheDogOfChaos

 	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.thedogofchaos.fmp;

import box2dLight.RayHandler;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import io.thedogofchaos.fmp.screen.MainMenu;
import io.thedogofchaos.fmp.world.Player;

public class UntitledFactoryGame extends Game {
	public static SpriteBatch spriteBatch;
	public static BitmapFont bitmapFont;
	public static OrthographicCamera gameCamera;
	public static Player player;
	public static RayHandler rayHandler;

	public UntitledFactoryGame() {
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
