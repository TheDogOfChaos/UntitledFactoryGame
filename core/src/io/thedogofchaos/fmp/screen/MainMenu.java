package io.thedogofchaos.fmp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.FMPGame;
import io.thedogofchaos.fmp.Vars;

public class MainMenu implements Screen {
    private Stage stage;
    private Table table;

    public MainMenu(FMPGame fmpGame) {
        stage = new Stage();
        table = new Table();
        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
    }

    @Override
    public void show() {
        Label title = new Label("FMP Title thing", Vars.skin);
        table.add(title);
        table.row();
        TextButton startButton = new TextButton("START", Vars.skin);
        table.add(startButton);
        table.row();
        TextButton optionsButton = new TextButton("OPTIONS", Vars.skin);
        table.add(optionsButton);
        table.row();
        TextButton exitButton = new TextButton("EXIT", Vars.skin);
        table.add(exitButton);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
