package com.allsopg.game.desktop;

import com.allsopg.game.BasicAnimation;
import com.allsopg.game.SpriteExample;
import com.allsopg.game.SpriteExample_2;
import com.allsopg.game.SpriteExample_3;
import com.allsopg.game.ViewPortExample;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//TexturePacker.process("../assets/gfx/imgSaw","../assets/texture_atlas","ring_assets");
		new LwjglApplication(new SpriteExample_3(), config);
	}
}
