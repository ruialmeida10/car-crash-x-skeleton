public class Person {
    
    private String name;
    private Hotel hotel;
    
    public Person(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }
    
    public String getName() {
        return name;
    }
    
    public void callingHotel() {
        //delegates to hotel the task
        hotel.checkIn();
    }
}
