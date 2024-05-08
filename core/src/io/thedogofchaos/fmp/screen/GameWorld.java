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
import io.thedogofchaos.fmp.graphics.LightingHandler;
import io.thedogofchaos.fmp.input.InputHandler;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;
import io.thedogofchaos.fmp.world.WorldTicker;
import io.thedogofchaos.fmp.graphics.WorldRenderer;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class GameWorld implements Screen {

    public static World world;
    public static Box2DDebugRenderer physicsRenderer;

    public GameWorld(){
        gameCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameCamera.position.set(gameCamera.viewportWidth / 2f, gameCamera.viewportHeight / 2f, 0);
        actorStage = new Stage();
        world = new World(new Vector2(0, 0), true);
        WorldGenerator.GenerateWorld(128,128,2,"perlin", false);
        player = new Player();
        physicsRenderer = new Box2DDebugRenderer();
        LightingHandler.initLighting();

        InputHandler inputhandler = new InputHandler();
        Gdx.input.setInputProcessor(inputhandler);
        Gdx.app.log("INFO","Game World Loaded");
    }
    
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        WorldRenderer.RenderWorld();
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
