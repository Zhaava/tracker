package ru.job4j.poly;

public interface Transport {
    void move();

    void getPassengers(int amountOfPassengers);

    int refuel(int amountOfFuel);
}
