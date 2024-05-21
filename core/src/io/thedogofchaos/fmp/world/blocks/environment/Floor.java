package io.thedogofchaos.fmp.world.blocks.environment;

import io.thedogofchaos.fmp.world.blocks.Block;

public class Floor extends Block {
    public Floor(String name) {
        super(name,1,1);
        canBePlacedOn = true;
        canBeWalkedOn = true;
    }
}
