package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.Zen;
import ru.vgtrofimov.zengame.actors.GroupActor;
import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.ColorRGB;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Textures;

public class ZenStage extends StageParent implements InputProcessor {

    GroupActor groupActor;
    int countFrame;

    float radius;

    public ZenStage(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(zenScreen, viewport, camera, textures);

        countFrame = 0;
        groupActor = new GroupActor(this, textures);
        addActor(groupActor);
        radius = 10;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        countFrame += 1;
        if (countFrame > 10000) countFrame = 0;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Zen.log((int) screenX * GdxViewport.RATIO_HORIZONTAL + " " + (int) screenY * GdxViewport.RATIO_VERTICAL);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        radius = 10;
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        radius += 10 * Gdx.graphics.getDeltaTime();
        // int radius = 96;
//        screenX -= radius / 2;
//        screenY -= radius / 2;
        // Zen.log((int) (screenX * GdxViewport.RATIO_HORIZONTAL) + " " + (int) (screenY * GdxViewport.RATIO_VERTICAL));
        if (countFrame % 2 == 0) {
            groupActor.addActor(new ColorRGB(1, 1, 1, 1,
                    -0.1f, -0.02f, -0.5f, -0.1f),
                    (int) (screenX * GdxViewport.RATIO_HORIZONTAL),
                    (int) (screenY * GdxViewport.RATIO_VERTICAL),
                    (int) radius);
            groupActor.addActor(new ColorRGB(1, 1, 1, 1,
                            -0.1f, -0.02f, -0.5f, -0.1f),
                    (int) (screenX * GdxViewport.RATIO_HORIZONTAL),
                    (int) (Gdx.graphics.getHeight() * GdxViewport.RATIO_VERTICAL - screenY * GdxViewport.RATIO_VERTICAL),
                    (int) radius);

//            screenX -= radius;
//            screenY -= radius;
            groupActor.addActor(new ColorRGB(1, 1, 1, 1,
                            -0.1f, -0.02f, -0.5f, -0.1f),
                    (int) (Gdx.graphics.getWidth() * GdxViewport.RATIO_HORIZONTAL) - (int) (screenX * GdxViewport.RATIO_HORIZONTAL),

                    (int) (screenY * GdxViewport.RATIO_VERTICAL),
                    (int) radius);
            groupActor.addActor(new ColorRGB(1, 1, 1, 1,
                            -0.1f, -0.02f, -0.5f, -0.1f),
                    (int) (Gdx.graphics.getWidth() * GdxViewport.RATIO_HORIZONTAL) - (int) (screenX * GdxViewport.RATIO_HORIZONTAL),

                    (int) (Gdx.graphics.getHeight() * GdxViewport.RATIO_VERTICAL - screenY * GdxViewport.RATIO_VERTICAL),
                    (int) radius);
        }
        return super.touchDragged(screenX, screenY, pointer);
    }
}
