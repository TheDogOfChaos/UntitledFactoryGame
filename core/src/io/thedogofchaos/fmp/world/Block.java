package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import io.thedogofchaos.fmp.Vars;

public class Block {
    public final String name;
    public Texture blockSprite;
    public TextureRegion blockTextureRegion;
    public Rectangle bounds;

    public boolean canBePlacedOn = true;
    public boolean canBeBroken = false;
    public boolean canBeWalkedOn = true;

    public Block(String name) {
        this.name = name;
        blockTextureRegion = Vars.worldAtlas.findRegion(name);
    }
}
