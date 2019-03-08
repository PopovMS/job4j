package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayMergeTest {
    @Test
    public void whenRangesDoNotIntersect() {
        ArrayMerge merge = new ArrayMerge();
        int[] first = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40};
        int[] second = new int[]{50, 55, 72, 80, 101};
        int[] result = merge.merge(first, second);
        int[] expect = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40, 50, 55, 72, 80, 101};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRangesDoNotIntersect2() {
        ArrayMerge merge = new ArrayMerge();
        int[] second = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40};
        int[] first = new int[]{50, 55, 72, 80, 101};
        int[] result = merge.merge(first, second);
        int[] expect = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40, 50, 55, 72, 80, 101};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRangesIntersect() {
        ArrayMerge merge = new ArrayMerge();
        int[] first = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40};
        int[] second = new int[]{11, 12, 13, 15, 16};
        int[] result = merge.merge(first, second);
        int[] expect = new int[]{2, 3, 10, 11, 12, 13, 15, 15, 16, 17, 18, 21, 22, 24, 30, 40};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRangesIntersect2() {
        ArrayMerge merge = new ArrayMerge();
        int[] second = new int[]{2, 3, 10, 15, 17, 18, 21, 22, 24, 30, 40};
        int[] first = new int[]{11, 12, 13, 15, 16};
        int[] result = merge.merge(first, second);
        int[] expect = new int[]{2, 3, 10, 11, 12, 13, 15, 15, 16, 17, 18, 21, 22, 24, 30, 40};
        assertThat(result, is(expect));
    }
}
