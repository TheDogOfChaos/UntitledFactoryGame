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

package io.thedogofchaos.fmp.world.blocks;

import com.badlogic.gdx.math.*;
import io.thedogofchaos.fmp.world.blocks.environment.*;

public class AirBlock extends Floor{
    public AirBlock(String name, Vector2 blockInGamePos) {
        super(name, blockInGamePos);
        isNatural = true;
        isBreakable = false;
        isSolid = false;
    }
}
