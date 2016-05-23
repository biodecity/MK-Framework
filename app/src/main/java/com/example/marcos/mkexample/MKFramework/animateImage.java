package com.example.marcos.mkexample.MKFramework;

/**
 * Created by Marcos on 4/18/16.
 */
public class animateImage extends MKAction
{
    public animateImage(String fileName, int framesX, int framesY, int time, boolean always)
    {
        this.framesX = framesX;
        this.framesY = framesY;
        this.frameTime = time;
        this.fileName = fileName;
        this.always = always;
    }

    @Override
    public void genericAction(MKNode node)
    {

        animate((MKSpriteNode)node);

    }

    public void animate(MKSpriteNode node)
    {
       node.setAnimation(fileName,framesX, framesY, frameTime, always);
    }


}
