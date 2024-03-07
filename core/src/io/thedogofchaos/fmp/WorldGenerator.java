package io.thedogofchaos.fmp;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

public class WorldGenerator {
    private TiledMap map;
    private TiledMapTileLayer mapLayer;
    private TiledMapTileSet tileSet;

    public GenerateWorld(int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
        map = loadMap();
    }
}
