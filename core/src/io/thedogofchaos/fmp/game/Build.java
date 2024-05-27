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

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import io.thedogofchaos.fmp.*;
import io.thedogofchaos.fmp.world.blocks.*;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Build{
    public static String currentSelectedBuilding;
    public static void placeBlock(int posX, int posY, float width, float height){
        Block.blockBodyDef = new BodyDef();
        Block.blockBodyDef.type = BodyDef.BodyType.StaticBody;
        Block.blockBodyDef.position.set(new Vector2((posX*16), (posY*16)));

        Block.blockBody = world.createBody(Block.blockBodyDef);

        PolygonShape blockBox = new PolygonShape();
        blockBox.setAsBox(width, height);
        Block.blockBody.createFixture(blockBox, 0.0f);
        Vars.playerBuildings[posX][posY] = Block.blockBody;
        blockBox.dispose();
    }
    public static void removeBlock(){
    }
}
