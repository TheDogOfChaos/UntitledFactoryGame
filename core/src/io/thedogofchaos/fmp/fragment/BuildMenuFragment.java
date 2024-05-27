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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;
import io.thedogofchaos.fmp.world.blocks.Block;

import java.util.*;

public class BuildMenuFragment implements Disposable {

    public static Table buildMenuTable;
    public BuildMenuFragment(){ // Purpose: Initializes the build menu table that is placed on the worldStage.
        buildMenuTable = new Table();
        buildMenuTable.setFillParent(true);
        buildMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        buildMenuTable.bottom().padBottom(16);
    }

    public static void show() {
        for (int i = 0; i < Blocks.getAllBlocks().size(); i++) {
            // Note: This probably isn't the best way of doing this but i have to get this project in a playable state very soon, so too bad!

            ImageButton blockButton = new ImageButton(new TextureRegionDrawable(Blocks.getAllBlocks().get(i).blockTextureRegion));
            blockButton.setTransform(true);
            blockButton.setOrigin(blockButton.getPrefWidth() / 2, blockButton.getPrefHeight() / 2);
            blockButton.setScale(1f,1f);
            blockButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Gdx.app.log("HEHEHE","fuck");
                }
            });
            buildMenuTable.add(blockButton);
        }
    }


    @Override
    public void dispose() {

    }
}
