package io.thedogofchaos.fmp.fragment;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.world.Block;
import io.thedogofchaos.fmp.content.Blocks;

public class BuildMenuFragment implements Disposable {
    public static Table buildMenuTable;
    public BuildMenuFragment(){
        buildMenuTable = new Table();
        buildMenuTable.setFillParent(true);
        buildMenuTable.setDebug(Vars.ultimateDebugMode || Vars.stageDebugMode);
        buildMenuTable.bottom();
    }

    public void show(){
        for (Block v: Blocks.blockList){
            
        }
    }

    @Override
    public void dispose() {

    }
}
