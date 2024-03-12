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
    public static TiledMap GenerateWorld(int mapWidth, int mapHeight, int tileWidth, int tileHeight, int perlinExponent, int perlLayers) {
        tiles = new Texture(Gdx.files.internal("spriteAtlas.png"));
        TextureRegion[][] splitTiles = TextureRegion.split(tiles, tileWidth, tileHeight);
        map = new TiledMap();
        MapLayers layers = map.getLayers();

        for (int l = 0; l < perlLayers; l++) {
            double[] perl = NoiseGenerator.normalise(NoiseGenerator.perlinNoise(mapWidth,mapHeight,perlinExponent));
            TiledMapTileLayer layer = new TiledMapTileLayer(mapWidth, mapHeight, tileWidth, tileHeight);
            int x = 0; int y = 0;
            for (double v : perl) {
                Cell cell = new Cell();
                if (Math.round(v) == 1) {
                    cell.setTile(new StaticTiledMapTile(splitTiles[1][0]));
                } else if (Math.round(v) == 0) {
                    cell.setTile(new StaticTiledMapTile(splitTiles[0][0]));
                }
                layer.setCell(x, y, cell);
                x++;
                if (x == mapWidth) {
                    y++;
                    x = 0;
                }
            }
/*
            for (int x = 0; x < w; x++) {
                double tX = perl[x*h];
                for (int y = 0; y < h; y++) {
                    double tY = perl[y];
                    Cell cell = new Cell();
                    if perl[y]
                    cell.setTile(new StaticTiledMapTile(splitTiles[(int) tY][(int) tX]));
                    layer.setCell(x, y, cell);
                }
            }
*/
            layers.add(layer);
        }
        return map;
    }

}

