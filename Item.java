public class Item {
    private String name;
    private String description;
    //boolean consumable;
    private boolean consumed; 
    private boolean inHands = false;

    /** 
     * Constructs an Item
     */
    public Item(String name, String description, boolean consumable, boolean consumed) { 
        this.name = name; 
        this.description = description; 
        //this.consumable = consumable; 
    }

    public static void main(String[] args) {
        
    }
}
