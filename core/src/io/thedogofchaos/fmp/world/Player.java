package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import io.thedogofchaos.fmp.input.PlayerState;
import io.thedogofchaos.fmp.screen.GameWorld;
import io.thedogofchaos.fmp.utils.Resources;

public class Player extends Actor {
    public static Texture playerSprite;
    public static int playerX;
    public static int playerY;
    public float speed = 5 * Resources.TILE_SIZE; // = 5 * 48
    private Vector2 currentVelocity = new Vector2(0, 0);
    Body body;

    public Player(Vector2 startPosition) {
        super();
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));
        setBounds(startPosition.x, startPosition.y, playerSprite.getWidth(), playerSprite.getHeight());

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(16, 16);

        body = GameWorld.world.createBody(bodyDef);
        body.setUserData(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        trackMovement(delta);
    }

    private void trackMovement(float delta) {
        // calculate how far the body has moved by multiplying the constant speed by how much time has elapsed
        float movement = delta * speed;

        // move the physical body by multiplying current velocity with the movement
        body.setLinearVelocity(currentVelocity.cpy().scl(movement));

        // move sprite by moving actor to the same coordinates as the physical body
        this.setPosition(body.getPosition().x - Resources.WORLD_TILE_SIZE / 2f, body.getPosition().y - Resources.WORLD_TILE_SIZE / 2f);
    }
    public void setStateAndVelocity(PlayerState newState, Vector2 newVelocity) {
        // Update our velocity and enact it on our physical body.
        currentVelocity = newVelocity;
        body.setLinearVelocity(currentVelocity);
    }
}
