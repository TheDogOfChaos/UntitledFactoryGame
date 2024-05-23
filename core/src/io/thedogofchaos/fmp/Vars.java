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

package io.thedogofchaos.fmp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import io.thedogofchaos.fmp.world.blocks.Block;

public class Vars {
    // This class contains all the values that are repeatedly used by my game, and aren't specific to a block.
    public static int mapWidth;
    public static int mapHeight;
    public static Block[][] mapFloor;
    public static Block[][] mapWall;

    public static TextureAtlas worldAtlas = new TextureAtlas(Gdx.files.internal("sprites/atlas/tileAtlas.atlas"));
    public static Skin skin = new Skin(Gdx.files.internal("ui/metal-ui/metal-ui.json"));

    public static boolean ultimateDebugMode = false; // For when I really fuck things up. Enables debug mode on basically everything.
    public static boolean ingameDebugInfo = false; // Enables debug information. Flipped in GameInputs.java by pressing the F3 key.
    public static boolean stageDebugMode = true; // Enables the debug view of Stages.
}
