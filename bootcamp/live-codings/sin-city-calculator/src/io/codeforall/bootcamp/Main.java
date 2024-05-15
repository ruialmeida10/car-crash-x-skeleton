package io.codeforall.bootcamp;

public class Main {

    public static void main(String[] args) {
        
        //creates instance of type Calculator
        Calculator calc1 = new Calculator("casio", "red");
        //calc1.brand = "casio";
        //calc1.colour = "red";
        
        //creates instance of type Calculator
        Calculator calc2 = new Calculator("texas", "blue");
        //calc2.brand = "texas";
        //calc2.colour = "blue";
        
        
        System.out.println("Calculator calc1 is a " + calc1.getBrand()+ " , of colour " + calc1.getColour());
        System.out.println("Calculator calc2 is a " + calc2.getBrand() + " , of colour " + calc2.getColour());
        
        //sets new value to property colour
        calc2.setColour("baby pink");
        
        System.out.println("Calculator calc2 is a " + calc2.getBrand() + " , of colour " + calc2.getColour());
        
        //calls add method and saves the return in variable result
        int result = calc2.add(6, 3);
        System.out.println(result);
        
        int result2 = calc1.add(result, 4);
        System.out.println(result2);
        
        //calls overloaded add method
        double result3 = calc1.add(3.4, 5.6);
    }
}
