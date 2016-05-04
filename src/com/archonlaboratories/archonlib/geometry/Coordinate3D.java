package com.archonlaboratories.archonlib.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 5/4/16.
 */
public class Coordinate3D
{
    private double x;
    private double y;
    private double z;

    public Coordinate3D(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate3D(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }

    public List<Double> getCoordinateAsList()
    {
        List<Double> tuple = new ArrayList<>(2);
        tuple.add(x);
        tuple.add(y);
        tuple.add(z);
        return tuple;
    }

    public double[] getCoordinateAsArray()
    {
        return new double[]{x, y, z};
    }

    public void offsetX(double offset)
    {
        this.x += offset;
    }

    public void offsetY(double offset)
    {
        this.y += offset;
    }

    public void offsetZ(double offset)
    {
        this.z += offset;
    }

    public double distanceTo(Coordinate3D other)
    {
        return distance(this, other);
    }

    public double manhattanDistanceTo(Coordinate3D other)
    {
        return manhattanDistance(this, other);
    }

    public static double distance(Coordinate3D first, Coordinate3D second)
    {
        double xDist = Math.abs(first.x - second.x);
        double yDist = Math.abs(first.y - second.y);
        double zDist = Math.abs(first.z - second.z);

        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2) + Math.pow(zDist, 2));
    }

    public static double manhattanDistance(Coordinate3D first, Coordinate3D second)
    {
        double xDist = Math.abs(first.x - second.x);
        double yDist = Math.abs(first.y - second.y);
        double zDist = Math.abs(first.z - second.z);

        return xDist + yDist + zDist;
    }
}
