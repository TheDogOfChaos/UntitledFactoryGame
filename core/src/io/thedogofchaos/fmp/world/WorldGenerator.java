package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.screen.GameWorld;
import io.thedogofchaos.fmp.utils.NoiseGenerator;
import io.thedogofchaos.fmp.content.Blocks;

import static io.thedogofchaos.fmp.Vars.mapFloor;
import static io.thedogofchaos.fmp.Vars.mapWall;

public class WorldGenerator {

    public static void GenerateWorld(int mapWidth, int mapHeight, int noiseExponent, String noiseType, boolean regenerateMap) {
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
        double[] noise = switch (noiseType) {
            case "perlin" -> NoiseGenerator.normalise(NoiseGenerator.perlinNoise(mapWidth, mapHeight, noiseExponent));
            case "smooth" -> NoiseGenerator.normalise(NoiseGenerator.smoothNoise(mapWidth, mapHeight, noiseExponent));
            case "turbulence" -> NoiseGenerator.normalise(NoiseGenerator.turbulence(mapWidth, mapHeight, noiseExponent));
            default -> throw new IllegalStateException("Unexpected value: " + noiseType);
        };
        for (double v : noise) {
            if (Math.round(v) == 1) {
                mapWall[x][y] = Blocks.stoneWall;
                Block.newBlock(x,y,1,1);
            } else if (Math.round((v/0.25)*0.25)==0.5) {
                mapWall[x][y] = Blocks.darkStoneWall;
                Block.newBlock(x,y,0,0);
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
