package io.thedogofchaos.fmp;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import java.util.Arrays;

public class WorldGenerator {
    // TODO: Rewrite this POS from scratch to make it work.
    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, int mapLayers, String noiseType) {
        int[][][] mapArr = new int[mapLayers][mapWidth][mapHeight]; int x; int y; int l;
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
            mapArr[0][x][y] = 1;
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        for (l = 0; l < mapLayers; l++) {
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
                    mapArr[l][x][y] = 10;
                    // TODO: Do this next
                } else if (Math.round((v*2)+0.5)==0.5) {
                    mapArr[l][x][y] = 9;
                } else {
                    mapArr[l][x][y] = 8;
                }
                x++;
                if (x == mapWidth) {
                    y++;
                    x = 0;
                }
            }
            System.out.println(Arrays.deepToString(mapArr));
        }
    }
}
