public class Room { 
    int roomNumber; 
    boolean isLocked; 

    /**
     * Constructor for a room 
     * @param roomNumber the int number that refers to the room 
     * @param isLocked boolean representing whether or not a player can enter the room 
     */
    public Room(int roomNumber, boolean isLocked) { 
        this.roomNumber = roomNumber;
        this.isLocked = isLocked; 
    }
}