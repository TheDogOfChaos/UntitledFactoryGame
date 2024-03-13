package io.thedogofchaos.fmp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class WorldGenerator {
    private static Texture tiles;
    private static TiledMap map;

    //TODO: make this use NoiseGenerator instead of randomly selecting tiles
    public static TiledMap GenerateWorld(int mapWidth, int mapHeight, int tileWidth, int tileHeight, int exponent, int mapLayers, String noiseType) {
        int x = 0;
        int y = 0;
        tiles = new Texture(Gdx.files.internal("spriteAtlas.png"));
        TextureRegion[][] splitTiles = TextureRegion.split(tiles, tileWidth, tileHeight);
        map = new TiledMap();
        TiledMapTileLayer layer = new TiledMapTileLayer(mapWidth, mapHeight, tileWidth, tileHeight);
        MapLayers layers = map.getLayers();
        for (int i = 0; i<(mapWidth*mapHeight); i++) {
            Cell cell = new Cell();
            cell.setTile(new StaticTiledMapTile(splitTiles[1][0]));
            layer.setCell(x, y, cell);
            x++;
            if (x == mapWidth) {
                y++;
                x = 0;
            }
        }
        layers.add(layer);
        for (int l = 0; l < mapLayers; l++) {
            double[] perl;
            switch (noiseType) {
                case "perlin":
                    perl = NoiseGenerator.normalise(NoiseGenerator.perlinNoise(mapWidth, mapHeight, exponent));
                    break;
                case "smooth":
                     perl = NoiseGenerator.normalise(NoiseGenerator.smoothNoise(mapWidth, mapHeight, exponent));
                    break;
                case "turbulence":
                     perl = NoiseGenerator.normalise(NoiseGenerator.turbulence(mapWidth, mapHeight, exponent));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + noiseType);
            }
            x=0;y=0;
            for (double v : perl) {
                Cell cell = new Cell();
                if (Math.round(v) == 1) {
                    cell.setTile(new StaticTiledMapTile(splitTiles[0][1]));
                }
                layer.setCell(x, y, cell);
                x++;
                if (x == mapWidth) {
                    y++;
                    x = 0;
                }
            }
            layers.add(layer);
        }

        return map;
    }

}

