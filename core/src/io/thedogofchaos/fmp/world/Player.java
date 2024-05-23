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

package io.thedogofchaos.fmp.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import io.thedogofchaos.fmp.Vars;
import io.thedogofchaos.fmp.content.Blocks;

import static io.thedogofchaos.fmp.screen.GameWorld.world;

public class Player {
    // TODO: fucking implement collision detection for gods sake
    // TODO: also make a proper sprite for the player
    public static Texture playerSprite;
    public static int movementSpeed = 50;
    public static int movementSpeedMultiplier = 2;

    private BodyDef playerBodyDef;
    public static Body playerBody;

    public Player() {
        playerSprite = new Texture(Gdx.files.internal("sprites/player_placeholder.png"));

        playerBodyDef = new BodyDef();
        playerBodyDef.type = BodyDef.BodyType.DynamicBody;
        playerBodyDef.fixedRotation = true;
        playerBodyDef.position.set(64*16,64*16); //initial player position

        playerBody = world.createBody(playerBodyDef);

        PolygonShape playerShape = new PolygonShape();
        playerShape.setAsBox(8,8);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = playerShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.75f;
        fixtureDef.restitution = 0f;

        Fixture fixture = playerBody.createFixture(fixtureDef);
        playerShape.dispose();
    }

}
