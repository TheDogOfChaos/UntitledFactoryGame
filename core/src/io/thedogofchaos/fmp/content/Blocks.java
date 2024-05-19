package io.thedogofchaos.fmp.content;

import io.thedogofchaos.fmp.world.environment.AirBlock;
import io.thedogofchaos.fmp.world.Block;
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

    public static Block stoneWall = new Wall("stoneWall");
    public static Block darkStoneWall = new Wall("darkStoneWall");
    public static Block sandStoneWall = new Wall("sandStoneWall");
    public static Block iceWall = new Wall("iceWall");
    public static Block saltWall = new Wall("saltWall");

    public static Block stoneFloor = new Floor("stoneFloor");

    public static Block[] playerBlockList = {};
    public static Block[] naturalBlockList = {air, stoneWall, darkStoneWall, sandStoneWall, iceWall, saltWall};
}
