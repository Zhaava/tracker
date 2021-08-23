package ru.job4j.stream;

public class Car {
    private int speed;
    private int price;
    private String model;
    private String color;
    private String type;

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    static class Builder {
        private int speed;
        private int price;
        private String model;
        private String color;
        private String type;

        Builder buildSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.speed = speed;
            car.price = price;
            car.model = model;
            car.color = color;
            car.type = type;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildColor("red")
                .buildModel("BMV")
                .buildPrice(20000)
                .buildSpeed(200)
                .buildType("sedan")
                .build();
        System.out.println(car);
    }
}
