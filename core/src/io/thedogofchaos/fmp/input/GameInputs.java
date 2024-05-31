/*
	Copyright (c) 2024 TheDogOfChaos

 	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.*;
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
        if ((i == Input.Keys.W)||(i == Input.Keys.UP)) {
            velY += Player.movementSpeed;
        }
        if ((i == Input.Keys.S)||(i == Input.Keys.DOWN)) {
            velY -= Player.movementSpeed;
        }
        if ((i == Input.Keys.A)||(i == Input.Keys.LEFT)) {
            velX -= Player.movementSpeed;
        }
        if ((i == Input.Keys.D)||(i == Input.Keys.RIGHT)) {
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
        if ((i == Input.Keys.W)||(i == Input.Keys.UP)) {
            velY -= Player.movementSpeed;
        }
        if ((i == Input.Keys.S)||(i == Input.Keys.DOWN)) {
            velY += Player.movementSpeed;
        }
        if ((i == Input.Keys.A)||(i == Input.Keys.LEFT)) {
            velX += Player.movementSpeed;
        }
        if ((i == Input.Keys.D)||(i == Input.Keys.RIGHT)) {
            velX -= Player.movementSpeed;
        }
        currentKeys.remove(Integer.valueOf(i));
        return true;
    }

    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("GameInputs", screenX+", "+screenY+", "+pointer+", "+button);
        return false;
    }
}
