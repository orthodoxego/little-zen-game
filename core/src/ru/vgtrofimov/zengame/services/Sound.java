package ru.vgtrofimov.zengame.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import ru.vgtrofimov.zengame.settings.Setup;

public class Sound {

    public enum SOUND { TIBET,
        MENU
    };


    Setup setup;
    int maxSound = 10;
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
        soundMelody[5] = Gdx.audio.newSound(Gdx.files.internal("sound/menu.ogg"));

    }

    public boolean play(SOUND sound) {
        if (!(setup.getVolume() > 0)) return false;

        switch (sound) {
            case TIBET:
                // soundMelody[0].stop();
                int num = (int) (Math.random() * 5);
                soundMelody[num].play(0.01f * setup.getVolume());
                break;
            case MENU:
                soundMelody[5].play(0.01f * setup.getVolume() * 0.75f);
                break;
        }

        return true;
    }

    public void playMusic() {
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/music.mp3"));
        if (setup.isMusic()) {
            music.setVolume(0.01f * setup.getVolume() * 0.25f);
            music.setLooping(true);
            music.play();
        }
    }

    public void dispose() {
        for (int i = 0; i < maxSound; i++)
            soundMelody[i].dispose();
//        music.dispose();
    }
}
