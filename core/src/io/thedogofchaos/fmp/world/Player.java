package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Player {
    // TODO: fucking implement collision detection for gods sake
    // TODO: also make a proper sprite for the player
    public static Texture playerSprite;
    public static int playerX = 32;
    public static int playerY = 32;

    private BodyDef playerBodyDef;
    public static Body playerBody;

    public Player() {
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));

        playerBodyDef = new BodyDef();
        playerBodyDef.type = BodyDef.BodyType.DynamicBody;
        playerBodyDef.position.set(32, 32);

        playerBody = world.createBody(playerBodyDef);

        PolygonShape playerShape = new PolygonShape();
        playerShape.setAsBox(16,16);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = playerShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0f;

        Fixture fixture = playerBody.createFixture(fixtureDef);
        playerShape.dispose();
    }
}
