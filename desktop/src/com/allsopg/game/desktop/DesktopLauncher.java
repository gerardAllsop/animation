package com.allsopg.game.desktop;

import com.allsopg.game.ViewPortExample;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//TexturePacker.process("../assets/gfx","../assets/texture_atlas","ring_assets");
		new LwjglApplication(new ViewPortExample(), config);
	}
}
