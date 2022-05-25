package ru.vgtrofimov.zengame.actors;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.Vector;

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

    public void addActor(ColorRGB colorRGB, int x, int y, int width) {
        actorPixels.add(new ActorPixel(this, textures.getUnit(), colorRGB, x, y, width));
        addActor(actorPixels.lastElement());
    }

    public void deleteActor(ActorPixel actorPixel) {
        actorPixel.remove();
        actorPixels.removeElement(actorPixel);
    }
}
