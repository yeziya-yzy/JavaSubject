package day50.exercises1;

import java.util.Random;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/5
 */
class Solution {
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(u);
        return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
    }
}

