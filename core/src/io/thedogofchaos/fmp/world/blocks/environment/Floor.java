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

package io.thedogofchaos.fmp.world.blocks.environment;

import com.badlogic.gdx.math.*;
import io.thedogofchaos.fmp.world.blocks.Block;

public class Floor extends Block {
    public Floor(String name, Vector2 blockInGamePos) {
        super(name,1,1, blockInGamePos);
        isPlaceableOn = true;
        isWalkableOn = true;
    }
}
