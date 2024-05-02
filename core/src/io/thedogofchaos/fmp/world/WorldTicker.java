package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.input.PlayerInputHandler;
import io.thedogofchaos.fmp.screen.GameWorld;

public class WorldTicker {
    public static void tickWorld() {
        Player.playerBody.setLinearVelocity(PlayerInputHandler.velX, PlayerInputHandler.velY);
        GameWorld.world.step(1/60f, 6, 2);
    }
}
