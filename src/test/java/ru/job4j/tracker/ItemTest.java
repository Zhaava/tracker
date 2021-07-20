package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void whenSortItemsUp() {
        List<Item> items = Arrays.asList(
                new Item(3,"Sergey"),
                new Item(1,"Ivan"),
                new Item(4,"Alexey"),
                new Item(2,"Petr"),
                new Item(5,"Vladimir")
        );
        Collections.sort(items, new SortByIdItemUp());
        assertThat(items, is(Arrays.asList(
                new Item(1,"Ivan"),
                new Item(2,"Petr"),
                new Item(3,"Sergey"),
                new Item(4,"Alexey"),
                new Item(5,"Vladimir")
        )));
    }

    @Test
    public void whenSortItemsDown() {
        List<Item> items = Arrays.asList(
                new Item(3,"Sergey"),
                new Item(1,"Ivan"),
                new Item(4,"Alexey"),
                new Item(2,"Petr"),
                new Item(5,"Vladimir")
        );
        Collections.sort(items, new SortByIdItemDown());
        assertThat(items, is(Arrays.asList(
                new Item(5,"Vladimir"),
                new Item(4,"Alexey"),
                new Item(3,"Sergey"),
                new Item(2,"Petr"),
                new Item(1,"Ivan")
        )));
    }
}
