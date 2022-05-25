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

        if (countFrame % 1 == 0) {
            addUnit(screenX, screenY, 3);
        }
        return super.touchDragged(screenX, screenY, pointer);
    }

    public void addUnit(int x, int y, int count) {
        radius += 2 * Gdx.graphics.getDeltaTime();
        if (radius > 128) radius = 128;

        switch (count) {
            case 3:
                groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                                -0.1f, -0.02f, -0.5f, -0.11f),
                        (int) (x * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) (y * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count);
                addUnit(x, y, count - 1);
                break;
            case 2:
                groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                                -0.3f, -0.01f, -0.1f, -0.1f),
                        (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) (y * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count);
                addUnit(x, y, count - 1);
                break;
            case 1:
                groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                                -0.4f, -0.1f, -0.1f, -0.09f),
                        (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count);
                addUnit(x, y, count - 1);
                break;
            case 0:
                groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                                -0.05f, -0.01f, -0.03f, -0.08f),
                        (int) (x * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count);
                addUnit(x, y, count - 1);
                break;
            case -1:
                addSinCos(x, y, 7);
                break;
        }
        addSinCos(x, y, 7);
    }

    public void addSinCos(int x, int y, int count) {
        if (count == 7) {
            int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL - radius);
            int thisY = (int) (y * GdxViewport.RATIO_VERTICAL - radius);
            Zen.log("" + Math.sin(thisX));
            groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                            -0.4f, -0.1f, -0.1f, -0.09f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 7,
                    count);
            addSinCos(x, y, count - 1);
        } else if (count == 6) {
            int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL - radius);
            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius);
            Zen.log("" + Math.sin(thisX));
            groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                            -0.4f, -0.1f, -0.1f, -0.09f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 7,
                    count);
            addSinCos(x, y, count - 1);
        } else if (count == 5) {
            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius);
            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius);
            Zen.log("" + Math.sin(thisX));
            groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                            -0.4f, -0.1f, -0.1f, -0.09f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 7,
                    count);
            addSinCos(x, y, count - 1);
        } else if (count == 4) {
            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius);
            int thisY = (int) (y * GdxViewport.RATIO_VERTICAL - radius);
            Zen.log("" + Math.sin(thisX));
            groupActor.addUnit(new ColorRGB(1, 1, 1, 1,
                            -0.4f, -0.1f, -0.1f, -0.09f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 7,
                    count);
            addSinCos(x, y, count - 1);
        }
    }
}
