package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    public static Actor player;
    public Texture playerSprite;

    public enum PlayerState {}
    public enum PlayerMovement {NONE, NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST}

    public Player(Vector2 startPos) {
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));
        setBounds(startPos.x, startPos.y, 16,16);
    }
}
