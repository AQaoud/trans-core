package com.pos.transCore.utils;

public class Utilities {

    /**
     * Comparing two doubles. Note: to avoid double
     * comparisons known issues, the values will be formatted
     * using java money library which means some small acceptable
     * margins
     *
     * @param a
     * @param b
     * @param eps
     * @return
     */
    public static boolean equal(double a, double b, double eps) {
        return Math.abs(a - b) < eps;
    }



}
