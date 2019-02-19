package utility;

import com.badlogic.gdx.graphics.Color;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.*;

public class Constants {
    public static final float CAMERASPEED = 1;
    public static final float WORLD_WIDTH = 640;
    public static final float WORLD_HEIGHT = 480;
    public static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    public static final float FRAME_DURATION = 1.0f/15.0f;
    public static final String SIZE = "data/smallSize.png";
    public static final String RADIOACTIVE_ATLAS = "texture_atlas/radioactive_assets.atlas";
    public static final String EXPLODE_ATLAS = "texture_atlas/explode_assets.atlas";

    public static final String BALL_ATLAS = "texture_atlas/ball_assets.atlas";
    public static final String fontPath = "font/chalkduster.fnt";

    public static final Map<String, String> LEVEL_SOUNDS =
            Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("back", "sfx/back.ogg");
            put("diamond", "sfx/diamond.ogg");
            put("jump", "sfx/jump.ogg");
            put("bounce", "sfx/bounce.ogg");
        }
    });
}