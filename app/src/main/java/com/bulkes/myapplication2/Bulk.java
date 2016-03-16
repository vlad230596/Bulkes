package com.bulkes.myapplication2;

import android.graphics.Path;
import android.util.Log;

/**
 * Created by progr on 10.03.2016.
 */
public class Bulk extends Unit
{
    protected  float        speed;
    protected  boolean      isMoved;
    protected  float        mass;

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    protected  float        dx;
    protected  float        dy;

    protected Indicator indicator;


    public Bulk(float _x, float _y, float _radius, int _color)
    {
        super(_x,_y, _radius, _color);
        mass = (float)Math.PI * radius * radius;
        isMoved = false;
        indicator = new Indicator();
        dx = 0f;
        dy = 0f;
    }
    public Bulk( float _x, float _y, float _radius)
    {
        this(_x, _y, _radius, Settings.UserDefaultColor);
    }
    //-------------------------------------------
    public float getSpeed()
    {
        return speed;
    }
    public void setSpeed(float _speed)
    {
        speed = _speed;
    }
    //-------------------------------------------
    public boolean getIsMoved()
    {
        return isMoved;
    }
    public void setIsMoved(boolean flag)
    {
        isMoved = flag;
    }
    public void addMass(int feed)
    {
        setMass((float) feed + mass);
    }
    public float getMass() {
        return mass;
    }

    public void setMass(float mass)
    {
        this.mass = mass;
        Log.v("Mass: ", String.valueOf(mass));
        setRadius((float) Math.sqrt((double) mass / Math.PI));
        Log.v("Radius: ", String.valueOf(radius));
    }
    public Indicator getIndicatorPosition(float x_end, float y_end)
    {
        indicator.getParameters(x,y,radius + 15, x_end, y_end);
        return indicator;//update
    }
    public Path getTriangle(float x_end, float y_end) {
        indicator.getParameters(x,y,radius + 15, x_end, y_end);
        return indicator.getTriangle(x, y, radius + 5 );
    }
}
