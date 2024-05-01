package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.math.Rectangle;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
import io.thedogofchaos.fmp.content.Blocks;
public class WorldGenerator {
    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, String noiseType) {
        Vars.mapWidth = mapWidth;
        Vars.mapHeight = mapHeight;
        Block[] mapFloor = new Block[mapWidth*mapHeight]; Block[] mapWall = new Block[mapWidth*mapHeight]; int x; int y;
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
            mapFloor[i] = Blocks.stoneFloor;
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
            case "turbulence" -> NoiseGenerator.normalise(NoiseGenerator.turbulence(mapWidth, mapHeight, noiseExponent));
            default -> throw new IllegalStateException("Unexpected value: " + noiseType);
        };
        int i = 0;
        for (double v : noise) {
            if (Math.round(v) == 1) {
                Blocks.stoneWall.bounds = new Rectangle(x*16,y*16,16,16);
                mapWall[i] = Blocks.stoneWall;
            } else if (Math.round((v/0.25)*0.25)==0.5) {
                Blocks.stoneWall.bounds = new Rectangle(x*16,y*16,16,16);
                mapWall[i] = Blocks.darkStoneWall;
            } else {
                mapWall[i] = Blocks.air;
            }
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
            i++;
        }
        Vars.mapData[0][] = mapFloor;
        Vars.mapData[1][] = mapWall;
    }
}
