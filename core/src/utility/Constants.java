package utility;

import com.badlogic.gdx.graphics.Color;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.*;

public class Constants {
    public static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    public static final String SIZE = "data/smallSize.png";
    public static final String SAW_ATLAS = "texture_atlas/saw_assets.atlas";
    public static final String BALL_ATLAS = "texture_atlas/ball_assets.atlas";

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