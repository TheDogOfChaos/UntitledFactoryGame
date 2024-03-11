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

    public static TiledMap GenerateWorld() {
        tiles = new Texture(Gdx.files.internal("tiles.png"));
        TextureRegion[][] splitTiles = TextureRegion.split(tiles, 32, 32);
        map = new TiledMap();
        MapLayers layers = map.getLayers();
        for (int l = 0; l < 20; l++) {
            TiledMapTileLayer layer = new TiledMapTileLayer(150, 100, 32, 32);
            for (int x = 0; x < 150; x++) {
                for (int y = 0; y < 100; y++) {
                    int ty = (int)(Math.random() * splitTiles.length);
                    int tx = (int)(Math.random() * splitTiles[ty].length);
                    Cell cell = new Cell();
                    cell.setTile(new StaticTiledMapTile(splitTiles[ty][tx]));
                    layer.setCell(x, y, cell);
                }
            }
            layers.add(layer);
        }
        return map;
    }

}

