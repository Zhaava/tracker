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
        List<Integer> idItems = Arrays.asList(
                items.get(0).getId(),
                items.get(1).getId(),
                items.get(2).getId(),
                items.get(3).getId(),
                items.get(4).getId()
        );
        assertThat(idItems, is(Arrays.asList(1,2,3,4,5)));
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
        List<Integer> idItems = Arrays.asList(
                items.get(0).getId(),
                items.get(1).getId(),
                items.get(2).getId(),
                items.get(3).getId(),
                items.get(4).getId()
        );
        assertThat(idItems, is(Arrays.asList(5,4,3,2,1)));
    }
}
