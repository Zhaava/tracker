package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrixToList() {
        int[][] matrix = {
                {4, 3, 1},
                {8, 2, 6},
                {2, 3, 7}
        };
        Matrix m = new Matrix();
        List rsl = m.inList(matrix);
        List expected = List.of(4, 3, 1, 8, 2, 6, 2, 3, 7);
        assertThat(rsl, is(expected));
    }
}
