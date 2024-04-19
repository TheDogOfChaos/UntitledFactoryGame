package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.FMPGame;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;
import org.w3c.dom.Text;

import static io.thedogofchaos.fmp.FMPGame.*;

public class GameWorld implements Screen {

    public GameWorld(){
        gameCamera = new OrthographicCamera();
        actorStage = new Stage();
        Gdx.app.log("INFO","Game World Loaded");
        WorldGenerator.GenerateWorld(64,64,1,"perlin");
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0, 1f);
        gameCamera.update();
        FMPGame.spriteBatch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                if (Vars.mapData[0][x][y] == "stoneFloor") {
                    FMPGame.spriteBatch.draw(Vars.worldAtlas.findRegion("stoneFloor"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "stoneWall") {
                    FMPGame.spriteBatch.draw(Vars.worldAtlas.findRegion("stoneWall"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "darkStoneWall") {
                    FMPGame.spriteBatch.draw(Vars.worldAtlas.findRegion("darkStoneWall"), x * 16, y * 16);
                }
                if (Vars.mapData[1][x][y] == "air") {
                    FMPGame.spriteBatch.draw(Vars.worldAtlas.findRegion("air"), x * 16, y * 16);
                }
            }
        }
        //font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        FMPGame.spriteBatch.end();
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
