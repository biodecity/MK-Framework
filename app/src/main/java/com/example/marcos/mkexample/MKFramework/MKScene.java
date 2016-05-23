package com.example.marcos.mkexample.MKFramework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 4/1/16.
 */
public class MKScene extends View
{
    Paint paint = new Paint();
    float starTime;
    int r = 200, g = 200, b = 200;
    int[] backgroundColor = new int[3];



    public MKScene(Context context)
    {

        super(context);

    }

    public enum MKColor
    {

        Red, Blue, Green, Cyan, Magenta, Yellow, Black, White;


    }


    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float deltaTime = (System.nanoTime()-starTime)/1000000.0f;
        starTime = System.nanoTime();

        canvas.drawRGB(backgroundColor[0], backgroundColor[1], backgroundColor[2]);
        invalidate();

        this.update(deltaTime, canvas, paint);

    }

    protected void setBackgroundCustomColor(int r, int g, int b)
    {
        backgroundColor[0] = r;
        backgroundColor[1] = g;
        backgroundColor[2] = b;

    }

    protected void setBackgroundColor(MKColor color)
    {

        switch (color)
        {
            case Red:
                backgroundColor[0] = 255;
                backgroundColor[1] = 0;
                backgroundColor[2] = 0;
                break;

            case Green:
                backgroundColor[0] = 0;
                backgroundColor[1] = 255;
                backgroundColor[2] = 0;
                break;

            case Blue:
                backgroundColor[0] = 0;
                backgroundColor[1] = 0;
                backgroundColor[2] = 255;
                break;

            case Cyan:
                backgroundColor[0] = 0;
                backgroundColor[1] = 255;
                backgroundColor[2] = 255;
                break;

            case Magenta:
                backgroundColor[0] = 255;
                backgroundColor[1] = 0;
                backgroundColor[2] = 255;
                break;

            case Yellow:
                backgroundColor[0] = 255;
                backgroundColor[1] = 255;
                backgroundColor[2] = 0;
                break;

            case Black:
                backgroundColor[0] = 0;
                backgroundColor[1] = 0;
                backgroundColor[2] = 0;
                break;

            case White:
                backgroundColor[0] = 255;
                backgroundColor[1] = 255;
                backgroundColor[2] = 255;
                break;

            default:
                backgroundColor[0] = 0;
                backgroundColor[1] = 0;
                backgroundColor[2] = 0;
                break;




        }


    }

    List<MKNode> children = new ArrayList<MKNode>();//Lista de nodes de dentro da cena


    public void addChild(MKNode obj)
    {
        for(int i = 0; i<children.size();i++)
        {
            if(obj.layer<children.get(i).layer)
            {
                children.add(i, obj);
            }
        }
        children.add(obj);
    }

    public void removeChild(MKNode obj)
    {
        children.remove(obj);
    }



    public void update(float deltaTime, Canvas canvas, Paint paint)//Desenha todas as quilança
    {
        for (MKNode obj: new  ArrayList<MKNode>(children))
        {
            obj.draw(canvas, paint);
            obj.update(deltaTime);
        }


    }


}
