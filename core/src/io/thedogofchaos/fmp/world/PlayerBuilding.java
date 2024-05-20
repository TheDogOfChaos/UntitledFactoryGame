package io.thedogofchaos.fmp.world;

import io.thedogofchaos.fmp.world.environment.blocks.*;

public class PlayerBuilding extends Wall{
    public PlayerBuilding(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
        canBeBroken = true;
    }
}
