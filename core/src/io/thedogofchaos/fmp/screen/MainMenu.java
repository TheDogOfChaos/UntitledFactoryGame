package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.*;
import io.thedogofchaos.fmp.Vars;

public class MainMenu implements Screen {
    private final UntitledFactoryGame game;
    private final Stage mainMenuStage;
    private final Table mainMenuTable;

    public MainMenu(UntitledFactoryGame UFGame) {
        this.game = UFGame;
        mainMenuStage = new Stage();
        mainMenuTable = new Table();
        Gdx.input.setInputProcessor(mainMenuStage);

        mainMenuTable.setFillParent(true);
        mainMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        mainMenuStage.addActor(mainMenuTable);
        Gdx.app.log("INFO","Main Menu Loaded");
    }

    @Override
    public void show() {
        Image title = new Image(new Texture(Gdx.files.internal("sprites/UFG_Logo.png")));
        mainMenuTable.add(title);
        mainMenuTable.row();
        TextButton startButton = new TextButton("START", Vars.skin);
        mainMenuTable.add(startButton);
        mainMenuTable.row();
        TextButton optionsButton = new TextButton("OPTIONS", Vars.skin);
        mainMenuTable.add(optionsButton);
        mainMenuTable.row();
        TextButton exitButton = new TextButton("EXIT", Vars.skin);
        mainMenuTable.add(exitButton);

        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.log("INFO", "Loading Game World");
                game.setScreen(new GameWorld());
            }
        });
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.log("INFO", "Loading Options Menu");
                // game.setScreen(new OptionsMenu());
                // TODO: Make Options Menu
            }
        });
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("INFO", "Closing game, goodbye!");
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        mainMenuStage.act(delta);
        mainMenuStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        mainMenuStage.getViewport().update(width, height);
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
        mainMenuStage.dispose();
    }
}
