package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.Sound;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Setup;
import ru.vgtrofimov.zengame.settings.Textures;

public class StageParent extends Stage {
    ZenScreen zenScreen;
    OrthographicCamera camera;
    Textures textures;
    Setup setup;
    Sound sound;

    public StageParent(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Setup setup, Sound sound, Textures textures) {
        this.zenScreen = zenScreen;
        this.setViewport(viewport);
        this.camera = camera;
        this.setup = setup;
        this.sound = sound;
        this.textures = textures;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void resize(int width, int height) {
        camera.viewportWidth = GdxViewport.WORLD_WIDTH;
        camera.viewportHeight = GdxViewport.HEIGHT * (float) height / width;
        camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2, 0);
        camera.update();
    }

}