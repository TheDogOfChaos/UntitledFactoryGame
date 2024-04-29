package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Player {
    // TODO: fucking implement collision detection for gods sake
    public static Texture playerSprite;
    public static Vector2 playerPos;
    public static int playerX;
    public static int playerY;
    public static Rectangle bounds;

    public Player() {
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));
        playerPos = new Vector2(playerX,playerY);
        playerPos.clamp(0,1);
        bounds = new Rectangle(playerX, playerY, playerSprite.getWidth(), playerSprite.getHeight());
        // TODO: also make a proper sprite for the player
    }
}
