package ru.vgtrofimov.zengame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.Sound;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Setup;
import ru.vgtrofimov.zengame.settings.Textures;

public class Zen extends ApplicationAdapter {

	private OrthographicCamera camera;
	private Viewport viewport;

	ZenScreen zenScreen;
	Textures textures;
	Setup setup;
	Sound sound;
	// private AssetManager manager;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_HEIGHT);
		GdxViewport.HEIGHT = GdxViewport.WORLD_WIDTH * ((float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		viewport = new FillViewport(GdxViewport.WORLD_WIDTH, GdxViewport.HEIGHT, camera);

		setup = new Setup();
		sound = new Sound(setup);

		textures = new Textures();

		zenScreen = new ZenScreen(viewport, camera, setup, sound, textures);
	}

	public static void log(String nameClass, String msg) {
		Gdx.app.log(Setup.APP_ID, nameClass + ": " + msg);
	}

	public static void log(String msg) {
		Gdx.app.log(Setup.APP_ID, "NO CLASS: " + msg);
	}

	@Override
	public void render () {
		if (!Setup.pause) {
			ScreenUtils.clear(0, 0, 0, 1);
			zenScreen.render(Gdx.graphics.getDeltaTime());
		}
	}
	
	@Override
	public void dispose () {
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
		GdxViewport.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
		setup.savePrefs();
	}
}
