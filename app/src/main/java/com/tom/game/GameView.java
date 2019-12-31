package com.tom.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private float posX,posY=400;
    private int lionWidth;
    private int lionHeight;
    Lion lion;
    private Bitmap bitmapMonkey;
    private Bitmap bitmapNG;


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (lion == null) {
            lion = new Lion(this);
            bitmapMonkey = BitmapFactory.decodeResource(getResources(),R.drawable.lion);
            bitmapNG = BitmapFactory.decodeResource(getResources(),R.drawable.lion_ng);
        }

        if(lion.direction == Lion.DIRECTION_NG){
            bitmapMonkey = bitmapNG;
        }
        Paint paint = new Paint();
        canvas.drawLine(400,0,0,600,paint);

        canvas.drawBitmap(bitmapMonkey,lion.getX(),lion.getY(),paint);
        lionWidth = bitmapMonkey.getWidth();
        lionHeight = bitmapMonkey.getHeight();
        Log.d("GameActivity","size"+bitmapMonkey.getWidth()+","+bitmapMonkey.getHeight());
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void moveDown() {
        if (lion.getY() < getHeight()-150) {
            lion.setDirection(Lion.DIRECTION_DOWN);
            invalidate();
        }
    }
    public void moveUp() {
        if (lion.getY() > 50) {
            lion.setDirection(Lion.DIRECTION_UP);
            invalidate();
        }
    }
    public void moveRight() {
        if (lion.getX() < getWidth()-150) {
            lion.setDirection(Lion.DIRECTION_RIGHT);
            invalidate();
        }
    }

    public void moveLeft() {
        if (lion.getX() > 50) {
            lion.setDirection(Lion.DIRECTION_LEFT);
            invalidate();
        }
    }
    public void setPosX(float posX) {
        if(posX > 0 && posX < getWidth()-lionWidth){
        this.posX = posX;
        }
    }

    public void setPosY(float posY) {
        if(posY > 0 && posY < getHeight()-lionHeight) {
            this.posY = posY;
        }
    }
}
