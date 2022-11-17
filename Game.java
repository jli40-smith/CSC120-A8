import java.util.*;
/**
 * Aggregrates Items and includes other attributes of the map which allow a player to navigate through the game 
 */
public class Game {
    //Hashtable rooms = new Hashtable<Integer, String[]>();
    Hashtable<String, Item> allItems = new Hashtable<String, Item>(); 
    ArrayList<String> droppedItems = new ArrayList<String>(); 
    String[][] flyableMap = new String[2][2];
    int minRoom = -1; 
    int maxRoom = 4; 

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
