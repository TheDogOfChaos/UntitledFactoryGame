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
