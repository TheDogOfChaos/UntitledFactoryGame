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

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.thedogofchaos.fmp.Vars;

public class Block {
    public final String name;
    public TextureRegion blockTextureRegion;
    public static BodyDef blockBodyDef;
    public static Body blockBody;

    public final int blockWidth;
    public final int blockHeight;

    public final Vector2 blockIngamePos;

    public boolean isPlaceableOn = true;
    public boolean isPlaceableByPlayer = false;
    public boolean isBreakable;
    public boolean isSolid;
    public boolean isWalkableOn = true;
    public boolean isDynamic = false;
    public boolean isNatural;

    public Block(String name, int blockWidth, int blockHeight, Vector2 blockInGamePos) {
        this.name = name;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        blockTextureRegion = Vars.worldAtlas.findRegion(name);
        this.blockIngamePos = blockInGamePos;

        if (blockTextureRegion == null) {
            Gdx.app.error("Block", "Texture region not found for block: " + name + ". Perhaps you forgot to add it to the atlas? Resorting to fallback.");
            blockTextureRegion = Vars.fallbackTexture;
        }
    }
}
