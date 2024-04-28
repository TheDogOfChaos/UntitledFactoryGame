package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Player {
    // TODO: fucking implement collision detection for gods sake
    public static Texture playerSprite;
    public static int playerX;
    public static int playerY;

    public Player() {
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));
        // TODO: also make a proper sprite for the player
    }




}
