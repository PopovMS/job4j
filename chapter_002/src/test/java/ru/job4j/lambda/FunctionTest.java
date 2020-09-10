package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;



public class FunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diap.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Diap.diapason(5, 8, x -> 2 * (x * x) + 2 * x + 1);
        List<Double> expected = Arrays.asList(61D, 85D, 113D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenExponentialFunction() {
        List<Double> result = Diap.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}
