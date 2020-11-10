package ru.nikita.samsung.hw17;

import android.graphics.Color;

public class Circle2D {
    float x, y, radius;
    int color;
    float dX, dY;

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 50;
        color = Color.BLUE;
    }

    public Circle2D(float radius, float x, float y, int color) {
        this.x = x;
        this.y = y;
        this.radius = 10;
        this.color = Color.BLUE;
        this.dX = x;
        this.dY = y;
    }

    public void Draw() {
        //TODO релизовать отрисовку круга
    }
}
