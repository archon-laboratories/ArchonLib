package com.archonlaboratories.archonlib.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a 2-Dimensional Coordinate and Associated Operators.
 */
public class Coordinate2D
{
    private double x;
    private double y;

    public Coordinate2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordinate2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordinate2D(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public List<Double> getCoordinateAsList()
    {
        List<Double> tuple = new ArrayList<>(2);
        tuple.add(x);
        tuple.add(y);
        return tuple;
    }

    public double[] getCoordinateAsArray()
    {
        return new double[]{x, y};
    }

    public void offsetX(double offset)
    {
        this.x += offset;
    }

    public void offsetY(double offset)
    {
        this.y += offset;
    }

    public double distanceTo(Coordinate2D other)
    {
        return distance(this, other);
    }

    public double manhattanDistanceTo(Coordinate2D other)
    {
        return manhattanDistance(this, other);
    }

    public static double distance(Coordinate2D first, Coordinate2D second)
    {
        double xDist = Math.abs(first.x - second.x);
        double yDist = Math.abs(first.y - second.y);
        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
    }

    public static double manhattanDistance(Coordinate2D first, Coordinate2D second)
    {
        double xDist = Math.abs(first.x - second.x);
        double yDist = Math.abs(first.y - second.y);
        return xDist + yDist;
    }

}
