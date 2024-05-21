package io.thedogofchaos.fmp.world.blocks.environment;

import io.thedogofchaos.fmp.world.blocks.Block;

public class Wall extends Block {
    public Wall(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
        canBeBroken = false;
        canBeWalkedOn = false;
    }
}
