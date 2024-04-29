package io.thedogofchaos.fmp.world.environment.blocks;

import io.thedogofchaos.fmp.world.Block;

public class Wall extends Block {
    public Wall(String name){
        super(name);
        canBeBroken = false;
        canBeWalkedOn = false;
    }
}
