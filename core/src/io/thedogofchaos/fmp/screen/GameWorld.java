package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.input.PlayerInputHandler;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;
import io.thedogofchaos.fmp.world.WorldTicker;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class GameWorld implements Screen {

    public static World world;
    Box2DDebugRenderer debugRenderer;

    public GameWorld(){
        gameCamera = new OrthographicCamera();
        actorStage = new Stage();
        world = new World(new Vector2(0, 0), true);
        player = new Player();
        debugRenderer = new Box2DDebugRenderer();

        PlayerInputHandler inputhandler = new PlayerInputHandler();
        Gdx.input.setInputProcessor(inputhandler);
        WorldGenerator.GenerateWorld(64,64,3,"perlin");
        Gdx.app.log("INFO","Game World Loaded");
    }
    
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0, 1f);
        debugRenderer.render(world, gameCamera.combined);
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
            bitmapFont.draw(spriteBatch, "Player XY Co-ords:" + (int) Player.playerBody.getPosition().x + ", " + (int) Player.playerBody.getPosition().y, 10, 20);
            bitmapFont.draw(spriteBatch, "Player XY Velocity:" + (int) PlayerInputHandler.velX + ", " + (int) PlayerInputHandler.velY, 10, 40);
            bitmapFont.draw(spriteBatch, "Should Player be moving?: " + (PlayerInputHandler.isPlayerMoving ? "YES" : "NO"), 10, 60);
            bitmapFont.draw(spriteBatch, "Current keycode: " + PlayerInputHandler.currentKeyCode, 10, 80);
        }
        spriteBatch.end();
        WorldTicker.tickWorld();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
