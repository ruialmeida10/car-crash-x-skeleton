package io.codeforall.bootcamp;

import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

public class TestPosition {

    public static void main(String[] args) {

        Field.init(100,25);

        Position p = new Position();
        p.setRandom();
        System.out.println(p);
        p.moveRight(1);
        System.out.println(p);
        p.moveRight(200);
        System.out.println(p);



    }
}
