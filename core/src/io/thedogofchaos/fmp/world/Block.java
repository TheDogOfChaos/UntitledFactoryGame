package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import io.thedogofchaos.fmp.Vars;

public class Block {
    public final String name;
    public Texture blockSprite;
    public Texture blockTextureRegion;
    public Rectangle bounds;

    public int blockX;
    public int blockY;

    public boolean canBePlacedOn = true;
    public boolean canBeBroken = false;
    public boolean canBeWalkedOn = true;

    public Block(String name) {
        this.name = name;
        blockSprite = Vars.worldAtlas.findRegion(name).getTexture();
        bounds = new Rectangle(blockX, blockY, blockSprite.getWidth(), blockSprite.getHeight());
    }
}
