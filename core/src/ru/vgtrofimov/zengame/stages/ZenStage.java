package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.Zen;
import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Textures;

public class ZenStage extends StageParent implements InputProcessor {

    public ZenStage(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(zenScreen, viewport, camera, textures);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Zen.log((int) screenX * GdxViewport.RATIO_HORIZONTAL + " " + (int) screenY * GdxViewport.RATIO_VERTICAL);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Zen.log((int) (screenX * GdxViewport.RATIO_HORIZONTAL) + " " + (int) (screenY * GdxViewport.RATIO_VERTICAL));
        return super.touchDragged(screenX, screenY, pointer);
    }
}
