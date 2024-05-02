package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;

import java.util.ArrayList;

public class PlayerInputHandler extends InputAdapter {
    public static float velX = 0;
    public static float velY = 0;
    public static boolean isPlayerMoving;
    public ArrayList<Integer> currentKeys = new ArrayList<Integer>();

    @Override
    public boolean keyDown(int i) {
        if (i == Input.Keys.UP) {
            velY = 10.0f;
            currentKeys.add(Input.Keys.UP);
        }
        if (i == Input.Keys.DOWN) {
            velY = -10.0f;
            currentKeys.add(Input.Keys.DOWN);
        }
        if (i == Input.Keys.LEFT) {
            velX = -10.0f;
            currentKeys.add(Input.Keys.LEFT);
        }
        if (i == Input.Keys.RIGHT) {
            velX = 10.0f;
            currentKeys.add(Input.Keys.RIGHT);
        }
        if (i==Input.Keys.SPACE){
            WorldGenerator.GenerateWorld(64,64,3,"perlin");
            currentKeys.add(Input.Keys.SPACE);
        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        if (i == Input.Keys.UP) {
            velY = 0f;
            currentKeys.remove(Integer.valueOf(Input.Keys.UP));
        }
        if (i == Input.Keys.DOWN) {
            velY = -0f;
            currentKeys.remove(Integer.valueOf(Input.Keys.DOWN));
        }
        if (i == Input.Keys.LEFT) {
            velX = 0f;
            currentKeys.remove(Integer.valueOf(Input.Keys.LEFT));
        }
        if (i == Input.Keys.RIGHT) {
            velX = 0f;
            currentKeys.remove(Integer.valueOf(Input.Keys.RIGHT));
        }
        return true;
    }

}
