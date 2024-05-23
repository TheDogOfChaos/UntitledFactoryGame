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

package io.thedogofchaos.fmp.world.blocks;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import io.thedogofchaos.fmp.Vars;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Block {
    public final String name;
    public TextureRegion blockTextureRegion;
    public static BodyDef blockBodyDef;
    public static Body blockBody;
    public final int blockWidth;
    public final int blockHeight;

    public boolean canBePlacedOn = true;
    public boolean canBeBroken = false;
    public boolean canBeWalkedOn = true;
    public boolean isDynamic = false;

    public Block(String name, int blockWidth, int blockHeight) {
        this.name = name;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        blockTextureRegion = Vars.worldAtlas.findRegion(name);
    }
    public static void placeBlock(float posX, float posY, float width, float height){
        blockBodyDef = new BodyDef();
        blockBodyDef.type = BodyDef.BodyType.StaticBody;
        blockBodyDef.position.set(new Vector2((posX*16), (posY*16)));

        blockBody = world.createBody(blockBodyDef);

        PolygonShape blockBox = new PolygonShape();
        blockBox.setAsBox(width, height);
        blockBody.createFixture(blockBox, 0.0f);
        blockBox.dispose();
    }
    public static void removeBlock(){
    }
}
