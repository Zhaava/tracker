package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapasonCalc(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = Diapason.diapasonCalc(5, 8, x -> Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = List.of(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        final int a = 3;
        List<Double> result = Diapason.diapasonCalc(5, 8, x -> Math.pow(a, x - 1) + 1);
        List<Double> expected = List.of(82D, 244D, 730D);
        assertThat(result, is(expected));
    }
}
