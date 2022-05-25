package ru.vgtrofimov.zengame.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    TextureRegion[] unit;

    public Textures() {
        Texture load = new Texture("png/image_pack.png");

        unit = new TextureRegion[8];
        for (int i = 0; i < 8; i++) {
            unit[i] = getTextureRegionFromMap(i * 64, 0, 64, 64, false, true, load);
        }
    }

    private TextureRegion getTextureRegionFromMap(int x, int y, int width, int height, boolean flipX, boolean flipY, Texture texture) {
        TextureRegion tr = new TextureRegion(texture, x, y, width, height);
        tr.flip(flipX, flipY);
        return tr;
    }

    public TextureRegion[] getUnit() {
        return unit;
    }
}
