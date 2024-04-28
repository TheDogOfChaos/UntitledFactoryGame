package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Player;

import java.util.HashMap;

public class PlayerInputHandler extends InputAdapter {
    public static boolean isPlayerMoving;
    public static int playerMoveSpeed = 2;

    private static boolean moveUp;
    private static boolean moveDown;
    private static boolean moveLeft;
    private static boolean moveRight;

    @Override
    public boolean keyDown(int i) {
        isPlayerMoving = true;
        switch (i) {
            case Input.Keys.UP -> moveUp = true;
            case Input.Keys.DOWN -> moveDown = true;
            case Input.Keys.LEFT -> moveLeft = true;
            case Input.Keys.RIGHT -> moveRight = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        isPlayerMoving = (i != 0);
        switch (i) {
            case Input.Keys.UP -> moveUp = false;
            case Input.Keys.DOWN -> moveDown = false;
            case Input.Keys.LEFT -> moveLeft = false;
            case Input.Keys.RIGHT -> moveRight = false;
        }
        return false;
    }

    public static void tickPlayerMovement(){
        // NOTE: There has gotta be a better way of doing this.
        if (isPlayerMoving) {
            float deltaX = 0;
            float deltaY = 0;
            if (moveRight) {
                deltaX = 1;
            }
            if (moveLeft) {
                deltaX = -1;
            }
            if (moveUp){
                deltaY = 1;
            }
            if (moveDown) {
                deltaY = -1;
            }
            if (moveUp&&moveRight) {
                deltaX = 0.70710678118F;
                deltaY = 0.70710678118F;
            }
            if (moveRight&&moveDown) {
                deltaX = 0.70710678118F;
                deltaY = -0.70710678118F;
            }
            if (moveDown&&moveLeft) {
                deltaX = -0.70710678118F;
                deltaY = -0.70710678118F;
            }
            if (moveLeft&&moveUp) {
                deltaX = -0.70710678118F;
                deltaY = 0.70710678118F;
            }
            Player.playerX += (deltaX*playerMoveSpeed);
            Player.playerY += (deltaY*playerMoveSpeed);
        }
    }
    public static void checkPlayerMovementValidity() {
        int x = Player.playerX;
        int y = Player.playerY;

        if (Vars.mapData[1][x/16][y/16] == "stoneWall"){
            Gdx.app.log("WARN", "Player in wall at: "+x/16+", "+y/16);
        }
    }
}
