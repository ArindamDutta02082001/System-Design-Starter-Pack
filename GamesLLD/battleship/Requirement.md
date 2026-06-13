### Problem Statement: Battleship Game

Write code for design of Battleship Game: https://en.wikipedia.org/wiki/Battleship_(game)

#### Rules of the Game
1. There are 2 players in the game. - done
2. Each Person has two boards, one where he places his own ships, one where he tracks
   the missiles he has fired. Each board is of size 10x10. - done
3. Each person can place 5 ships on his board  - done
   - Carrier of length 5
   - Battleship of length 4
   - Cruiser of length 3
   - Submarine of length 3
   - Destroyer of length 2
4. If all the spots on a ship are hit, then ship is sunk. done
5. The first player to sink all 5 ships of the opposing player wins the game. done
6. Interviewer extension :
      can you apply different methods of player picking + winning strategy 
7. Interview extension (more advanced)
      can you apply observer pattern to get notification for each move
      can you apply undo/redo move feature

######  Bonus Requirement:
You don’t need to code this up, but explain how will you extend your design to
   allow people to play over the network (p2p without having a central server).

#### Guidelines
1. We will be looking for the Low-Level Design including good class structure, entities and
   how they interact, good abstraction, good separation of concerns, etc
2. You will need to code the “Game Loop”.
3. You don’t need to bother with the code that “draws” the game or UI interactions, you can
   mock the function for eg. “drawBoard(List<Ship> ships)” and assume it draws the board
   with the ships on it. You can also assume a “takeInput(Player player)” function that gets
   the play that the current player wishes to make.
   1. Bonus: Take the input from the console. For eg. player can say “Fire C5” and you
   fire a missile at C5 or “Draw Board” and you print the current state of the board to
   the player.
4. You can choose any language, however, it needs to be a runnable code.

#### Assumptions
   Please make the required assumptions, for instance, players can only join before the
   game starts, but MAKE SURE YOU LIST THEM IN A README FILE along with the code.