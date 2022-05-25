package ru.vgtrofimov.zengame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.zengame.services.ColorRGB;
import ru.vgtrofimov.zengame.settings.GdxViewport;

public class ActorPixel extends Actor {

    GroupActor groupActor;
    TextureRegion textureRegion;
    ColorRGB colorRGB;
    float moveDown;

    boolean enabled;
    float rotate = 0;

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
        moveDown = 100;
        if (y > (Gdx.graphics.getHeight() / 2) * GdxViewport.RATIO_VERTICAL) moveDown *= -1;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setRotation(getRotation() + 45 * delta);
        if (getRotation() > 360) setRotation(0);


        if (getWidth() > 1) {
            setWidth(getWidth() - 3 * delta);
            setHeight(getWidth());
        } else {
            setEnabled(false);
        }


        colorRGB.act(delta);

        setY(getY() + moveDown * delta);
        moveDown *= 0.993f;

        if (colorRGB.r + colorRGB.g + colorRGB.b + colorRGB.a == 0) {
            setEnabled(false);
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (getWidth() < 10 && Math.random() * 100 < 35) {
//            batch.setColor(colorRGB.r, colorRGB.g, colorRGB.b, colorRGB.a);
//            batch.draw(textureRegion, getX() + getWidth() / 2, getY() + getHeight() / 2, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
//            batch.setColor(1, 1, 1, parentAlpha);
        } else {
            batch.setColor(colorRGB.r, colorRGB.g, colorRGB.b, colorRGB.a);
            batch.draw(textureRegion, getX() + getWidth() / 2, getY() + getHeight() / 2, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            batch.setColor(1, 1, 1, parentAlpha);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        if (!enabled) groupActor.deleteActor(this);
        this.enabled = enabled;
    }
}
