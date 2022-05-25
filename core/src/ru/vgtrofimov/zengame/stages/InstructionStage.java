package ru.vgtrofimov.zengame.stages;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.zengame.actors.ActorInstruction;
import ru.vgtrofimov.zengame.actors.ActorMenu;
import ru.vgtrofimov.zengame.screens.ZenScreen;
import ru.vgtrofimov.zengame.services.ReturnKey;
import ru.vgtrofimov.zengame.services.Sound;
import ru.vgtrofimov.zengame.settings.GdxViewport;
import ru.vgtrofimov.zengame.settings.Setup;
import ru.vgtrofimov.zengame.settings.Textures;

public class InstructionStage extends StageParent implements InputProcessor, ReturnKey {

    // public enum MENU { START, SOUND, MUSIC, INSTRUCTION }


    ActorInstruction instructionText;

    public InstructionStage(ZenScreen zenScreen, Viewport viewport, OrthographicCamera camera, Setup setup, Sound sound, Textures textures) {
        super(zenScreen, viewport, camera, setup, sound, textures);

        sound.stopMusic();

        int y = (int) (camera.viewportHeight * 0.1f);

        instructionText = new ActorInstruction(this, textures.getInstructionText(), true, MenuStage.MENU.START, y, (int) GdxViewport.WORLD_WIDTH);
        addActor(instructionText);


    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.ESCAPE || keyCode == Input.Keys.BACK) {
            zenScreen.setMenuStage();
        }
        return true;
    }


    @Override
    public void press_key(MenuStage.MENU menu) {
        sound.play(Sound.SOUND.MENU);
        zenScreen.setMenuStage();
    }
}
