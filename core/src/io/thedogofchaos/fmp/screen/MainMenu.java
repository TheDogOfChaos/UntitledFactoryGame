package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.UntitledFactoryGame;
import io.thedogofchaos.fmp.Vars;

import static io.thedogofchaos.fmp.UntitledFactoryGame.actorStage;
import static io.thedogofchaos.fmp.UntitledFactoryGame.uiTable;

public class MainMenu implements Screen {
    private final UntitledFactoryGame game;

    public MainMenu(UntitledFactoryGame UFGame) {
        this.game = UFGame;
        actorStage = new Stage();
        uiTable = new Table();
        Gdx.input.setInputProcessor(actorStage);

        uiTable.setFillParent(true);
        uiTable.setDebug(false); // if i have to flip this, i probably fucked up the main menu somehow
        actorStage.addActor(uiTable);
        Gdx.app.log("INFO","Main Menu Loaded");
    }

    @Override
    public void show() {
        Image title = new Image(new Texture(Gdx.files.internal("sprites/UFG_Logo.png")));
        uiTable.add(title);
        uiTable.row();
        TextButton startButton = new TextButton("START", Vars.skin);
        uiTable.add(startButton);
        uiTable.row();
        TextButton optionsButton = new TextButton("OPTIONS", Vars.skin);
        uiTable.add(optionsButton);
        uiTable.row();
        TextButton exitButton = new TextButton("EXIT", Vars.skin);
        uiTable.add(exitButton);

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
        actorStage.act(delta);
        actorStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        actorStage.getViewport().update(width, height);
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
        actorStage.dispose();
    }
}
