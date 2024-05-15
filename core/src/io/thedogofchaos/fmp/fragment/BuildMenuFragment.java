package io.thedogofchaos.fmp.fragment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.screen.GameWorld;
import io.thedogofchaos.fmp.world.Block;
import io.thedogofchaos.fmp.content.Blocks;

public class BuildMenuFragment implements Disposable {
    public static Table buildMenuTable;
    public BuildMenuFragment(){
        buildMenuTable = new Table();
        buildMenuTable.setFillParent(true);
        buildMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        buildMenuTable.bottom().padBottom(16);
    }

    public static void show() {
        for (int i = 0; i < Blocks.blockList.length; i++) {
            ImageButton blockButton = new ImageButton(new TextureRegionDrawable(Blocks.blockList[i].blockTextureRegion));
            blockButton.setTransform(true);
            blockButton.setOrigin(blockButton.getPrefWidth() / 2, blockButton.getPrefHeight() / 2);
            blockButton.setScale(2f, 2f);
            blockButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Gdx.app.log("INFO", "balls");
                }
            });
            buildMenuTable.add(blockButton);
        }
    }

    @Override
    public void dispose() {

    }
}
