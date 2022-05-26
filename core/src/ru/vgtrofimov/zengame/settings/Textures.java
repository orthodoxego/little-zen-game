package ru.vgtrofimov.zengame.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Collections;
import java.util.Vector;

public class Textures {

    TextureRegion[] unit;
    Vector<TextureRegion> unit_for_shuffle;

    TextureRegion start, sound, music, instruction;
    TextureRegion instructionText;

    public Textures() {

        Texture load = new Texture("png/help.png");
        instructionText = getTextureRegionFromMap(0, 0, 512, 768, false, true, load);

        load = new Texture("png/image_pack.png");

        unit = new TextureRegion[8];
        unit_for_shuffle = new Vector<>();
        for (int i = 0; i < 8; i++) {
            unit_for_shuffle.add(getTextureRegionFromMap(i * 64, 0, 64, 64, false, true, load));
        }

        shuffleUnit();

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

    public TextureRegion getInstructionText() {
        return instructionText;
    }

    public void shuffleUnit() {
        Collections.shuffle(unit_for_shuffle);
        for (int i = 0; i < unit_for_shuffle.size(); i++) {
            unit[i] = unit_for_shuffle.elementAt(i);
        }
    }
}
