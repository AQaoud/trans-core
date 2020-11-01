package com.pos.transValidator.com.pos.transValidator.utils;

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
    public static boolean almostEqual(double a, double b, double eps) {
        return Math.abs(a - b) < eps;
    }



}
