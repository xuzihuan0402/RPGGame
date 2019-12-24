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


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawLine(400,0,0,600,paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lion);
        canvas.drawBitmap(bitmap,posX,posY,paint);
        lionWidth = bitmap.getWidth();
        lionHeight = bitmap.getHeight();
        Log.d("GameActivity","size"+bitmap.getWidth()+","+bitmap.getHeight());
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
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
