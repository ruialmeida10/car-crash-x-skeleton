package io.codeforall.bootcamp;

public class Calculator {
    
    //properties
    private String colour;
    private String brand;
    
    //constructor, initializes properties
    public Calculator(String brand, String colour) {
        this.brand = brand;
        this.colour = colour;
    }
    
    //methods
    
    public int add(int num1, int num2) {
        System.out.println("calling add int");
        return num1 + num2;
    }
    
    public double add(double num1, double num2) {
        
        System.out.println("calling add double");
        return num1 + num2;
    }
    
    //setters and getters
    
    public String getColour() {
        return this.colour;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public void setColour(String colour) {
        if(colour.equals("baby pink")) {
            System.out.println("no no no... chose another colour");
            return;
        }
        this.colour = colour;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
}
