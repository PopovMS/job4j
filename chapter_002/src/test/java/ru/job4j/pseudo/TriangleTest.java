package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mikhail Popov (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("  +  ")
                                .append(System.lineSeparator())
                                .append(" + + ")
                                .append(System.lineSeparator())
                                .append("+++++")
                                .toString()
                )
        );
    }
}
