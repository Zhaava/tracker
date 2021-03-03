package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void distanceBetweenPoints2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        assertThat(dist, closeTo(2, 0.001));
    }
    @Test
    public void distanceBetweenPoints3() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        double dist = a.distance(b);
        assertThat(dist, closeTo(3, 0.001));
    }

    @Test
    public void distanceBetweenPoints4() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        double dist = a.distance(b);
        assertThat(dist, closeTo(4, 0.001));
    }
}
