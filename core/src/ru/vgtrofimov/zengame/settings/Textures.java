package ru.vgtrofimov.zengame.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    TextureRegion unit;

    public Textures() {
        Texture load = new Texture("png/image_pack.png");

        unit = getTextureRegionFromMap(192, 0, 64, 64, false, true, load);
    }

    private TextureRegion getTextureRegionFromMap(int x, int y, int width, int height, boolean flipX, boolean flipY, Texture texture) {
        TextureRegion tr = new TextureRegion(texture, x, y, width, height);
        tr.flip(flipX, flipY);
        return tr;
    }

    public TextureRegion getUnit() {
        return unit;
    }
}
