package io.thedogofchaos.fmp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import io.thedogofchaos.fmp.world.blocks.Block;

public class Vars {
    // This class contains all the values that are repeatedly used by my game, and aren't specific to a block.
    public static int mapWidth;
    public static int mapHeight;
    public static Block[][] mapFloor;
    public static Block[][] mapWall;

    public static TextureAtlas worldAtlas = new TextureAtlas(Gdx.files.internal("sprites/atlas/tileAtlas.atlas"));
    public static Skin skin = new Skin(Gdx.files.internal("ui/metal-ui/metal-ui.json"));

    public static boolean ultimateDebugMode = false; // For when I really fuck things up. Enables debug mode on basically everything.
    public static boolean ingameDebugInfo = false; // Enables debug information. Flipped in GameInputs.java by pressing the F3 key.
    public static boolean stageDebugMode = true; // Enables the debug view of Stages.
}
