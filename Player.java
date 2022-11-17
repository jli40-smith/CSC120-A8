import java.util.ArrayList;

public class Player {
    String name = "Adventurer";
    private int hP = 20;
    private int size = 1; //Player is at normal size 
    private boolean canSleep = false;
    private Room currentRoom; 
    private ArrayList inventory; 
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
    void rest() { 
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
    void grab(String item) { 
        inventory.add(item); 
    }

    /** 
     * Drops an item and removes its name from the Player's inventory
     * @param item name of the item being dropped 
     */
    String drop(String item) { 
        inventory.remove(item);
        return item; 
    }

    
    


    public static void main(String[] args) {
        Game myGame = new Game(); 

        //Testing all items list 
        Item apple = new Item("apple", "A nutritious red fruit", true, false); 
        myGame.allItems.put("apple", apple);

        new Player(myGame); 

    }


}
