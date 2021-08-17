package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenListAddress() {
        List<Profile> persons = List.of(
                new Profile(new Address("london", "baker", 1,2)),
                new Profile(new Address("moscow", "lenin", 1,2)),
                new Profile(new Address("paris", "versal", 1,2))
                );
        List<Address> expected = List.of(
                new Address("london", "baker", 1,2),
                new Address("moscow", "lenin", 1,2),
                new Address("paris", "versal", 1,2)
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(persons);
        assertThat(expected,is(rsl));
    }

    @Test
    public void whenListDoubleAddress() {
        List<Profile> persons = List.of(
                new Profile(new Address("london", "baker", 4,5)),
                new Profile(new Address("moscow", "lenin", 5,4)),
                new Profile(new Address("aprelevka", "aprel", 4,5)),
                new Profile(new Address("paris", "versal", 2,7)),
                new Profile(new Address("moscow", "lenin", 5,4))
        );
        List<Address> expected = List.of(
                new Address("aprelevka", "aprel", 4,5),
                new Address("london", "baker", 4,5),
                new Address("moscow", "lenin", 5,4),
                new Address("paris", "versal", 2,7)
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collectUniqueAddress(persons);
        assertThat(expected,is(rsl));
    }
}
