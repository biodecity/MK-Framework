package com.example.marcos.mkexample.MKFramework;

/**
 * Created by Marcos on 4/17/16.
 */
public class moveBy extends MKAction

{

    public moveBy(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void genericAction(MKNode node)
    {
        node.setX(node.getX()+this.x);
        node.setY(node.getY()+this.y);

    }

}
