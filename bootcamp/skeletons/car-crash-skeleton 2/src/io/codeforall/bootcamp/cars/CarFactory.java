package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.CarType;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

public class CarFactory {

    public static Car getNewCar() {
        if (randomCarType() == CarType.MUSTANG) {
            return new Mustang(CarType.MUSTANG, randomPosition());
        }
        return new Fiat(CarType.FIAT,randomPosition());
        }




     public static Position randomPosition(){
        return new Position((int)(Math.random()* Field.getWidth()), (int)(Math.random()*Field.getHeight()));
     }

    public static CarType randomCarType(){
        return CarType.values()[(int)Math.round(Math.random())];
            
    }

}

