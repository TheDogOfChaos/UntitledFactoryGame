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
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.*;
import io.thedogofchaos.fmp.world.blocks.Block;

public class Vars {
    // This class contains all the values that are repeatedly used by my game, and aren't specific to a block.
    public static int mapWidth;
    public static int mapHeight;
    public static Block[][] mapFloor;
    public static Block[][] mapWall;
    public static Block[][] playerBuildings;

    public static TextureAtlas worldAtlas = new TextureAtlas(Gdx.files.internal("sprites/atlas/tileAtlas.atlas"));
    public static TextureRegion fallbackTexture = createFallbackTexture();;
    public static Skin skin = new Skin(Gdx.files.internal("ui/metal-ui/metal-ui.json"));

    public static boolean ultimateDebugMode = false; // For when I really fuck things up. Enables debug mode on basically everything.
    public static boolean ingameDebugInfo = false; // Enables the debug information. Flipped in GameInputs.java by pressing the F3 key.
    public static boolean stageDebugMode = false; // Enables the debug view of Stages.

    public static int mousePosX;
    public static int mousePosY;


    private static TextureRegion createFallbackTexture() {
        String base64Image = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAALGPC/xhBQAAAYVpQ0NQSUNDIHByb2ZpbGUAACiRfZE9SMNAHMVf00pFqh3sIOKQoTpZkCoiuEgVi2ChtBVadTC59AuaNCQtLo6Ca8HBj8Wqg4uzrg6ugiD4AeLs4KToIiX+Lym0iPHguB/v7j3u3gFCs8JU0zcBqFrNSMVjYja3Kvpf4UMQA4hiVmKmnkgvZuA6vu7h4etdhGe5n/tz9Ct5kwEekXiO6UaNeIN4erOmc94nDrGSpBCfE48bdEHiR67LDr9xLtos8MyQkUnNE4eIxWIXy13MSoZKPEUcVlSN8oWswwrnLc5qpc7a9+QvDOS1lTTXaY4gjiUkkIQIGXWUUUENEVo1UkykaD/m4h+2/UlyyeQqg5FjAVWokGw/+B/87tYsTEadpEAM6HmxrI9RwL8LtBqW9X1sWa0TwPsMXGkdf7UJzHyS3uho4SMguA1cXHc0eQ+43AGGnnTJkGzJS1MoFID3M/qmHDB4C/StOb2193H6AGSoq+Ub4OAQGCtS9rrLu3u7e/v3TLu/H/a4ctzi425UAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAC4jAAAuIwF4pT92AAAAB3RJTUUH6AQPDwUrQbfP4QAAABl0RVh0Q29tbWVudABDcmVhdGVkIHdpdGggR0lNUFeBDhcAAABqSURBVDhPxVFJCgAhDLOD//+yTl0g3UTowd5ampCF2j8lMV8CO6BpgioUEElB2x3fA6eSgOEIQjokB7J7CwxyVFgF2oY0ZTZ6XmPcAvrVto4h7rA8kBPifQsmvnmwLQSPRStaf+9bSGfQAef5JBZAV74nAAAAAElFTkSuQmCC";
        byte[] bytes = Base64Coder.decode(base64Image);

        Pixmap pixmap = new Pixmap(bytes, 0, bytes.length);
        Texture texture = new Texture(pixmap);
        TextureRegion fallback = new TextureRegion(texture);
        pixmap.dispose();
        return fallback;
    }
}
