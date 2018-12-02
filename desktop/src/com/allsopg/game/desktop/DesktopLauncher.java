package com.allsopg.game.desktop;

import com.allsopg.game.BasicAnimation;
import com.allsopg.game.SoundEffect;
import com.allsopg.game.SpriteExample;
import com.allsopg.game.SpriteExample_2;
import com.allsopg.game.SpriteExample_3;
import com.allsopg.game.TestTweenAnimation;
import com.allsopg.game.ViewPortExample;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config =
				new LwjglApplicationConfiguration();
/*
		TexturePacker.process("../assets/gfx/ball",
				"../assets/texture_atlas",
				"ball_assets");
*/
		new LwjglApplication(new TestTweenAnimation(), config);
	}
}
