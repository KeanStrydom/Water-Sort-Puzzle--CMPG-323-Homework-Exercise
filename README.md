# Water-Sort-Puzzle--CMPG-323-Homework-Exercise
This is my CMPG 323 homework. This repository includes the code of the solution that has had the greatest impact on my software development career up to now.

## Description of my code and problem solving approach.
My code is the solution to a Watersort Puzzle.

The Watersort Puzzle is basically a game where one has to move around different colors of "water-drops" between different "bottles" until each bottle contains only one color of "water". The game works as follows:
1) There are 5 bottles.
2) Each bottle can contain a maximum of 4 drops of water.
3) Only 1 drop of water can be moved at a time.
4) When a drop of water is moved it can only be inserted into another bottle if that bottle has the same color water drop on top, as the color being moved and if that bottle has 3 or less drops of water in it.
5) When 4 of the bottles have 4 drops of water and all 4 drops are the same color the user has won the game and the program is terminated.

My program solves the problem by using an array of stacks to represent the bottle(s).
The stack is an extension of an ArrayList data type.
A stack follows the last in first out principle.
When the main method executes the bottles are randomly "filled" with water drops of different colors:
  1) A random bottle number is generated.
  2) The program checks if the bottle is already full.
  3) If it is not full, it is chosen to be filled with one drop, otherwise another bottle number is generated.
  4) A random number is then generated to represent a color.
  5) The program checks if the same color has already been chosen 4 times, if not the selected bottle is filled with a droplet of that color, otherwise another color number is generated.
  6) Whenever a droplet is inserted into a bottle, a counter is increased to keep track of the amount of water drops. When this counter reaches the number 12 the process of filling the bottles is terminated, as this means that the bottles are filled with 3 different colors of 4 drops each.
  7) As mentioned earlier each bottle is represented as a stack. This means that you need to pop (remove) the color that is on top before being able to reach the colors underneath.
A loop is then executed inside the main method that will continue until all of the bottles contain a uniform color. This is done by a method which checks if every item inside a particular stack (bottle) has the same data value.
All of the bottles, with their contents, are then shown and the user may choose to move around one colored water drop from one bottle to another, provided that the user conforms to the rules of the game. The data value (color) is popped (removed) from the source stack (bottle) and pushed (inserted) into another stack (bottle).
Once the user has solved the puzzle a congratulatory message is displayed and the program is terminated.

The reason this code had such a great impact on my software development career is because it uses more complex data structures than the average programs I created at university level. This problem forced me to think critically about the problem I had to solve and it was very important not to overcomplicate things. Overcomplicating programs may lead to a waste of computer resources, which is ,of course, not an optimal situation. Most users to do not have high spec computers. This makes efficient resource usage of the utmost importance.
