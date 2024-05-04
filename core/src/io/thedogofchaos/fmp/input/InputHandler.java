package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;

import java.util.ArrayList;

public class InputHandler extends InputAdapter {
    public static float velX = 0;
    public static float velY = 0;
    public static boolean isPlayerMoving;
    public static ArrayList<Integer> currentKeys = new ArrayList<Integer>();

    @Override
    public boolean keyDown(int i) {
        if (i == Input.Keys.UP) {
            velY += Player.movementSpeed;
        }
        if (i == Input.Keys.DOWN) {
            velY -= Player.movementSpeed;
        }
        if (i == Input.Keys.LEFT) {
            velX -= Player.movementSpeed;
        }
        if (i == Input.Keys.RIGHT) {
            velX += Player.movementSpeed;
        }

        if (i==Input.Keys.F3){
            Vars.debugMode = !Vars.debugMode;
        }
        currentKeys.add(i);
        isPlayerMoving = !currentKeys.isEmpty();
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        if (i == Input.Keys.UP) {
            velY -= Player.movementSpeed;
        }
        if (i == Input.Keys.DOWN) {
            velY += Player.movementSpeed;
        }
        if (i == Input.Keys.LEFT) {
            velX += Player.movementSpeed;
        }
        if (i == Input.Keys.RIGHT) {
            velX -= Player.movementSpeed;
        }

        currentKeys.remove(Integer.valueOf(i));
        isPlayerMoving = !currentKeys.isEmpty();
        return true;
    }
}
