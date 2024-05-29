package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.CarType;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private CarType carType;

    private boolean isCrashed = false;

    public Car(CarType carType, Position pos) {
        this.pos = pos;
        this.carType = carType;
    }

    public CarType getCarType(){
        return carType;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    public void setCrashed(boolean isCrashed) {
        this.isCrashed = isCrashed;
    }

    public void move(Car[] cars,int i){
        boolean moved = false;

        while (!moved && !cars[i].isCrashed()) {
            switch ((int) (Math.random() * 4)) {
                case 0: //up
                    if (cars[i].getPos().getRow() == 0) {
                        break;
                    }
                    cars[i].moveUp();
                    moved = true;
                    break;
                case 1: //down
                    if (cars[i].getPos().getRow() == Field.getHeight() - 1) {
                        break;
                    }
                    cars[i].moveDown();
                    moved = true;
                    break;
                case 2: //left
                    if (cars[i].getPos().getCol() == 0) {
                        break;
                    }
                    cars[i].moveLeft();
                    moved = true;
                    break;
                case 3: //right
                    if (cars[i].getPos().getCol() == Field.getWidth() - 1) {
                        break;
                    }
                    cars[i].moveRigth();
                    moved = true;
            }
        }
        checkCrashed(i, cars);//check crash

    }

    public void checkCrashed(int i, Car[] cars){
        for (int j = 0; j < cars.length; j++) {
            if (cars[i].getPos().getCol() == cars[j].getPos().getCol() && cars[i].getPos().getRow() == cars[j].getPos().getRow() && i != j){
                cars[i].setCrashed(true);
                return ;
            }
        }
    }

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRigth();


}
