package com.archonlaboratories.archonlib.utility;

import java.util.*;

/**
 * Contains helper methods to normalize various collections.
 */
public final class Normalizer
{
    public static double[] normalize(Double[] values)
    {
        double[] normalized = new double[values.length];
        double sum = sum(Arrays.asList(values));
        if (sum == 0)
        {
            double factor = 1 / values.length;
            Arrays.fill(normalized, factor);
        }
        else
        {
            double factor = 1 / sum;
            for (int i = 0; i < values.length; i++)
            {
                normalized[i] = values[i] * factor;
            }
        }

        return normalized;
    }

    public static <T> HashMap<T, Double> normalize(Map<T, Double> values)
            throws InstantiationException, IllegalAccessException
    {
        return (HashMap<T, Double>) normalize(values, HashMap.class);
    }

    public static <T, E extends Map<T, Double>> Map<T, Double> normalize(Map<T, Double> values, Class<E> mapType)
            throws IllegalAccessException, InstantiationException
    {
        Map<T, Double> normMap = mapType.newInstance();
        double sum = sum(values.values());

        if (sum == 0) // vacuous case
        {
            double factor = 1 / values.size();
            for (T item : values.keySet())
                normMap.put(item, factor);
        }
        else
        {
            double factor = 1 / sum;
            for (T item : values.keySet())
                normMap.put(item, values.get(item) * factor);
        }

        return normMap;
    }

    public static double sum(Collection<Double> values)
    {
        double sum = 0;
        for (double item : values)
            sum += item;
        return sum;
    }
}
