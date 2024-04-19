package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
public class WorldGenerator {
    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, String noiseType) {
        Vars.mapWidth = mapWidth;
        Vars.mapHeight = mapHeight;
        String[][][] mapArr = new String[2][mapWidth][mapHeight]; int x; int y;
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
            mapArr[0][x][y] = "stoneFloor";
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        x=0;y=0;
        double[] noise;
        switch (noiseType) {
            case "perlin":
                noise = NoiseGenerator.normalise(NoiseGenerator.perlinNoise(mapWidth, mapHeight, noiseExponent));
                break;
            case "smooth":
                noise = NoiseGenerator.normalise(NoiseGenerator.smoothNoise(mapWidth, mapHeight, noiseExponent));
                break;
            case "turbulence":
                noise = NoiseGenerator.normalise(NoiseGenerator.turbulence(mapWidth, mapHeight, noiseExponent));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + noiseType);
        }
        for (double v : noise) {
            if (Math.round(v) == 1) {
                mapArr[1][x][y] = "stoneWall";
            } else if (Math.round((v*2)+0.5)==0.5) {
                mapArr[1][x][y] = "darkStoneWall";
            } else {
                mapArr[1][x][y] = "air";
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

