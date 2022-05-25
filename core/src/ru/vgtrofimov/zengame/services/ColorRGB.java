package ru.vgtrofimov.zengame.services;

import ru.vgtrofimov.zengame.Zen;

public class ColorRGB {

    public float r, g, b, a;
    // Увеличение или уменьшение цвета
    float incR, incG, incB, incA;

    public ColorRGB(float r, float g, float b, float a, float incR, float incG, float incB, float incA) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.incR = incR;
        this.incG = incG;
        this.incB = incB;
        this.incA = incA;
    }

    public void act(float delta) {
        r = transformColor(r, incR, delta);
        g = transformColor(g, incG, delta);
        b = transformColor(b, incB, delta);
        a = transformColor(a, incA, delta);
    }

    private float transformColor(float color, float increase, float delta) {
        if (color > 0 && color < 1) {
            color += increase * delta;
        }
        if (color < 0) color = 0;
        if (color > 1) color = 1;
        return color;
    }
}
