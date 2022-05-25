package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.Zen;
import ru.vgtrofimov.zengame.actors.ActorMenu;
import ru.vgtrofimov.zengame.actors.GroupActor;
import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.ColorRGB;
import ru.vgtrofimov.zengame.services.ReturnKey;
import ru.vgtrofimov.zengame.services.Sound;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Setup;
import ru.vgtrofimov.zengame.settings.Textures;

public class MenuStage extends StageParent implements InputProcessor, ReturnKey {

    public enum MENU { START, SOUND, MUSIC, INSTRUCTION }


    ActorMenu start_menu, instruction_menu, sound_menu, music_menu;

    public MenuStage(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Setup setup, Sound sound, Textures textures) {
        super(zenScreen, viewport, camera, setup, sound, textures);

        sound.stopMusic();

        int y = (int) (camera.viewportHeight / 2 - 64 * 3);

        start_menu = new ActorMenu(this, textures.getStart(), true, MENU.START, y, (int) GdxViewport.WORLD_WIDTH);
        addActor(start_menu);

        instruction_menu = new ActorMenu(this,
                textures.getInstruction(),
                true,
                MENU.INSTRUCTION, y + 64 * 2,
                (int) GdxViewport.WORLD_WIDTH);

        sound_menu = new ActorMenu(this,
                textures.getSound(),
                setup.getVolume() > 0,
                MENU.SOUND, y + 64 * 4,
                (int) GdxViewport.WORLD_WIDTH);

        music_menu = new ActorMenu(this,
                textures.getMusic(),
                setup.isMusic(),
                MENU.MUSIC, y + 64 * 6,
                (int) GdxViewport.WORLD_WIDTH);

        addActor(start_menu);
        addActor(instruction_menu);
        addActor(sound_menu);
        addActor(music_menu);

    }

    public void press_key(MENU menu) {
        sound.play(Sound.SOUND.MENU);
        switch (menu) {
            case START:
                zenScreen.setGameStage();
                break;
            case INSTRUCTION:
                zenScreen.setInstructionStage();
                break;
            case SOUND:
                if (setup.getVolume() > 0)
                    setup.setVolume(0);
                else
                    setup.setVolume(75);
                sound_menu.setEnabled(setup.getVolume() > 0);
                break;
            case MUSIC:
                setup.setMusic(!setup.isMusic());
                music_menu.setEnabled(setup.isMusic());
                break;
        }
    }

}
