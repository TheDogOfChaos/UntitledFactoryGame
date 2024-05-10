package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Player;

import java.util.ArrayList;

public class GameInputs extends InputAdapter {
    public static float velX = 0;
    public static float velY = 0;
    public static boolean isPlayerMoving;
    public static ArrayList<Integer> currentKeys = new ArrayList<Integer>();

    @Override
    public boolean keyDown(int i) {
        if (i == Input.Keys.W) {
            velY += Player.movementSpeed;
        }
        if (i == Input.Keys.S) {
            velY -= Player.movementSpeed;
        }
        if (i == Input.Keys.A) {
            velX -= Player.movementSpeed;
        }
        if (i == Input.Keys.D) {
            velX += Player.movementSpeed;
        }
        if (i==Input.Keys.Q){
            // this will cycle the build menu left
        }
        if (i==Input.Keys.E){
            // this will cycle the build menu right
        }
        if (i == Input.Keys.R) { // debug respawn key until i implement better player spawning
            Player.playerBody.setTransform(new Vector2((float) ((Math.random()*Vars.mapWidth)*16), (float) ((Math.random()* Vars.mapHeight)*16)), Player.playerBody.getAngle());
        }
        if (i==Input.Keys.F3){
            Vars.ingameDebugInfo = !Vars.ingameDebugInfo;
        }
        currentKeys.add(i);
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
        return true;
    }

    @Override
    public boolean mouseMoved (int x, int y) {
        return false;
    }
}
