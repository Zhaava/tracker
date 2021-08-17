package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.compare;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> collectUniqueAddress(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted((s1,s2) -> s1.getCity().compareTo(s2.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
