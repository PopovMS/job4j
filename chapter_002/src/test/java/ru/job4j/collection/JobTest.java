package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class JobTest {
    @Test
    public void whenComparatorDescByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    @Test
    public void whenSortAbcAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        List<Job> result = List.of(
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Fix bug", 4),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new SortByNameJob().thenComparing(new SortByPriorityJob()));
        assertThat(jobs.toString(), is(result.toString()));
    }
}