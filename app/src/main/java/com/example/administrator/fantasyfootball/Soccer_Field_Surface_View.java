package com.example.administrator.fantasyfootball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by camachon18 on 9/19/2015.
 */
public class Soccer_Field_Surface_View extends SurfaceView{

    public Soccer_Field_Surface_View(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        Paint green = new Paint();
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL_AND_STROKE);
        green.setStrokeWidth(5);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), green);
    }
}
