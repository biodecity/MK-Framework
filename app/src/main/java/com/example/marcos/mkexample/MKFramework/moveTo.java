package com.example.marcos.mkexample.MKFramework;

/**
 * Created by Marcos on 4/17/16.
 */
public class moveTo extends MKAction
{
    public moveTo(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void genericAction(MKNode node)
    {
        node.setX(this.x);
        node.setY(this.y);

    }
}
