package io.thedogofchaos.fmp.content;

import io.thedogofchaos.fmp.world.*;
import io.thedogofchaos.fmp.world.environment.AirBlock;
import io.thedogofchaos.fmp.world.environment.blocks.Floor;
import io.thedogofchaos.fmp.world.environment.blocks.Wall;

public class Blocks {
//    // environment
//    air, water,
//    //natural walls
//    stoneWall, darkStoneWall, sandStoneWall, iceWall, saltWall,
//    //natural floors
//    stoneFloor, sandStoneFloor, iceFloor, saltFloor

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

    public static Block[] playerBlockList = {};
    public static Block[] naturalBlockList = {air, stoneWall, darkStoneWall, sandStoneWall, iceWall, saltWall};
}
