package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.Car;
import io.codeforall.bootcamp.cars.CarFactory;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];

        collisionDetector = new CollisionDetector(cars);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
            cars[i].setCollisionDetector(collisionDetector);
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

            // Update screen
            Field.draw(cars);

        }

    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }

    }

}
