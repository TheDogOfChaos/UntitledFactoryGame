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

package io.thedogofchaos.fmp.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.input.GameInputs;
import io.thedogofchaos.fmp.screen.GameWorld;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldTicker;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;
import static io.thedogofchaos.fmp.UntitledFactoryGame.spriteBatch;

public class WorldRenderer implements Disposable {

    public static void RenderWorld(){
        ScreenUtils.clear(0,0,0, 1f);
        gameCamera.position.set(Player.playerBody.getPosition().x-8, Player.playerBody.getPosition().y-8, 0);
        gameCamera.update();
        spriteBatch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws floors
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapFloor[x][y].name), (x * 16) + (Gdx.graphics.getWidth() / 2f) - Player.playerBody.getPosition().x, (y * 16) + (Gdx.graphics.getWidth() / 2f) - Player.playerBody.getPosition().y - 80);
            }
        }
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws walls
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapWall[x][y].name), (x * 16) + (Gdx.graphics.getWidth() / 2f) - Player.playerBody.getPosition().x, (y * 16) + (Gdx.graphics.getWidth() / 2f) - Player.playerBody.getPosition().y - 80);
            }
        }

        spriteBatch.draw(Player.playerSprite, (float) Gdx.graphics.getWidth() /2, (float) Gdx.graphics.getHeight() /2);
        bitmapFont.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, Gdx.graphics.getHeight()-10);
        if (Vars.ultimateDebugMode || Vars.ingameDebugInfo) {
            bitmapFont.draw(spriteBatch, "Player in-game XY Co-ords:" + (int) Player.playerBody.getPosition().x/16 + ", " + (int) Player.playerBody.getPosition().y/16, 10, 20);
            bitmapFont.draw(spriteBatch, "Player actual XY Co-ords:" + (int) Player.playerBody.getPosition().x + ", " + (int) Player.playerBody.getPosition().y, 10, 40);
            bitmapFont.draw(spriteBatch, "Player XY Velocity:" + (int) GameInputs.velX*Player.movementSpeedMultiplier + ", " + (int) GameInputs.velY*Player.movementSpeedMultiplier, 10, 60);
            bitmapFont.draw(spriteBatch, "Should Player be moving?: " + (GameInputs.isPlayerMoving ? "YES" : "NO"), 10, 80);
            bitmapFont.draw(spriteBatch, "Current keycode: " + GameInputs.currentKeys, 10, 100);
        }
        spriteBatch.end();
        GameWorld.physicsRenderer.render(GameWorld.world, gameCamera.combined);
        WorldTicker.tickWorld();
        GameWorld.worldStage.act(Gdx.graphics.getDeltaTime());
        GameWorld.worldStage.draw();
    }

    @Override
    public void dispose() {

    }
}
