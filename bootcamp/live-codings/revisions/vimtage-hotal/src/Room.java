public class Room {
    
    //declaring properties, instance variables
    //access, type, name of variable
    private int roomNr;
    // declaring and initializing the variable with the value true
    private boolean available = true;
    
    //method that changes available to false
    //access, type of return, name of method, arguments(optional)
    public void occupy() {
       // = sign is used to attribute value to a variable
       this.available = false;
    }
    
    public void vacate() {
        this.available = true;
    }
    
    //this is a getter
    public boolean isAvailable() {
        return available;
    }
    
}
