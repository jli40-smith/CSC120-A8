Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent? 
My class represents the player character in a text-based adventure video game where the player is able to interact with items and, by the time that this game is finished for the final project, be able to navigate through rooms through walking and different parts of a map by flying. The player can change their size and rest at specific sections of the game, which, in a completed version of the game, may allow them to fit into small spaces, reach tall places, and restore the health points that they lose from encountering enemies or obstacles which hurt them. The player class takes in a Game class which specifies attributes of the game such as the rooms and areas available for the player to fly and walk to, or the items which are available to a player to add or remove from their inventory with the grab or drop methods. The Player is also able to undo the action of dropping an item. 

- What additional methods (if any) did you implement alongside those listed in the interface?
I implemented some constructors and accessors and manipulators for the Game and Item classes. They allow a player to 
interact with Items which have attributes that, for instance, allow Items to return a String description of what they are. The Game class aggregates Items in a Hashtable to track which Items are available to the Player. The Item class also has a overridden toString() method which prints out the description of an Item. 

- What worked, what didn't, what advice would you give someone taking this course in the future?

What worked was that I was able to implement all the of the methods specified in contract, and fulfill the rubric requirements. The code also compiles and behaves with methods which have functions that are related to their names and useful for a class representing
the Player character in a video game. 

What did not work is that I have not made a functional or interesting game yet, as that would require some restructuring and nonlinear room connections, as well as a connection between the Player currentRoom number and a Room object which allows there to be different items available depending on the value of currentRoom. I also would like for the player to be able to enter plain text commands like "USE APPLE"which will run code that allows them to play the game. 

I would recommend them look up interfaces on an online guide or video to better solidify the concept, and then also start the assignment early to have plenty of time to code and test out idea for their intended class. 
