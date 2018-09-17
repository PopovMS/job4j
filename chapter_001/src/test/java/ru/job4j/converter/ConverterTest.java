package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Converter
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConverterTest {
    /**
     * Test метода rubleToDollar.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }
    /**
     * Test метода rubleToEuro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    /**
     * Test метода DollarToRuble.
     */
    @Test
    public void when1DollarToRublesThen60() {
        Converter converter = new Converter();
        int result = converter.DollarToRuble(1);
        assertThat(result, is(60));
    }
    /**
     * Test метода EuroToRuble.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.EuroToRuble(1);
        assertThat(result, is(70));
    }
}