package io.thedogofchaos.fmp.world.blocks.playermade;

import io.thedogofchaos.fmp.world.blocks.environment.*;

public class PlayerBuilding extends Wall{
    public PlayerBuilding(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
        canBeBroken = true;
    }
}

