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

package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.*;
import io.thedogofchaos.fmp.*;
import io.thedogofchaos.fmp.input.GameInputs;
import io.thedogofchaos.fmp.screen.GameWorld;

public class WorldTicker {
    public static void tickWorld(){
        Vars.mousePosX = Gdx.input.getX();
        Vars.mousePosY = Gdx.input.getY();
        GameInputs.isPlayerMoving = !GameInputs.currentKeys.isEmpty() || (GameInputs.velX==0 && GameInputs.velY==0);
        Player.playerBody.setLinearVelocity(GameInputs.velX * Player.movementSpeedMultiplier, GameInputs.velY * Player.movementSpeedMultiplier);

        GameWorld.world.step(1 / 60f, 6, 2);
    }
}
