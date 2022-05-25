package ru.vgtrofimov.zengame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.settings.Textures;
import ru.vgtrofimov.zengame.stages.StageParent;
import ru.vgtrofimov.zengame.stages.ZenStage;

public class ZenScreen implements Screen {

    Viewport viewport;
    OrthographicCamera camera;
    Textures textures;
    // AssetManager manager;

    StageParent stage;


    public ZenScreen(Viewport viewport, OrthographicCamera camera, Textures textures) {
        this.viewport = viewport;
        this.camera = camera;
        this.textures = textures;

        setGameStage();
    }

    public void setGameStage() {
        stage = null;
        stage = new ZenStage(this, viewport, camera, textures);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
