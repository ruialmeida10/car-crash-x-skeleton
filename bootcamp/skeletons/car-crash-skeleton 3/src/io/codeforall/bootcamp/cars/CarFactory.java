package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.CarType;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

public class CarFactory {

    public static Car getNewCar() {

        Car car = null;
        CarType type = CarType.values()[(int)(Math.random() * CarType.values().length - 1)];
        if (type == CarType.MUSTANG) {
            car = new Mustang(CarType.MUSTANG, randomPosition());
        } else if (type == CarType.FIAT) {
            car = new Fiat(CarType.FIAT, randomPosition());
        }
       // } else if (type == CarType.TOWTRUCK){
         //car =new Towtruck(CarType.TOWTRUCK, new Position(1,1));
        //}
        return car;
    }





     public static Position randomPosition(){
        return new Position((int)(Math.random()* Field.getWidth()), (int)(Math.random()*Field.getHeight()));
     }



}

