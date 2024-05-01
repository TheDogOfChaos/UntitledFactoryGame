package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Block;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;

import java.util.HashMap;

public class PlayerInputHandler extends InputAdapter {
    public static boolean isPlayerMoving;

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
            case Input.Keys.SPACE -> WorldGenerator.GenerateWorld(64,64,2,"perlin");
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
            if (moveRight) {
                Player.playerPos.add(1,0);
            }
            if (moveLeft) {
                Player.playerPos.add(-1,0);
            }
            if (moveUp){
                Player.playerPos.add(0,1);
            }
            if (moveDown) {
                Player.playerPos.add(0,-1);
            }
            checkPlayerCollision();
            Player.playerX = (int) Player.playerPos.x;
            Player.playerY = (int) Player.playerPos.y;
        }
    }
    public static void checkPlayerCollision() {
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                if (Player.bounds.overlaps(Vars.mapData[1][x][y].bounds)) {
                    Gdx.app.log("INFO", "Collision Detected!");
                }
            }
        }
    }
}
