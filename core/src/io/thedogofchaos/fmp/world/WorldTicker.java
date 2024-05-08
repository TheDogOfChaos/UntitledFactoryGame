package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.input.GameInputs;
import io.thedogofchaos.fmp.screen.GameWorld;

public class WorldTicker {
    public static void tickWorld(){
        GameInputs.isPlayerMoving = !GameInputs.currentKeys.isEmpty() || (GameInputs.velX==0 && GameInputs.velY==0);
        Player.playerBody.setLinearVelocity(GameInputs.velX * Player.movementSpeedMultiplier, GameInputs.velY * Player.movementSpeedMultiplier);

        GameWorld.world.step(1 / 60f, 6, 2);
    }
}
