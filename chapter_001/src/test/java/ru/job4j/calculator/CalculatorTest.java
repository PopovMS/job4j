package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubtract4And4Then2() {
        Calculator calc = new Calculator();
        calc.subtract(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenDiv10On2Tren5() {
        Calculator calc = new Calculator();
        calc.div(10D, 2D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultiple2on8Then16() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 8D);
        double result = calc.getResult();
        double expected = 16D;
        assertThat(result, is(expected));
    }
}
