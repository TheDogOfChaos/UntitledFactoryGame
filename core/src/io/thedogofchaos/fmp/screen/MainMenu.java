package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.FMPGame;
import io.thedogofchaos.fmp.Vars;

import static io.thedogofchaos.fmp.FMPGame.actorStage;
import static io.thedogofchaos.fmp.FMPGame.uiTable;

public class MainMenu implements Screen {
    private final FMPGame game;

    public MainMenu(FMPGame fmpGame) {
        this.game = fmpGame;
        actorStage = new Stage();
        uiTable = new Table();
        Gdx.input.setInputProcessor(actorStage);

        uiTable.setFillParent(true);
        uiTable.setDebug(true);
        actorStage.addActor(uiTable);
        Gdx.app.log("INFO","Main Menu Loaded");
    }

    @Override
    public void show() {
        Label title = new Label("FMP Title thing", Vars.skin);
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
                game.setScreen(new GameWorld());
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
