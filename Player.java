import java.util.ArrayList;

public class Player {
    String name = "Adventurer";
    private int hP = 20;
    private int size = 1; //Player is at normal size 
    private boolean canSleep = false;
    private Room currentRoom; 
    private ArrayList inventory = new ArrayList<String>(); 
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
        } else { 
            System.out.println("That item is not available");
        }
    }

    /** 
     * Drops an item and removes its name from the Player's inventory if it is in the inventory
     * @param item name of the item being dropped 
     * @return String name of the dropped item 
     */
    public String drop(String item) { 
        if (inventory.contains(item)) { 
            inventory.remove(item);
            return item;
        } else {
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
            game.allItems.remove(item); 
            System.out.println("You have used " + item);
        } else {
            System.out.println("You cannot use an item you don't possess");
        }
    }

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
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
        Game myGame = new Game(); 

        //Testing the allItems hashtable
        Item apple = new Item("apple", "A nutritious red fruit", true, false); 
        myGame.allItems.put("apple", apple);

        //Testing item grab, drop, and examine methods 
        Player playerOne = new Player(myGame); 
        playerOne.grab("apple"); 
        //playerOne.use("apple"); //This works 
        playerOne.examine("apple");
        playerOne.drop("apple"); 

        //Testing fly
        myGame.flyableMap[0][0] = "Area 1";
        myGame.flyableMap[1][1] = "Area 2"; 

        playerOne.fly(0, 0); 
        playerOne.fly(0, 1); 

    }

}
