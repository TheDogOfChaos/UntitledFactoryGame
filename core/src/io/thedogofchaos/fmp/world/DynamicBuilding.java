package io.thedogofchaos.fmp.world;

import dev.dewy.nbt.Nbt;
import dev.dewy.nbt.tags.collection.CompoundTag;
import dev.dewy.nbt.tags.primitive.StringTag;

public class DynamicBuilding extends PlayerBuilding {
    public static CompoundTag buildingData;
    public DynamicBuilding(String name, int blockWidth, int blockHeight){
        super(name, blockWidth, blockHeight);
    }
}
