package com.example.dam.myapplication141116;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ColorView extends View implements View.OnClickListener{
    private int color;
    interface OnColorChangedListener {
        public void colorChanged(View view, int color);
    }
    private OnColorChangedListener listener;
    private Paint paint;

    public ColorView(Context context) {this(context, null, 0);}
    public ColorView(Context context, AttributeSet attrs) {this(context, attrs, 0);}
    public ColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        color = Color.BLUE;
        this.setOnClickListener(this);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

    }
    @Override public void draw(Canvas canvas){
        canvas.drawColor(color);
        canvas.drawRect(0.5f , 0.5f, getWidth()-0.5f, getHeight()-0.5f, paint);
    }
    public int getColor() {return this.color;}
    public void setColor(int color){
        this.color = color;
        this.invalidate();
    }

    public void setOnColorChangedListener(OnColorChangedListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);

        int color = Color.rgb(r,g,b);
        setColor(color);
        if(this.listener != null){
            this.listener.colorChanged(this, color);
        }
    }
}
