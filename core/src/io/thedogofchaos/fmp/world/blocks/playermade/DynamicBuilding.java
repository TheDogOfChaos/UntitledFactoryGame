/*
	Copyright (c) 2024 TheDogOfChaos

 	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

// Note: This class defines all the player-made buildings that have extended data
//  (i.e. more than just hp and location data).
//  This extended data may or may not be stored with Named Binary Tags (NBT) in future.

package io.thedogofchaos.fmp.world.blocks.playermade;

import com.badlogic.gdx.math.*;
import dev.dewy.nbt.tags.collection.CompoundTag;

public class DynamicBuilding extends PlayerBuilding{
    public static CompoundTag dynamicBuildingData; // Note: I may or may not use NBT.
    public DynamicBuilding(String name, int blockWidth, int blockHeight, Vector2 blockInGamePos){
        super(name, blockWidth, blockHeight, blockInGamePos);
        isDynamic = true;
    }
}
