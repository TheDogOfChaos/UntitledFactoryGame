package io.thedogofchaos.fmp.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.UntitledFactoryGame;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;
import io.thedogofchaos.fmp.input.InputHandler;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldTicker;
import io.thedogofchaos.fmp.screen.GameWorld;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;
import static io.thedogofchaos.fmp.UntitledFactoryGame.spriteBatch;

public class WorldRenderer implements Disposable {
    public static void RenderWorld(){
        ScreenUtils.clear(0,0,0, 1f);

        spriteBatch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws floors
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapFloor[x][y].name), x * 16, y * 16);
            }
        }
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws walls
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapWall[x][y].name), x * 16, y * 16);
            }
        }

        spriteBatch.draw(Player.playerSprite,Player.playerBody.getPosition().x, Player.playerBody.getPosition().y);
        bitmapFont.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, Gdx.graphics.getHeight()-10);
        if (Vars.debugMode) {
            bitmapFont.draw(spriteBatch, "Player Ingame XY Co-ords:" + (int) Player.playerBody.getPosition().x/16 + ", " + (int) Player.playerBody.getPosition().y/16, 10, 20);
            bitmapFont.draw(spriteBatch, "Player Actual XY Co-ords:" + (int) Player.playerBody.getPosition().x + ", " + (int) Player.playerBody.getPosition().y, 10, 40);
            bitmapFont.draw(spriteBatch, "Player XY Velocity:" + (int) InputHandler.velX*Player.movementSpeedMultiplier + ", " + (int) InputHandler.velY*Player.movementSpeedMultiplier, 10, 60);
            bitmapFont.draw(spriteBatch, "Should Player be moving?: " + (InputHandler.isPlayerMoving ? "YES" : "NO"), 10, 80);
            bitmapFont.draw(spriteBatch, "Current keycode: " + InputHandler.currentKeys, 10, 100);
        }
        spriteBatch.end();
        WorldTicker.tickWorld();
        GameWorld.physicsRenderer.render(GameWorld.world, gameCamera.combined);
        rayHandler.setCombinedMatrix(gameCamera);
        rayHandler.setShadows(true);
        rayHandler.updateAndRender();
    }

    @Override
    public void dispose() {

    }
}
