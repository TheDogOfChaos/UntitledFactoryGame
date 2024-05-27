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

package io.thedogofchaos.fmp.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import io.thedogofchaos.fmp.*;
import io.thedogofchaos.fmp.content.*;
import io.thedogofchaos.fmp.world.blocks.*;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Build{
    public static String currentSelectedBuilding;
    private static Block blockToRemove;

    public static void placeBlock(Block block, int posX, int posY, float width, float height){
        Block.blockBodyDef = new BodyDef();
        Block.blockBodyDef.type = BodyDef.BodyType.StaticBody;
        Block.blockBodyDef.position.set(new Vector2((posX*16), (posY*16)));

        Block.blockBody = world.createBody(Block.blockBodyDef);

        PolygonShape blockBox = new PolygonShape();
        blockBox.setAsBox(width, height);
        Block.blockBody.createFixture(blockBox, 0.0f);
        if (block.isNatural && block.isSolid){
            Vars.mapWall[posX][posY] = block;
        } else if (block.isPlaceableByPlayer){
            Vars.playerBuildings[posX][posY] = block;
        } else if (block != Blocks.air){
            Gdx.app.error("ERROR","Invalid block '"+block+"'attempted to be placed at: "+posX+", "+posY);
        }
        blockBox.dispose();
    }
    public static void removeBlock(int posX, int posY){
        if (Vars.mapWall[posX][posY] != Blocks.air) {
            blockToRemove = Vars.mapWall[posX][posY];
            Vars.mapWall[posX][posY] = Blocks.air;
        } else if (Vars.playerBuildings[posX][posY] != Blocks.air) {
            blockToRemove = Vars.playerBuildings[posX][posY];
            Vars.playerBuildings[posX][posY] = Blocks.air;
        } else {
            Gdx.app.log("INFO", "No block found at: " + posX + ", " + posY);
            return;
        }

        // If a block was found, remove its physical body
        if (blockToRemove != null && blockToRemove.blockBody != null) {
            world.destroyBody(blockToRemove.blockBody);
            blockToRemove.blockBody = null;
        }
    }
}
