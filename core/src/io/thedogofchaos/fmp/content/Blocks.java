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

package io.thedogofchaos.fmp.content;

import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.Array;
import io.thedogofchaos.fmp.world.blocks.*;
import io.thedogofchaos.fmp.world.blocks.environment.Floor;
import io.thedogofchaos.fmp.world.blocks.environment.Wall;
import io.thedogofchaos.fmp.world.blocks.playermade.*;

import java.lang.reflect.*;
import java.util.*;

public class Blocks {

    public static Block air = new AirBlock("air");

    public static Block stoneWall = new Wall("stoneWall",2,2);
    public static Block darkStoneWall = new Wall("darkStoneWall",2,2);
    public static Block sandStoneWall = new Wall("sandStoneWall",2,2);
    public static Block iceWall = new Wall("iceWall",2,2);
    public static Block saltWall = new Wall("saltWall",2,2);

    public static Block stoneFloor = new Floor("stoneFloor");

    public static Block drill = new PlayerBuilding("drill",2,2);
    public static Block furnace = new PlayerBuilding("furnace",2,2);
    public static Block conveyor = new PlayerBuilding("conveyor",1,1);
    public static Block vault = new PlayerBuilding("vault",3,3);
    public static Block core = new PlayerBuilding("core",4,4);

    public static ArrayList<Blocks> getAllBlocks() {
        ArrayList<Blocks> blocksArray = new ArrayList<>();

        Field[] fields = Blocks.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getType().equals(Blocks.class)) {
                    Blocks block = (Blocks) field.get(null);
                    blocksArray.add(block);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return blocksArray;
    }
}
