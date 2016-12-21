package com.example.user.labw11fragmentfoto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity implements View.OnTouchListener {

    Bitmap resourceFoto;
    int bmpx, bmpy, mywidth = 0, myheight = 0, x, y, xDown = 0, yDown = 0, xMove, yMove, xUp, yUp, n = 0, h2, w2, xx1 = 1000, yy1 = 1000, xx2 = 1150, yy2 = 1230, k = 0, t = 0;
    Paint p;
    String s;
    Rect R11, R12, R21, R22, R31, R41, R51, R52, R61, R71, R72;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resourceFoto = BitmapFactory.decodeResource(getResources(), R.drawable.ui);
        bmpx = resourceFoto.getWidth();
        bmpy = resourceFoto.getHeight();
        mm = new misha(this);
        setContentView(mm);
        mm.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX();   // текущая координата X пальца
        y = (int) event.getY();   // текущая координата Y пальца

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                // здесь делаем что-то, чтобы обработать событие нажатия
                n++;
                xDown = x;
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                // здесь обработываем событие перемещения пальца
                xMove = x;
                yMove = y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
                // здесь делаем что-то, чтобы обработать событие отпускания
                xUp = x;
                yUp = y;
                break;
            case MotionEvent.ACTION_CANCEL:
                // событие отмены
                xUp = 0;
                yUp = 0;
                xMove = 0;
                yMove = 0;
                xDown = 0;
                yDown = 0;
                break;
        }
        // здесь можем вывести нужные надписи
        s = xDown + " " + yDown + " число нажатий: " + n;
        mm.invalidate();
        return true;
    }

    class misha extends View
    {

        public misha(Context context)
        {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            p.setTextSize(18);
            p.setTextAlign(Paint.Align.CENTER);
            h2 = canvas.getHeight();
            w2 = canvas.getWidth();
            p.setColor(Color.BLACK);
            R11=new Rect(0, 0, 310, 550);
            R22=new Rect(10, 10, 600, 900);
            canvas.drawBitmap(resourceFoto, R11, R22, p);
            R31=new Rect(500, 150, 600, 250);
            R41=new Rect(150, 150, 300, 450);
            canvas.drawBitmap(resourceFoto, R31, R41, p);
        }
    }
    misha mm;
}
