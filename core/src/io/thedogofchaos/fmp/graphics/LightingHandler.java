package io.thedogofchaos.fmp.graphics;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Disposable;
import io.thedogofchaos.fmp.screen.GameWorld;

import static io.thedogofchaos.fmp.UntitledFactoryGame.*;

public class LightingHandler implements Disposable {
    public static void initLighting() {
        rayHandler = new RayHandler(GameWorld.world);
        rayHandler.setAmbientLight(0.1f, 0.1f, 0.1f, 1f);
        rayHandler.setBlurNum(3);
        PointLight pl = new PointLight(rayHandler, 128, new Color(0.2f,1,1,1f), 10,-5,2);
        PointLight pl2 = new PointLight(rayHandler, 128, new Color(1,0,1,1f), 10,5,2);

        rayHandler.setShadows(true);
        pl.setStaticLight(false);
        pl.setSoft(true);
    }
    @Override
    public void dispose() {

    }
}
