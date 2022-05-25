package ru.vgtrofimov.zengame.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.zengame.services.ReturnKey;
import ru.vgtrofimov.zengame.stages.MenuStage;

public class ActorInstruction extends Actor {

    ReturnKey returnKey;
    TextureRegion textureRegion;
    boolean enabled;
    MenuStage.MENU menu;
    int texture_x;

    public ActorInstruction(final ReturnKey returnKey, TextureRegion textureRegion, boolean enabled, final MenuStage.MENU menu, int y, int width_screen) {
        this.returnKey = returnKey;
        this.textureRegion = textureRegion;
        this.enabled = enabled;
        this.menu = menu;

        setWidth(textureRegion.getRegionWidth());
        setHeight(textureRegion.getRegionHeight());
        texture_x = (width_screen - textureRegion.getRegionWidth() * 2) / 2;
        setY(y);
        setOrigin(0, 0);
        setBounds(0, y, width_screen, getHeight() * 2);
        setRotation(0); setScale(1, 1);

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                returnKey.press_key(menu);
                return true;
            }
        });

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (enabled) {
            batch.draw(textureRegion, texture_x, getY(), getOriginX(), getOriginY(), textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2, getScaleX(), getScaleY(), getRotation());
        } else {
            batch.setColor(1, 1, 1, 0.3f);
            batch.draw(textureRegion, texture_x, getY(), getOriginX(), getOriginY(), textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2, getScaleX(), getScaleY(), getRotation());
        }
        batch.setColor(1, 1, 1, parentAlpha);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
