package io.thedogofchaos.fmp.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class TiledObjectsUtil {
    public static Body createBox(World world, float x, float y, float width, float height, boolean isStatic) {
        BodyDef def = new BodyDef();  // a description of all the physical aspects of the body (e.g. solid vs. dynamic, etc.)
        if (isStatic) {
            def.type = BodyDef.BodyType.StaticBody;
        } else {
            def.type = BodyDef.BodyType.DynamicBody;  // non-zero velocity
        }
        def.position.set(x, y);
        def.fixedRotation = true;  // true --> will not be rotating when impacted by other bodies
        Body pBody = world.createBody(def);  // initialises body, puts it into world with def physical properties.

        // give a shape to pBody enttiy
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2f, height/2f);  // expands out from the "center", meaning that it's actually double that for width and height. So if  you set only 32, it'll be 64 wide
        pBody.createFixture(shape, 1f);
        shape.dispose(); // keep it clean!

        return pBody;
    }
}
