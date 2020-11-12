package com.pos.transcore.utils;

/**
 * Utilities methods class.
 */
public class Utilities {

    /**
     * Comparing two doubles. Note: to avoid double
     * comparisons known issues, a passed margin of difference will
     * be used in comparison.
     *
     * @param a - first double
     * @param b - second double
     * @param ignoreDiff - double difference to ignore
     * @return true if they are equal. False otherwise.
     */
    public static boolean equal(double a, double b, double ignoreDiff) {
        return Math.abs(a - b) < ignoreDiff;
    }


}
