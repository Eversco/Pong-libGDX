package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Pong;

import static com.mygdx.game.MenuScreen.SCREEN_H;
import static com.mygdx.game.MenuScreen.SCREEN_W;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = SCREEN_H;
		config.width = SCREEN_W;
		config.resizable = false;
		new LwjglApplication(new Pong(), config);
	}
}
