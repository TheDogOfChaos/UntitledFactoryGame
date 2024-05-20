package io.thedogofchaos.fmp.world.environment.blocks;

import com.badlogic.gdx.math.Rectangle;
import io.thedogofchaos.fmp.world.Block;

public class Wall extends Block {
    public Wall(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
        canBeBroken = false;
        canBeWalkedOn = false;
    }

}
