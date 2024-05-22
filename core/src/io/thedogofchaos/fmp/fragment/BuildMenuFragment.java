package io.thedogofchaos.fmp.fragment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;
import io.thedogofchaos.fmp.world.blocks.Block;

public class BuildMenuFragment implements Disposable {

    public static Table buildMenuTable;
    public BuildMenuFragment(){ // Purpose: Initialises the build menu table that is placed on the worldStage.
        buildMenuTable = new Table();
        buildMenuTable.setFillParent(true);
        buildMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        buildMenuTable.bottom().padBottom(16);
    }

    public static void show() {
        for (Block block: Blocks.naturalBlockList) {
            // Note: This probably isn't the best way of doing this but i have to get this done within the next 2 weeks, so too bad!
            // update: i don't have enough time
            int index = java.util.Arrays.asList(Blocks.naturalBlockList).indexOf(block);

            ImageButton blockButton = getImageButton(block, index);
            buildMenuTable.add(blockButton);
        }
    }

    private static ImageButton getImageButton(Block block, int index) {
        ImageButton blockButton = new ImageButton(new TextureRegionDrawable(Blocks.naturalBlockList[index].blockTextureRegion));
        blockButton.setTransform(true);
        blockButton.setOrigin(blockButton.getPrefWidth() / 2, blockButton.getPrefHeight() / 2);
        blockButton.setScale(1f,1f);
        blockButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("INFO", "block: "+ block.name);
            }
        });
        return blockButton;
    }

    @Override
    public void dispose() {

    }
}
