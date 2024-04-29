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


    public static Block stoneWall = new Wall("stoneWall");
    public static Block darkStoneWall = new Wall("darkStoneWall");
    public static Block air = new AirBlock("air");
    public Block sandStoneWall = new Wall("sandStoneWall");
    public Block iceWall = new Wall("iceWall");
    public Block saltWall = new Wall("saltWall");

    public static Block stoneFloor = new Floor("stoneFloor");
}
