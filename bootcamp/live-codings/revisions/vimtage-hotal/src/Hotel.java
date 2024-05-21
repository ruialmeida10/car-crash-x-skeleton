public class Hotel {
    
    //instance variables
    private String name;
    //room is a reference to an array of objects of type Room
    private Room[] rooms;
    
    
    //constructor method
    //initializing properties
    public Hotel(String name, int nrOfRooms) {
        this.name = name;
        rooms = new Room[nrOfRooms];
        
        for(int i = 0; i < nrOfRooms; i++) {
            rooms[i] = new Room();
        }
        
    }
   
    public void checkIn() {
        
        for(int i = 0; i < rooms.length; i++) {
            if(rooms[i].isAvailable()) {
                rooms[i].occupy();
                System.out.println("You are in room: " + (i + 1));
                System.out.println("room is available: " + rooms[i].isAvailable());
                return;
            }
        }
        System.out.println("hellllo");
    }
    
    
    
}
