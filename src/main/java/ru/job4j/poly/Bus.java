package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Bus is moving");
    }

    @Override
    public void getPassengers(int amountOfPassengers) {
        System.out.println(amountOfPassengers + " passengers on board");
    }

    @Override
    public int refuel(int amountOfFuel) {
        return amountOfFuel * 30;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.move();
        bus.getPassengers(15);
        System.out.println("Refuel costs " + bus.refuel(20) + " rubles");
    }
}
