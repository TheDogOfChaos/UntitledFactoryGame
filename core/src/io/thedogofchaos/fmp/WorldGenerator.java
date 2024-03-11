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
    public static TiledMap GenerateWorld(int w, int h, int tW, int tH, int pE) {
        tiles = new Texture(Gdx.files.internal("tiles.png"));
        TextureRegion[][] splitTiles = TextureRegion.split(tiles, tW, tH);
        map = new TiledMap();
        MapLayers layers = map.getLayers();

        for (int l = 0; l < 20; l++) {
            int tile = 0;
            double[] perl = NoiseGenerator.normalise(NoiseGenerator.perlinNoise(w,h,pE));
            TiledMapTileLayer layer = new TiledMapTileLayer(w, h, tW, tH);
            for (int x = 0; x < w; x++){
                for (int y = 0; y < h; y++){
                    Cell cell = new Cell();
                    if (Math.round(perl[x+y]) == 1) {
                        cell.setTile(new StaticTiledMapTile(splitTiles[1][0]));
                    } else if (Math.round(perl[x+y]) == 0) {
                        cell.setTile(new StaticTiledMapTile(splitTiles[4][0]));
                    }
                    layer.setCell(x, y, cell);
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

