package ru.nikita.samsung.hw17;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

import static java.lang.Math.random;

public class MyView extends View {
    Random rand = new Random();
    Paint paint = new Paint();
    Circle2D[] arrayCircleList;

    float[] remebr = new float[2];
    float[] delta = new float[2];

    public MyView(Context context, int countOfCircle) {
        super(context);
        arrayCircleList = new Circle2D[countOfCircle];
        for (int i = 0; i < arrayCircleList.length; i++) {
            arrayCircleList[i] = new Circle2D();
            arrayCircleList[i].x = 540;
            arrayCircleList[i].y = 990;
            arrayCircleList[i].dX = (float) (random());
            arrayCircleList[i].dY = (float) (random());
            arrayCircleList[i].color = RandomColor(arrayCircleList[i].color);
            arrayCircleList[i].radius = rand.nextInt(50) + 50;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Circle2D _circle : arrayCircleList) {
            paint.setColor(_circle.color);
            canvas.drawCircle(_circle.x, _circle.y, _circle.radius, paint);
            _circle.y += _circle.dY * delta[1];
            _circle.x += _circle.dX * delta[0];

            if ((_circle.x + _circle.dX) > getWidth() - _circle.radius || _circle.x + _circle.dX < _circle.radius) {
                _circle.dX = -_circle.dX;
                _circle.color = RandomColor(_circle.color);
            }

            if ((_circle.y + _circle.dY) > getHeight() - _circle.radius || _circle.y + _circle.dY < _circle.radius) {
                _circle.dY = -_circle.dY;
                _circle.color = RandomColor(_circle.color);
            }
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                remebr[0] = event.getX();
                remebr[1] = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                delta[0] = event.getX() - remebr[0];
                delta[1] = event.getY() - remebr[1];
                break;
        }
        return true;
    }

    public int RandomColor(int color) {
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return color = Color.rgb(r, g, b);
    }

}
