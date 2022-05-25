package ru.vgtrofimov.zengame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);

		int width = 1200, height = 2640;
		float ratio = 0.35f;

		config.setWindowedMode((int) (width * ratio), (int) (height * ratio));

		config.setTitle("Zen Game");
		new Lwjgl3Application(new Zen(), config);
	}
}
