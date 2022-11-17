import java.util.*;
/**
 * Represents the player character in a single player game 
 */
public class Player {
    String name = "Adventurer";
    private int hP = 20;
    private int size = 1; //Player is at normal size 
    private boolean canSleep = false;
    private int currentRoom = 1; 
    private ArrayList<String> inventory = new ArrayList<String>(); 
    private String lastDroppedItem;  
    Game game; 

    public Player(Game game) { 
        this.game = game;
    }

/**
 * Decreases the player's size by one if they are enlarged or at normal size 
 * @return int size of the Player after shrinking
 */
    public Number shrink() {
        if (this.size >= 1 || this.size <= 2) {
            this.size -= 1;
        }
        System.out.println("You have shrunk");
        return this.size;
    }

    /**
     * Increases the player's size by one if they are shrunken or at normal size
     * @return int size of the Player after growing 
     */
    public Number grow() {
        if (this.size >= 0 || this.size <= 1) {
            this.size += 1;
        }
        System.out.println("You have grown");
        return this.size;
    }

    /**
     * Recharges the player's hP to 20 if canSleep is true 
     */
    public void rest() { 
        if (canSleep) { 
            this.hP = 20; 
            System.out.println("After a good nap, your health has been restored"); 
        } else { 
            System.out.println("This is not a safe place or time to rest");
        }
    }

    /** 
     * Grabs and adds an item's name to the Player's inventory 
     * @param item String name of the item being grabbed 
     */
    public void grab(String item) { 
        if (game.allItems.containsKey(item)) {
            inventory.add(item); 
            System.out.println("You grabbed " + item);
        } else { 
            System.out.println("That item is not available");
        }
    }

    /** 
     * Drops an item and removes its name from the Player's inventory if it is in the inventory
     * @param item name of the item being dropped 
     * @return String name of the dropped item 
     */
    private String drop(String item) { 
        if (inventory.contains(item)) { 
            inventory.remove(item);
            this.lastDroppedItem = item; 
            System.out.println("You dropped " + item);
            return item;
        } else {
            System.out.println("You cannot drop an item you do not own");
            return item; 
        }

    }

    /**
     * Allows player to examine an Item by printing out an item's description 
     * @param item which is to be examined 
     */
    public void examine(String item) { 
        if (game.allItems.containsKey(item)) {
            System.out.println((game.allItems.get(item)));
        } else { 
            System.out.println("That item is not available");
        }
    }
    
    /**
     * Uses an Item and removes it from the Player's inventory and the allItems Hashtable if it is in the Player's inventory, 
     * @param item to be used 
     */
    public void use(String item) { 
        if (inventory.contains(item)) { 
            this.drop(item);
            //game.allItems.remove(item); //causes problems because items picked up again won't be able to be examined
            System.out.println("You have used " + item);
        } else {
            System.out.println("You cannot use an item you don't possess");
        }
    }

    /**
     * Allows a player to pick up the item which was last dropped and add it back into their inventory 
     */
    public void undo() { 
        if (lastDroppedItem == null) {
            System.out.println("There is nothing to pick up again");
        } else {
            this.inventory.add(lastDroppedItem); 
            System.out.println("The dropped " + lastDroppedItem + " was added back to your inventory");
            this.lastDroppedItem = null; 
        }
    }

    /**
     * Allows the player to fly to an area of the flyableMap if there is a area present at the coordinates x,y
     * @param x horizontal coordinate on the flyableMap array
     * @param y vertical coordinate on the flyableMap array
     * @return boolean showing whether or not the Player can fly to those coordinates 
     */
    public boolean fly(int x, int y) { 
        if (game.flyableMap[x][y]==null) { 
            System.out.println("There is nothing out here to fly to");
            return false; 
        } else {
            System.out.println("You have flown to " + game.flyableMap[x][y]);
            return true; 
        }
    }

    /**
     * Allows a Player to walk left and right through 
     * @param direction String representing the direction the Player wants to walk 
     * @return boolean showing whether or not the Player was able to walk to another room in the specified direction
     */
    public boolean walk(String direction) { 
        direction = direction.toLowerCase(); 
        if (direction.equals("left"))  { 
            currentRoom -= 1; 
        } else if (direction.equals("right")) {
            currentRoom += 1;
        }

        if (currentRoom > game.minRoom && currentRoom < game.maxRoom) {
            System.out.println("You have walked " + direction + " to Room " + currentRoom);
            return true; 
        } else {
            System.out.println("There is no other room to the  " + direction + " of this one");
            return false; 
        }
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
        Game myGame = new Game(); 

        //Testing the allItems hashtable
        Item apple = new Item("apple", "A nutritious red fruit", true, false); 
        myGame.allItems.put("apple", apple);

        //Testing item grab, drop, undo, and examine methods 
        Player playerOne = new Player(myGame); 
        playerOne.grab("apple"); 
        //playerOne.use("apple"); //This works 
        playerOne.examine("apple");
        playerOne.drop("apple"); 
        playerOne.undo();
        playerOne.examine("apple");
        playerOne.undo();
        playerOne.use("apple");

        //Testing fly
        myGame.flyableMap[0][0] = "Area 1";
        myGame.flyableMap[1][1] = "Area 2"; 

        playerOne.fly(0, 0); 
        playerOne.fly(0, 1); 

        //Testing walk 
        playerOne.walk("left"); 
        playerOne.walk("left"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 

    }

}
