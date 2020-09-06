package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchAttTest {
    @Test
    public void whenNameFilter() {
        List<Attachment> input = new ArrayList<>();
        input.add(new Attachment("Ivan", 150));
        input.add(new Attachment("Mike", 160));
        input.add(new Attachment("Ivan", 90));
        List<Attachment> expect = Arrays.asList(
                new Attachment("Ivan", 150),
                new Attachment("Ivan", 90)
        );
        List<Attachment> result = new SearchAtt().filterName(input, "Ivan");
        assertThat(result.toString(), is(expect.toString()));
    }
    @Test
    public void whenSizeFilter() {
        List<Attachment> input = new ArrayList<>();
        input.add(new Attachment("Ivan", 150));
        input.add(new Attachment("Mike", 160));
        input.add(new Attachment("Ivan", 90));
        List<Attachment> expect = Arrays.asList(
                new Attachment("Ivan", 150),
                new Attachment("Mike", 160)
        );
        List<Attachment> result = new SearchAtt().filterSize(input, 100);
        assertThat(result.toString(), is(expect.toString()));
    }
}
