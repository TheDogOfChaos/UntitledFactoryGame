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

package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.game.*;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
import io.thedogofchaos.fmp.content.Blocks;
import io.thedogofchaos.fmp.world.blocks.*;

import static io.thedogofchaos.fmp.Vars.mapFloor;
import static io.thedogofchaos.fmp.Vars.mapWall;

public class WorldGenerator {


    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, String noiseType) {
        Vars.mapWidth = mapWidth;
        Vars.mapHeight = mapHeight;
        mapFloor = new Block[mapWidth][mapHeight]; mapWall = new Block[mapWidth][mapHeight]; int x; int y;
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
            mapFloor[x][y] = Blocks.stoneFloor;
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        x=0;y=0;
        double[] noise = NoiseGenerator.generateNoise(noiseType,mapWidth,mapHeight,noiseExponent);
        if (noise != null) {
            for (double v : noise) {
                if (Math.round(v) == 1) {
                    mapWall[x][y] = Blocks.darkStoneWall;
                    Build.placeBlock(x, y, 8f, 8f);
                } else {
                    mapWall[x][y] = Blocks.air;
                }
                x++;
                if (x == mapWidth) {
                    y++;
                    x = 0;
                }
            }
        }
    }
}
