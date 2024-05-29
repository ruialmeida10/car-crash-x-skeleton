package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.Car;
import io.codeforall.bootcamp.cars.CarFactory;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 100;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
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

            // Move all cars
            moveAllCars(cars);

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars(Car[] cars) {
        boolean moved;
        for (int i = 0; i < cars.length ; i++) {
            if (cars[i].getCarType() == CarType.MUSTANG) {
                cars[i].move(cars, i);
                cars[i].move(cars, i);
            }else{
                cars[i].move(cars, i);
            }
        }
    }

    public void checkCrashed(int i, Car[] cars){
              for (int j = 0; j < cars.length; j++) {
                if (cars[i].getPos().getCol() == cars[j].getPos().getCol() && cars[i].getPos().getRow() == cars[j].getPos().getRow() && i != j){
                    cars[i].setCrashed(true);
                    return ;
                }
              }
    }

}
