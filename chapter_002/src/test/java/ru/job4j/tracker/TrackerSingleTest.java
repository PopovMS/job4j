package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {
    @Test
    public void whenCreateTwoTrackerSingEnum() {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker.equals(tracker2), is(true));
    }
    @Test
    public void whenCreateTwoTrackerSingSF() {
        TrackerSingleSF tracker = TrackerSingleSF.getInstance();
        TrackerSingleSF tracker2 = TrackerSingleSF.getInstance();
        assertThat(tracker.equals(tracker2), is(true));
    }
    @Test
    public void whenCreateTwoTrackerSingSFF() {
        TrackerSingleSFF tracker = TrackerSingleSFF.getInstance();
        TrackerSingleSFF tracker2 = TrackerSingleSFF.getInstance();
        assertThat(tracker.equals(tracker2), is(true));
    }
    @Test
    public void whenCreateTwoTrackerSingSFC() {
        TrackerSingleSFC tracker = TrackerSingleSFC.getInstance();
        TrackerSingleSFC tracker2 = TrackerSingleSFC.getInstance();
        assertThat(tracker.equals(tracker2), is(true));
    }
}
