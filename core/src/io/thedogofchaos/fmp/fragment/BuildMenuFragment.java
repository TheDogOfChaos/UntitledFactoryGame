/*
	Copyright (c) 2024 TheDogOfChaos

 	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.thedogofchaos.fmp.fragment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;
import io.thedogofchaos.fmp.game.*;
import io.thedogofchaos.fmp.utils.*;
import io.thedogofchaos.fmp.world.blocks.Block;

public class BuildMenuFragment implements Disposable {

    public static Table buildMenuTable;
    public BuildMenuFragment(){ // Purpose: Initializes the build menu table that is placed on the worldStage.
        buildMenuTable = new Table();
        buildMenuTable.setFillParent(true);
        buildMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        buildMenuTable.bottom().padBottom(16);
    }

    public static void show() {
        for (Block block : Blocks.allBlocks) {
            int index = java.util.Arrays.asList(Blocks.allBlocks).indexOf(block);
            // Note: This probably isn't the best way of doing this but i have to get this project in a playable state very soon, so too bad!
            if (block.isPlaceableByPlayer){
                if (Blocks.allBlocks[index].blockTextureRegion == Vars.fallbackTexture) {
                    Gdx.app.error("BuildMenuFragment", "Using fallback texture for block index: " + index + ", name: " + Blocks.allBlocks[index].name);
                }
                ImageButton blockButton = getImageButton(index);
                buildMenuTable.add(blockButton);
            }
        }
    }

    private static ImageButton getImageButton(int index){
        ImageButton blockButton = new ImageButton(TextureUtils.resizeDrawable(Blocks.allBlocks[index].blockTextureRegion,32,32));
        blockButton.setTransform(true);
        blockButton.setOrigin(blockButton.getPrefWidth() / 2, blockButton.getPrefHeight() / 2);
        blockButton.setScale(1f, 1f);
        blockButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                Build.currentSelectedBuilding = Blocks.allBlocks[index];
                Gdx.app.log("BuildMenuFragment",Build.currentSelectedBuilding.name);
            }
        });
        return blockButton;
    }

    @Override
    public void dispose() {

    }
}
