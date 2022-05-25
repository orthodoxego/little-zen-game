package ru.vgtrofimov.zengame.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.Rectangle;

import ru.vgtrofimov.zengame.services.ColorRGB;

public class ActorPixel extends Actor {

    GroupActor groupActor;
    TextureRegion textureRegion;
    ColorRGB colorRGB;
    float moveDown = 300;

    boolean enabled;

    public ActorPixel(GroupActor groupActor, TextureRegion textureRegion, ColorRGB colorRGB, int x, int y, int width) {
        this.groupActor = groupActor;
        this.textureRegion = textureRegion;
        this.colorRGB = colorRGB;
        setX(x); setY(y);
        setWidth(width); setHeight(width);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setRotation(0);
        setScale(1, 1);
        enabled = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getWidth() > 0) {
            setWidth(getWidth() - 10 * delta);
            setHeight(getWidth());
        } else {
            setEnabled(false);
        }


        colorRGB.act(delta);

        setY(getY() + moveDown * delta);
        moveDown *= 0.993f;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.setColor(colorRGB.r, colorRGB.g, colorRGB.b, colorRGB.a);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

        batch.setColor(1, 1, 1, parentAlpha);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        if (!enabled) groupActor.deleteActor(this);
        this.enabled = enabled;
    }
}
