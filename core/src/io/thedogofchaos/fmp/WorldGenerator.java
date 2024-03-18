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
    public static TiledMap GenerateWorld(int mapWidth, int mapHeight, int tileWidth, int tileHeight, int noiseExponent, int mapLayers, String noiseType) {
        int x; int y; int l;
        tiles = new Texture(Gdx.files.internal("spriteAtlas.png"));
        TextureRegion[][] splitTiles = TextureRegion.split(tiles, tileWidth, tileHeight);
        map = new TiledMap();
        TiledMapTileLayer layer = new TiledMapTileLayer(mapWidth, mapHeight, tileWidth, tileHeight);
        MapLayers layers = map.getLayers();
        x=0;y=0;
        for (int i = 0; i < (mapWidth * mapHeight); i++) {
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
        for (l = 0; l < mapLayers; l++) {
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

