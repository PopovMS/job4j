package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test.
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test метода add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test метода subtract.
     */
    @Test
    public void whenSubtract4And4Then2() {
        Calculator calc = new Calculator();
        calc.subtract(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test метода div.
     */
    @Test
    public void whenDiv10On2Tren5() {
        Calculator calc = new Calculator();
        calc.div(10D, 2D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
    @Test
    /**
     * Test метода multiple.
     */
    public void whenMultiple2on8Then16() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 8D);
        double result = calc.getResult();
        double expected = 16D;
        assertThat(result, is(expected));
    }
}
