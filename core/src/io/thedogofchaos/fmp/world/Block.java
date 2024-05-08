package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import io.thedogofchaos.fmp.Vars;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Block {
    public final String name;
    public Texture blockSprite;
    public TextureRegion blockTextureRegion;
    public static BodyDef blockBodyDef;
    public static Body blockBody;

    public boolean canBePlacedOn = true;
    public boolean canBeBroken = false;
    public boolean canBeWalkedOn = true;

    public Block(String name) {
        this.name = name;
        blockTextureRegion = Vars.worldAtlas.findRegion(name);
    }
    public static void newBlock(float posX, float posY, float width, float height){
        blockBodyDef = new BodyDef();
        blockBodyDef.type = BodyDef.BodyType.StaticBody;
        blockBodyDef.position.set(new Vector2((posX*16), (posY*16)));

        blockBody = world.createBody(blockBodyDef);

        PolygonShape blockBox = new PolygonShape();
        blockBox.setAsBox(width, height);
        blockBody.createFixture(blockBox, 0.0f);
        blockBox.dispose();
    }
}
