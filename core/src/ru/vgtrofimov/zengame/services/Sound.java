package ru.vgtrofimov.zengame.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import ru.vgtrofimov.zengame.settings.Setup;

public class Sound {


    public enum SOUND { TIBET,
        BELLS,
        MENU
    };


    Setup setup;
    int maxSound = 20;
    public com.badlogic.gdx.audio.Sound[] soundMelody;

    Music music;

    public Sound(Setup setup) {
        this.setup = setup;

        soundMelody = new com.badlogic.gdx.audio.Sound[maxSound];
        soundMelody[0] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet01.ogg"));
        soundMelody[1] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet02.ogg"));
        soundMelody[2] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet03.ogg"));
        soundMelody[3] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet04.ogg"));
        soundMelody[4] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet05.ogg"));
        soundMelody[5] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet06.ogg"));
        soundMelody[6] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet07.ogg"));
        soundMelody[7] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet08.ogg"));
        soundMelody[8] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet09.ogg"));
        soundMelody[9] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet10.ogg"));
        soundMelody[10] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet11.ogg"));
        soundMelody[11] = Gdx.audio.newSound(Gdx.files.internal("sound/tibet12.ogg"));
        soundMelody[12] = Gdx.audio.newSound(Gdx.files.internal("sound/bells01.ogg"));
        soundMelody[13] = Gdx.audio.newSound(Gdx.files.internal("sound/bells02.ogg"));
        soundMelody[14] = Gdx.audio.newSound(Gdx.files.internal("sound/bells03.ogg"));
        soundMelody[15] = Gdx.audio.newSound(Gdx.files.internal("sound/bells04.ogg"));
        soundMelody[16] = Gdx.audio.newSound(Gdx.files.internal("sound/bells05.ogg"));
        soundMelody[19] = Gdx.audio.newSound(Gdx.files.internal("sound/menu.ogg"));

    }

    public boolean play(SOUND sound) {
        if (!(setup.getVolume() > 0)) return false;

        int num;
        switch (sound) {
            case TIBET:
                // soundMelody[0].stop();
                num = (int) (Math.random() * 12);
                soundMelody[num].play(0.01f * setup.getVolume() * 0.8f);
                break;
            case BELLS:
                num = (int) (12 + Math.random() * 5);
                soundMelody[num].play(0.01f * setup.getVolume() * 0.5f);
                break;
            case MENU:
                soundMelody[19].play(0.01f * setup.getVolume() * 0.8f);
                break;
        }

        return true;
    }

    public void playMusic() {
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/music.mp3"));
        if (setup.isMusic()) {
            music.setVolume(0.4f);
            music.setLooping(true);
            music.play();
        }
    }

    public void stopMusic() {
        if (music != null) music.stop();
    }

    public void dispose() {
        for (int i = 0; i < maxSound; i++)
            soundMelody[i].dispose();
//        music.dispose();
    }
}
