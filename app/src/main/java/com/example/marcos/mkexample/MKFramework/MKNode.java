package com.example.marcos.mkexample.MKFramework;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Marcos on 4/1/16.
 */
public class MKNode
{

        private int x = 0, y = 0;
        public int layer = 0;
        public int width=0, height =0;


        public void setX(int x)
        {
                this.x = x - this.width/2;

        }

        public void setY(int y)
        {
                this.y = y - this.height/2;
        }


        public int getX()
        {
                return this.x;
        }

        public int getY()
        {
                return this.y;
        }


        public void draw(Canvas canvas, Paint paint)
        {

        }

        public void runAction(MKAction action)
        {

                action.genericAction(this);

        }


        public Rect getRect()
        {
            return (new Rect((int)(x-width/2), (int)(y-height/2), (int)(x+width/2), (int)(y+height/2)));
        }


        public boolean hitNode(MKNode enemy)
        {

            boolean aux;

            if(this.getRect().intersect(enemy.getRect()))
            {
                aux = true;
            }
            else
            {
                aux = false;
            }
            return aux;
        }


    public void update(float deltaTime)
    {

    }


}
