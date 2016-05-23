package com.example.marcos.mkexample.MKFramework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.InputStream;

/**
 * Created by Marcos on 4/1/16.
 */
public class MKSpriteNode extends MKNode
{
        protected  Bitmap bitmap;
        protected  Bitmap[] anim;
        protected  Bitmap stopped;
        protected  String fileString;
        protected  AssetManager assetManager;
        protected  int currentFrame = 1;
        protected  int frames = 1;
        protected  int framesW = 1;
        protected  int framesH = 1;
        protected  float elapsedTime = 0;
        protected  int timeToNextFrame = 0;
        protected  boolean alwaysAnimate = false;
        protected  boolean isAnimating = false;


    public MKSpriteNode(String filename, AssetManager assetManager)
    {
        this.fileString = filename;
        this.assetManager = assetManager;
        this.loadImage(this.fileString, this.assetManager);

        //Nesse construtor ocorre uma sobrecarga de métodos para dar handle em
        //ambas situações, a que o programador coloque uma imagem estática
        //sem divisões, e no método abaixo é para uma imagem estática sendo o primeiro
        //quadro de uma spritesheet.
    }

    public MKSpriteNode(String filename, AssetManager assetManager, int framesW, int framesH)
    {

        this.fileString = filename;
        this.assetManager = assetManager;
        this.framesW = framesW;
        this.framesH = framesH;
        this.loadImage(this.fileString, this.assetManager);


    }

    public void loadImage (String filename, AssetManager assetManager)
    {
        try {
            InputStream is = assetManager.open(filename);
            bitmap = BitmapFactory.decodeStream(is);
            width = bitmap.getWidth()/framesW;
            height = bitmap.getHeight()/framesH;
            is.close();


            if(!isAnimating)
            {

                stopped = Bitmap.createBitmap(bitmap, 0, 0, width, height);
            }
            else
            {
                anim = new Bitmap[frames];

                int index = 0;


                for (int i = 0; i < framesW; i++)
                {
                    for (int j = 0; j < framesH; j++)
                    {
                        anim[index++] = Bitmap.createBitmap(bitmap, i * width, j * height, width, height);
                    }

                }
            }



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }




        public void draw(Canvas canvas, Paint paint)
        {

            if(!isAnimating)
            {

                canvas.drawBitmap(stopped, this.getX(), this.getY(), paint);

            }
            else
            {
                canvas.drawBitmap(anim[currentFrame], this.getX(), this.getY(), paint);
            }

        }


    public void setAnimation(String fileName, int w, int h, int time, boolean always)
    {
        frames = w*h;
        framesH = h;
        framesW = w;
        this.timeToNextFrame = time;
        this.fileString = fileName;
        alwaysAnimate = always;
        isAnimating = true;

        this.loadImage(this.fileString, this.assetManager);
    }

    @Override
    public void update(float deltaTime)
    {

        elapsedTime += deltaTime;

        if(elapsedTime > timeToNextFrame && isAnimating)
        {

            elapsedTime = 0;
            currentFrame++;
            if(currentFrame>=frames)
            {

                currentFrame = 0;

                if(alwaysAnimate)
                {
                isAnimating=true;
                }

                else
                {
                    isAnimating = false;
                }
            }
        }


    }


}
