package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.CarType;
import io.codeforall.bootcamp.field.Position;

public class Towtruck extends Car {
    public Towtruck(CarType carType, Position pos) {
        super(carType, pos);
    }



    @Override
    public void moveUp(){
        getPos().setRow(getPos().getRow() - 1);
    }
    @Override
    public void moveDown() {
        getPos().setRow(getPos().getRow() + 1);
    }
    @Override
    public void moveLeft() {
        getPos().setCol(getPos().getCol() - 1);
    }
    @Override
    public void moveRigth() {
        getPos().setCol(getPos().getCol() + 1);
    }

    @Override
    public String toString(){
        if (isCrashed())
            return "C";
        return "TOW_TRUCK";
    }

    @Override
    public void move(Car[] cars,int i){
        Car car = carCrashed(cars);
        if (car != null) {
            if (car.getPos().getCol() != getPos().getCol()) {
                moveHorizontal(car.getPos().getCol());
            }
            else if (car.getPos().getRow() != getPos().getRow()) {
                moveVertical(car.getPos().getRow());
            }
            else {
                tow(cars, getPos().getCol(), getPos().getRow());
            }
        }
    }

    private void tow(Car[] cars, int col, int row) {
        for(Car car : cars) {
            if (car.getPos().getRow() == row && car.getPos().getCol() == col) {
                car.setPos(getPos());
                car.setRebooked();
                car.setCrashed(false);
                car = null;
            }
        }
    }

    private void moveHorizontal(int col) {
        if (getPos().getCol() - col < 0)
            moveRigth();
        else
            moveLeft();
    }

    private void moveVertical(int row) {
        if (getPos().getRow() - row < 0)
            moveDown();
        else
            moveUp();
    }

    private Car carCrashed(Car[] cars) {
        for (int i = 0; i < cars.length - 1 ; i++) {
            if(cars[i].isCrashed()){
                return cars[i];
            }
        }
        return null;
    }

    public void moveTowtruck(){

    }
}

