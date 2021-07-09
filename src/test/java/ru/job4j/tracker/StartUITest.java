package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(new ArrayList<>() {{add("0"); add("Item name"); add("1");}});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new CreateAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new ArrayList<>() {{add("0"); add(String.valueOf(item.getId()));
                                                    add(replacedName); add("1");}});
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new ReplaceAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new ArrayList<>() {{add("0"); add(String.valueOf(item.getId())); add("1");}});
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new DeleteAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>() {{add("0");}});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show item"));
        Input in = new StubInput(new ArrayList<>() {{add("0");add("1");}});
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new ShowAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln +
                "0. Show all items" + ln +
                "1. Exit" + ln +
                "=== Show all Items ====" + ln +
                item + ln +
                "Menu." + ln +
                "0. Show all items" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindByIdItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Id item"));
        Input in = new StubInput(new ArrayList<>() {{add("0"); add(String.valueOf(item.getId())); add("1");}});
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new FindByIdAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln +
                "0. Find item by ID" + ln +
                "1. Exit" + ln +
                "=== Find item by id ====" + ln +
                item + ln +
                "Menu." + ln +
                "0. Find item by ID" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindByNameItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name item"));
        Input in = new StubInput(new ArrayList<>() {{add("0"); add(String.valueOf(item.getName())); add("1");}});
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new FindByNameAction(out)); add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln +
                "0. Find items by name" + ln +
                "1. Exit" + ln +
                "=== Find items by name ====" + ln +
                item + "" + ln +
                "Menu." + ln +
                "0. Find items by name" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>() {{add("9"); add("0");}});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>() {{add(new ExitAction());}};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}
