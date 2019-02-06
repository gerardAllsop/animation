package com.allsopg.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import TBW.TBWGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config =
				new LwjglApplicationConfiguration();
/*
		TexturePacker.process("../assets/gfx/explode",
				"../assets/texture_atlas",
				"explode_assets");
*/
		new LwjglApplication(new TBWGame(), config);
	}
}
