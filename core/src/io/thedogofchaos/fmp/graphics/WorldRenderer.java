package io.thedogofchaos.fmp.graphics;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;


// TODO: Implement this shit.
public class WorldRenderer implements Disposable {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    public void RenderWorld(){
        ScreenUtils.clear(0,0,0, 1f);
        camera.update();
        batch.begin();
        for (int x = 0; x < Vars.mapWidth; x++) {
            for (int y = 0; y < Vars.mapHeight; y++) {
                if (Vars.mapFloor[x][y] == Blocks.stoneFloor) {
                    batch.draw(Vars.worldAtlas.findRegion("stoneFloor"), x * 16, y * 16);
                }
                if (Vars.mapWall[x][y] == Blocks.stoneWall) {
                    batch.draw(Vars.worldAtlas.findRegion("stoneWall"), x * 16, y * 16);
                }
                if (Vars.mapWall[x][y] == Blocks.darkStoneWall) {
                    batch.draw(Vars.worldAtlas.findRegion("darkStoneWall"), x * 16, y * 16);
                }
                if (Vars.mapWall[x][y] == Blocks.air) {
                    batch.draw(Vars.worldAtlas.findRegion("air"), x * 16, y * 16);
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
