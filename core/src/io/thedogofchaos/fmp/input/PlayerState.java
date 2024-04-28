package io.thedogofchaos.fmp.input;

import com.badlogic.gdx.math.Vector2;

public enum PlayerState {
    STANDING_S, STANDING_N, STANDING_E, STANDING_W,
    WALKING_S, WALKING_N, WALKING_E, WALKING_W, WALKING_NE, WALKING_SE, WALKING_SW, WALKING_NW,
    SITTING_W,
    PICKUP_S, PICKUP_N, PICKUP_E, PICKUP_W,
    HOLD_S,
    ;

    private static final float ONE_ON_ROOT_TWO = (float) (1.0 / Math.sqrt(2));

    public Vector2 calculateDirectionVector() {
        return switch (this) {
            case WALKING_N, STANDING_N -> new Vector2(0, 1);
            case WALKING_S, STANDING_S -> new Vector2(0, -1);
            case WALKING_E, STANDING_E -> new Vector2(1, 0);
            case WALKING_W, STANDING_W -> new Vector2(-1, 0);
            case WALKING_NE -> new Vector2(ONE_ON_ROOT_TWO, ONE_ON_ROOT_TWO);
            case WALKING_NW -> new Vector2(-ONE_ON_ROOT_TWO, ONE_ON_ROOT_TWO);
            case WALKING_SE -> new Vector2(ONE_ON_ROOT_TWO, -ONE_ON_ROOT_TWO);
            case WALKING_SW -> new Vector2(-ONE_ON_ROOT_TWO, -ONE_ON_ROOT_TWO);
            case SITTING_W, HOLD_S, PICKUP_S, PICKUP_E, PICKUP_W, PICKUP_N -> new Vector2(0, 0);
            default -> throw new IllegalArgumentException();
        };
    }
}
