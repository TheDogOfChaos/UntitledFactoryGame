/* Note: This class defines all the player-made buildings that have extended data
    (i.e. more than just hp and location data).
    This extended data may or may not be stored with Named Binary Tags (NBT) in future.
*/

package io.thedogofchaos.fmp.world.blocks.playermade;

import dev.dewy.nbt.tags.collection.CompoundTag;

public class DynamicBuilding extends PlayerBuilding{
    public static CompoundTag dynamicBuildingData; // Note: I may or may not use NBT.
    public DynamicBuilding(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
        isDynamic = true;
    }
}
