package ru.vgtrofimov.zengame.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Setup {

    public static final String APP_ID = "ZENRELAX";
    public static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
    public static boolean pause = false;

    int volume;
    boolean music;

    public Setup() {

        loadPrefs();
    }

    public void loadPrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        volume = prefs.getInteger("jkoqopwoii919287iq", 75);
        music = prefs.getBoolean("jkhkopwoii919287iq", true);
    }

    public void savePrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        prefs.putInteger("jkoqopwoii919287iq", volume);
        prefs.putBoolean("jkhkopwoii919287iq", music);
        prefs.flush();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }
}
