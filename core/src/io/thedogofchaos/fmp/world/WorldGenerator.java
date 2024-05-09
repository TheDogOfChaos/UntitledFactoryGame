package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
import io.thedogofchaos.fmp.content.Blocks;

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
                    Block.newBlock(x, y, 8f, 8f);
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
