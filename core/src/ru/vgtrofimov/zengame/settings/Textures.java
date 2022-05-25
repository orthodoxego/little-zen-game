package ru.vgtrofimov.zengame.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Collections;
import java.util.Vector;

public class Textures {

    TextureRegion[] unit;

    TextureRegion start, sound, music, instruction;

    public Textures() {
        Texture load = new Texture("png/image_pack.png");

        unit = new TextureRegion[8];
        Vector<TextureRegion> tmp = new Vector<>();
        for (int i = 0; i < 8; i++) {
            tmp.add(getTextureRegionFromMap(i * 64, 0, 64, 64, false, true, load));
        }
        Collections.shuffle(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            unit[i] = tmp.elementAt(i);
        }

        start = getTextureRegionFromMap(0, 64, 128, 64, false, true, load);
        sound = getTextureRegionFromMap(0, 128, 128, 64, false, true, load);
        music = getTextureRegionFromMap(0, 192, 128, 64, false, true, load);
        instruction = getTextureRegionFromMap(128, 64, 192, 64, false, true, load);

    }

    private TextureRegion getTextureRegionFromMap(int x, int y, int width, int height, boolean flipX, boolean flipY, Texture texture) {
        TextureRegion tr = new TextureRegion(texture, x, y, width, height);
        tr.flip(flipX, flipY);
        return tr;
    }

    public TextureRegion[] getUnit() {
        return unit;
    }

    public TextureRegion getStart() {
        return start;
    }

    public TextureRegion getSound() {
        return sound;
    }

    public TextureRegion getMusic() {
        return music;
    }

    public TextureRegion getInstruction() {
        return instruction;
    }
}
