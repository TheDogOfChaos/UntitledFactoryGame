package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.math.Rectangle;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
import io.thedogofchaos.fmp.content.Blocks;
public class WorldGenerator {
    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, String noiseType) {
        Vars.mapWidth = mapWidth;
        Vars.mapHeight = mapHeight;
        Block[][][] mapArr = new Block[2][mapWidth][mapHeight]; int x; int y;
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
            mapArr[0][x][y] = Blocks.stoneFloor;
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        x=0;y=0;
        double[] noise = switch (noiseType) {
            case "perlin" -> NoiseGenerator.normalise(NoiseGenerator.perlinNoise(mapWidth, mapHeight, noiseExponent));
            case "smooth" -> NoiseGenerator.normalise(NoiseGenerator.smoothNoise(mapWidth, mapHeight, noiseExponent));
            case "turbulence" ->
                    NoiseGenerator.normalise(NoiseGenerator.turbulence(mapWidth, mapHeight, noiseExponent));
            default -> throw new IllegalStateException("Unexpected value: " + noiseType);
        };
        for (double v : noise) {
            if (Math.round(v) == 1) {
                Blocks.stoneWall.bounds = new Rectangle(x*16,y*16,16,16);
                mapArr[1][x][y] = Blocks.stoneWall;
            } else if (Math.round((v*2)+0.5)==0.5) {
                Blocks.stoneWall.bounds = new Rectangle(x*16,y*16,16,16);
                mapArr[1][x][y] = Blocks.darkStoneWall;
            } else {
                mapArr[1][x][y] = Blocks.air;
            }
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        Vars.mapData = mapArr;
    }
}
