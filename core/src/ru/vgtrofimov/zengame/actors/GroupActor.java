package ru.vgtrofimov.zengame.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.Vector;

import ru.vgtrofimov.zengame.Zen;
import ru.vgtrofimov.zengame.services.ColorRGB;
import ru.vgtrofimov.zengame.settings.Textures;
import ru.vgtrofimov.zengame.stages.ZenStage;

public class GroupActor extends Group {

    ZenStage zenStage;
    Textures textures;

    Vector<ActorPixel> actorPixels;

    public GroupActor(ZenStage zenStage, Textures textures) {
        this.zenStage = zenStage;
        this.textures = textures;

        actorPixels = new Vector<>();
    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }

    public void addUnit(ColorRGB colorRGB, int x, int y, int width, int numberUnit, float rotation, int num) {
        actorPixels.add(new ActorPixel(this, textures.getUnit()[numberUnit], colorRGB, x, y, width, rotation, num));
        addActor(actorPixels.lastElement());
        // Zen.log("Len " + actorPixels.size());
    }

    public void deleteActor(ActorPixel actorPixel) {
        actorPixel.remove();
        actorPixels.removeElement(actorPixel);
    }
}

