package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.input.InputHandler;
import io.thedogofchaos.fmp.screen.GameWorld;

public class WorldTicker {
    public static void tickWorld(){
        InputHandler.isPlayerMoving = !InputHandler.currentKeys.isEmpty() || (InputHandler.velX==0 && InputHandler.velY==0);
        Player.playerBody.setLinearVelocity(InputHandler.velX * Player.movementSpeedMultiplier, InputHandler.velY * Player.movementSpeedMultiplier);

        GameWorld.world.step(1 / 60f, 6, 2);
    }
}
