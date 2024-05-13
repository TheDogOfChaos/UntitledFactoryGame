package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.thedogofchaos.fmp.fragment.BuildMenuFragment;
import io.thedogofchaos.fmp.input.GameInputs;
import io.thedogofchaos.fmp.world.Block;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;
import io.thedogofchaos.fmp.graphics.WorldRenderer;

import java.util.ArrayList;
import java.util.HashMap;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class GameWorld implements Screen {

    public static World world;
    public static Box2DDebugRenderer physicsRenderer;
    public static Stage worldStage;
    private final BuildMenuFragment buildMenuFragment;
    public static HashMap<Block, String> builtBuildings = new HashMap<Block, String>();

    public GameWorld(){
        gameCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameCamera.position.set(gameCamera.viewportWidth / 2f, gameCamera.viewportHeight / 2f, 0);

        worldStage = new Stage();
        buildMenuFragment = new BuildMenuFragment();
        worldStage.addActor(BuildMenuFragment.buildMenuTable);

        world = new World(new Vector2(0, 0), true);
        WorldGenerator.GenerateWorld(128,128,2,"perlin");

        player = new Player();

        physicsRenderer = new Box2DDebugRenderer();

        //LightingHandler.initLighting();

        GameInputs inputHandler = new GameInputs();
        Gdx.input.setInputProcessor(inputHandler);

        Gdx.app.log("INFO","Game World Loaded");

    }
    
    @Override
    public void show() {
        BuildMenuFragment.show();
    }

    @Override
    public void render(float delta) {
        WorldRenderer.RenderWorld();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        worldStage.dispose();
        world.dispose();
    }
}
