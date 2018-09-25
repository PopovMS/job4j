package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.condition.Point;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test Point
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {
    /**
     * Test метода distanceTo.
     */
    @Test
    public void distanceToTest() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.472, 0.0002));
    }
}
