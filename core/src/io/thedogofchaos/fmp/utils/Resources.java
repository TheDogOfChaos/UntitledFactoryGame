package io.thedogofchaos.fmp.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Resources {
    public static float TILE_SIZE;
    public static float WORLD_TILE_SIZE;
    private TextureAtlas gameSprites;

    private void Resources() {
        gameSprites = new TextureAtlas(Gdx.files.internal("packed/game.atlas"));
    }

    public Sprite createSpriteInTileSizeUnits(String spriteFileName) {
        Sprite sprite = new Sprite(gameSprites.createSprite(spriteFileName));
        resizeSpriteSizeToTileUnits(sprite);
        return sprite;
    }

    private void resizeSpriteSizeToTileUnits(Sprite s) {
        s.setSize(spriteUnitsToTileUnits(s.getWidth()), spriteUnitsToTileUnits(s.getHeight()));
    }

    public static float spriteUnitsToTileUnits(float val) {
        return val / TILE_SIZE;
    }
}
