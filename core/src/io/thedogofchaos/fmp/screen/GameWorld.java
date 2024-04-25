package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.input.PlayerInputHandler;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class GameWorld implements Screen {

    public static World world;

    public GameWorld(){
        gameCamera = new OrthographicCamera();
        actorStage = new Stage();
        //player = new Player();


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
        gameCamera.update();
        PlayerInputHandler.tickPlayerMovement();
        spriteBatch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws floors
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapData[0][x][y]), x * 16, y * 16);
            }
        }
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                // draws walls
                spriteBatch.draw(Vars.worldAtlas.findRegion(Vars.mapData[1][x][y]), x * 16, y * 16);
            }
        }
        spriteBatch.draw(Player.playerSprite,Player.playerX,Player.playerY);
        bitmapFont.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        spriteBatch.end();
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
