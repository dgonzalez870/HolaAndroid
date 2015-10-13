package com.prueba.holaAndroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class VistaPersonal extends View implements OnTouchListener {

    private Paint p;
    float x,y;

    public VistaPersonal(Context context, AttributeSet attrs) {
        super(context, attrs);
        p=new Paint();
        //Color del trazo
        p.setColor(Color.BLUE);
        setOnTouchListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(heightMeasureSpec));
        x=getWidth()/2;
        y=getHeight()/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //mensaje a ser presentado en pantalla
        String mensaje="¡Hola Android!";
        //Tamaño del texto
        p.setTextSize(40);
        //buffer para almacenar las dimensiones del texto
        float[] bf=new float[32];
        int nl=p.getTextWidths(mensaje, bf);
        float anchoMensaje=0;
        for(int i=0;i<nl;i++){
            anchoMensaje+=bf[i];
        }
        //Estilo  trazo
        p.setStyle(Paint.Style.STROKE);
        //Ancho del trazo
        p.setStrokeWidth(3);
        //canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 4, p);
        canvas.drawCircle(x, y, getWidth() / 4, p);
        Path path=new Path();
        p.setColor(Color.RED);
        canvas.drawPath(path, p);
        path.addCircle(getWidth() / 2, getHeight() / 2, getWidth() / 4, Path.Direction.CW);
        p.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(mensaje, path, (float) ((3.0 / 2) * Math.PI * getWidth() / 4 - anchoMensaje / 2.0), -40, p);
        canvas.drawCircle(getWidth() / 4, 3.5f * getHeight() / 4, getWidth() / 8, p);
        p.setColor(Color.GREEN);
        canvas.drawCircle(getWidth() / 2, 3.5f * getHeight() / 4, getWidth() / 8, p);
        p.setColor(Color.BLUE);
        canvas.drawCircle(3*getWidth()/4, 3.5f*getHeight()/4, getWidth() / 8, p);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                p.setColor(Color.GREEN);
                x=motionEvent.getX();
                y=motionEvent.getY();
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                x=motionEvent.getX();
                y=motionEvent.getY();
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                p.setColor(Color.BLUE);
                invalidate();
                return true;
            default:
                return false;
        }
    }

}
