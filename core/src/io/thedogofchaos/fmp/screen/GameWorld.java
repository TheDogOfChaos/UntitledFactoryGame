package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.UntitledFactoryGame;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.WorldGenerator;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class GameWorld implements Screen {

    public GameWorld(){
        gameCamera = new OrthographicCamera();
        actorStage = new Stage();
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
        UntitledFactoryGame.spriteBatch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                if (Vars.mapData[0][x][y] == "stoneFloor") {
                    UntitledFactoryGame.spriteBatch.draw(Vars.worldAtlas.findRegion("stoneFloor"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "stoneWall") {
                    UntitledFactoryGame.spriteBatch.draw(Vars.worldAtlas.findRegion("stoneWall"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "darkStoneWall") {
                    UntitledFactoryGame.spriteBatch.draw(Vars.worldAtlas.findRegion("darkStoneWall"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "air") {
                    UntitledFactoryGame.spriteBatch.draw(Vars.worldAtlas.findRegion("air"), x * 16, y * 16);
                }
            }
        }
        //font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        UntitledFactoryGame.spriteBatch.end();
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
