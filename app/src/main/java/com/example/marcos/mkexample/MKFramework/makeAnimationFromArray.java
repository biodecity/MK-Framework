package com.example.marcos.mkexample.MKFramework;

/**
 * Created by Marcos on 4/18/16.
 */
public class makeAnimationFromArray extends MKAction
{
    public makeAnimationFromArray(String[] images, int time, boolean always)
    {
        this.images = images;

    }

    @Override
    public void genericAction(MKNode node)
    {

        animate((MKSpriteNode)node);


    }
    public void animate(MKSpriteNode node)
    {

    }


}

