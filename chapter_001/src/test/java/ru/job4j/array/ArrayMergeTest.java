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
    public void whenRangesIntersect() {
        ArrayMerge merge = new ArrayMerge();
        int[] first = new int[]{2, 3, 10};
        int[] second = new int[]{1, 4};
        int[] result = merge.merge(first, second);
        int[] expect = new int[]{1, 2, 3, 4, 10};
        assertThat(result, is(expect));
    }
}
