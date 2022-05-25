package ru.vgtrofimov.zengame.settings;

public class GdxViewport {

    public static final float WORLD_WIDTH = 1024;
    public static final float WORLD_HEIGHT = 2048f;
    public static final float FIXED_BLOCK = WORLD_WIDTH / 25;
    public static float TOP;
    public static float BOTTOM;
    public static float HEIGHT;
    public static float RATIO, RATIO_HORIZONTAL, RATIO_VERTICAL;

    public static void resize(float width, float height) {

        RATIO_HORIZONTAL = (float) WORLD_WIDTH / width;
        RATIO_VERTICAL = (float) WORLD_HEIGHT / height;
        RATIO = (float) height / width;

        float viewportHeight = WORLD_WIDTH * RATIO;

        BOTTOM = (WORLD_HEIGHT - viewportHeight) / 2;
        TOP = BOTTOM + viewportHeight;
        HEIGHT = TOP - BOTTOM;
    }


}
