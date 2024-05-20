package io.thedogofchaos.fmp.world.environment.blocks;

import io.thedogofchaos.fmp.world.Block;

public class Floor extends Block {
    public Floor(String name) {
        super(name,1,1);
        canBePlacedOn = true;
        canBeWalkedOn = true;
    }
}
