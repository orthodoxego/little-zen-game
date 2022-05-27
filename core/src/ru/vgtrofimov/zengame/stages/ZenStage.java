package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.Zen;
import ru.vgtrofimov.zengame.actors.GroupActor;
import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.ColorRGB;
import ru.vgtrofimov.zengame.services.Sound;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Setup;
import ru.vgtrofimov.zengame.settings.Textures;

public class ZenStage extends StageParent implements InputProcessor {

    GroupActor groupActor;
    int countFrame;

    boolean touch;
    float radius;
    int increase_radius = 2;
    int decrease_radius = 20;
    int max_radius;

    int time_for_sound = 0;
    int time_for_bells = 0;
    float count_time_for_sound;
    float count_time_for_bells;
    float rotation;

    public ZenStage(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Setup setup, Sound sound, Textures textures) {
        super(zenScreen, viewport, camera, setup, sound, textures);

        countFrame = 0;
        groupActor = new GroupActor(this, textures);
        addActor(groupActor);
        radius = 20;
        touch = false;
        max_radius = 128;
        count_time_for_sound = 0;
        count_time_for_bells = 0;
        rotation = 0;

        sound.playMusic();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!touch && radius > 10) {
            radius -= decrease_radius * delta;
            if (radius < 10) radius = 10;
        }

//        if (touch) {
//            rotation += 45 * delta;
//            if (rotation > 360) rotation = 0;
//        }

        count_time_for_sound += delta;
        count_time_for_bells += delta;

        countFrame += 1;
        if (countFrame > 10000) countFrame = 0;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.ESCAPE || keyCode == Input.Keys.BACK) {
            zenScreen.setMenuStage();
        }
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Zen.log((int) screenX * GdxViewport.RATIO_HORIZONTAL + " " + (int) screenY * GdxViewport.RATIO_VERTICAL);
        addUnit(screenX, screenY, 3);
        if (count_time_for_sound > time_for_sound) {
            sound.play(Sound.SOUND.TIBET);
            time_for_sound = 10;
            count_time_for_sound = 0;
        }
//        else if (count_time_for_bells > time_for_bells) {
//            sound.play(Sound.SOUND.BELLS);
//            time_for_bells = 8;
//            count_time_for_bells = 0;
//        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch = false;
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        touch = true;
        // if (countFrame % 10 == 0) {
        addUnit(screenX, screenY, 3);
        // }
        return super.touchDragged(screenX, screenY, pointer);
    }

    public void addUnit(int x, int y, int count) {

        radius += increase_radius * Gdx.graphics.getDeltaTime();
        if (radius > max_radius) radius = max_radius;

        switch (count) {
            case 3:
                groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.99f, 0.99f,
                                -0.1f, -0.02f, -0.5f, -0.05f),
                        (int) (x * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) (y * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count,
                        rotation,
                        1);
                addUnit(x, y, count - 1);
                break;
            case 2:
                groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.99f, 0.99f,
                                -0.3f, -0.01f, -0.1f, -0.05f),
                        (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) (y * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count,
                        rotation,
                        2);
                addUnit(x, y, count - 1);
                break;
            case 1:
                groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.99f, 0.99f,
                                -0.4f, -0.1f, -0.1f, -0.06f),
                        (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count,
                        rotation,
                        3);
                addUnit(x, y, count - 1);
                break;
            case 0:
                groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.99f, 0.99f,
                                -0.05f, -0.01f, -0.03f, -0.04f),
                        (int) (x * GdxViewport.RATIO_HORIZONTAL - radius),
                        (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius),
                        (int) radius,
                        count,
                        rotation,
                        4);
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
             int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL);
             int thisY = (int) (y * GdxViewport.RATIO_VERTICAL);
            // int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL - radius);
            // int thisY = (int) (y * GdxViewport.RATIO_VERTICAL - radius);
            groupActor.addUnit(new ColorRGB(0.05f, 0.99f, 0.99f, 0.99f,
                            0.4f, -0.1f, -0.1f, -0.05f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 10,
                    count,
                    rotation,
                    5);
            addSinCos(x, y, count - 1);
        } else if (count == 6) {
            int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL);
            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL);
//            int thisX = (int) (x * GdxViewport.RATIO_HORIZONTAL - radius);
//            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius);
            groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.1f, 0.99f,
                            -0.4f, -0.1f, 0.1f, -0.02f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 10,
                    count,
                    rotation,
                    6);
            addSinCos(x, y, count - 1);
        } else if (count == 5) {
            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL);
            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL);
//            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius);
//            int thisY = (int) ((Gdx.graphics.getHeight() - y) * GdxViewport.RATIO_VERTICAL - radius);
            groupActor.addUnit(new ColorRGB(0.99f, 0.1f, 0.99f, 0.99f,
                            -0.4f, 0.03f, -0.1f, -0.05f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 10,
                    count,
                    rotation,
                    7);
            addSinCos(x, y, count - 1);
        } else if (count == 4) {
            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL);
            int thisY = (int) (y * GdxViewport.RATIO_VERTICAL);
//            int thisX = (int) ((Gdx.graphics.getWidth() - x) * GdxViewport.RATIO_HORIZONTAL - radius);
//            int thisY = (int) (y * GdxViewport.RATIO_VERTICAL - radius);
            groupActor.addUnit(new ColorRGB(0.99f, 0.99f, 0.99f, 0.99f,
                            -0.4f, -0.02f, -0.1f, -0.05f),
                    (int) (Math.sin(thisX) * 100 + thisX),
                    (int) (Math.cos(thisY) * 100 + thisY),
                    (int) 10,
                    count,
                    rotation,
                    8);
            addSinCos(x, y, count - 1);
        }
    }


}
