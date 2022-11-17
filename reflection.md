Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent? 
My class represents the player character in a text-based adventure video game where the player is able to interact with items and, by the time that this game is finished for the final project, be able to navigate through rooms through walking and different parts of a map by flying. The player can change their size and rest at specific sections of the game so that they may fit into small spaces, reach tall places, and restore the health points that they lose from encountering enemies or obstacles which hurt the player-- all of which are additional features which may be implemented in a later version of the game. 

- What additional methods (if any) did you implement alongside those listed in the interface?
I implemented some constructors and accessors and manipulators for the Game and Item classes. They allow a player to 
interact with Items which have attributes that, for instance, allow Items to return a String description of what they are. The Game class aggregates Items in a Hashtable to track which Items are available to the Player or unavailable (for example, after those Items are used, the references to them are lost). 

- What worked, what didn't, what advice would you give someone taking this course in the future?

What worked was that I was able to implement all the of the methods specified in contract, and fulfill the rubric requirements. The code also compiles and behaves with methods which have functions that are related to their names and useful for a class representing
the Player character in a video game. 

What did not work is that I have not made a functional or interesting game yet, as that would require some restructuring and nonlinear room connections, as well as a connection between the Player currentRoom number and a Room object which allows there to be different items available depending on the value of currentRoom. I also would like for the player to be able to enter plain text commands like "USE APPLE"which will run code that allows them to play the game. 

I would recommend them look up interfaces on an online guide or video to better solidify the concept, and then also start the assignment early to have plenty of time to code and test out idea for their intended class. 
