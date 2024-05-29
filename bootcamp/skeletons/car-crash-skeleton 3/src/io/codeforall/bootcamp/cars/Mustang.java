package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.CarType;
import io.codeforall.bootcamp.field.Position;

public class Mustang extends Car{
    public Mustang(CarType carType, Position pos) {
        super(carType, pos);
    }

    @Override
    public String toString(){
        if (isCrashed())
            return "C";
        return "M";
    }

    @Override
    public void moveUp() {
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
}
