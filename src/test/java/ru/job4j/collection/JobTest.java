package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpNamePriority = new JobIncByName();
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 1),
                new Job("Boris", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorIncByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobIncByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 1),
                new Job("Alex", 0)
        );
        assertThat(rsl, greaterThan(0));
    }
}
