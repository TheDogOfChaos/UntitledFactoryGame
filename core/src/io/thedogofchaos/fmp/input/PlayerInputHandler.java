package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Block;
import io.thedogofchaos.fmp.world.Player;
import io.thedogofchaos.fmp.world.WorldGenerator;

import java.util.HashMap;

public class PlayerInputHandler extends InputAdapter {
    private static final float MAX_VELOCITY = 5;
    public static boolean isPlayerMoving;
    Vector2 vel = Player.playerBody.getLinearVelocity();
    Vector2 pos = Player.playerBody.getPosition();
    @Override
    public boolean keyDown(int i) {
        isPlayerMoving = true;

        if ((i == Input.Keys.LEFT) && vel.x > -MAX_VELOCITY) {
            Player.playerBody.applyLinearImpulse(-0.80f, 0, pos.x, pos.y, true);
        }
        if ((i == Input.Keys.RIGHT) && vel.x < MAX_VELOCITY) {
            Player.playerBody.applyLinearImpulse(0.80f, 0, pos.x, pos.y, true);
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        isPlayerMoving = (i != 0);
        return false;
    }

}
