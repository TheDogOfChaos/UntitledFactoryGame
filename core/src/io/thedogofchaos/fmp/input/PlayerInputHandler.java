package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import io.thedogofchaos.fmp.world.Player;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputHandler implements InputProcessor {
    private final Set<Integer> pressedKeyCodes = new HashSet<>();
    private Player player;

    public void FreeRoamingMovementListener(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        pressedKeyCodes.add(keycode);

        // Step 1: Determining the state.
        PlayerState state = getPlayerStateBasedOnCurrentlyPressedKeys();
        if (state == null) {
            pressedKeyCodes.remove(keycode);
            return false;
        }

        // Step 2: Translate the direction the player is facing into velocity.
        Vector2 newVelocity = state.calculateDirectionVector();

        // Step 3: Update velocity & state in `Player`.
        player.setStateAndVelocity(state, newVelocity);

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        pressedKeyCodes.remove(keycode);

        // Step 1: Determining the state.
        PlayerState state = getPlayerStateBasedOnCurrentlyPressedKeys();

        // Step 2: Translate the state of player into velocity or default to Vector2.Zero.
        Vector2 newVelocity = Vector2.Zero;
        if (state != null) {
            newVelocity = state.calculateDirectionVector();
        }

        // Step 3: Update velocity & state in `Player`.
        updatePlayerState(state, newVelocity);

        return true;
    }

    private PlayerState getPlayerStateBasedOnCurrentlyPressedKeys() {
        // get sprite based on walking direction
        if (pressedKeyCodes.contains(Input.Keys.UP)) {
            if (pressedKeyCodes.contains(Input.Keys.RIGHT)) {
                return PlayerState.WALKING_NE;
            } else if (pressedKeyCodes.contains(Input.Keys.LEFT)) {
                return PlayerState.WALKING_NW;
            } else {
                return PlayerState.WALKING_N;
            }
        } else if (pressedKeyCodes.contains(Input.Keys.DOWN)) {
            if (pressedKeyCodes.contains(Input.Keys.RIGHT)) {
                return PlayerState.WALKING_SE;
            } else if (pressedKeyCodes.contains(Input.Keys.LEFT)) {
                return PlayerState.WALKING_SW;
            } else {
                return PlayerState.WALKING_S;
            }
        } else if (pressedKeyCodes.contains(Input.Keys.RIGHT)) {
            return PlayerState.WALKING_E;
        } else if (pressedKeyCodes.contains(Input.Keys.LEFT)) {
            return PlayerState.WALKING_W;
        } else {
            return null;
        }
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
}
