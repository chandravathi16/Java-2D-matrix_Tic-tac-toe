# Java-2D-matrix_Tic-tac-toe

Algorithm to build Tic-tac-toe project 
-------------------------------------
steps :
1. Create a Tic-tac-toe board and fill it dashes.
2. Ask a user to need two players to play a game.
3. Create a function that needs to print a board (9 square boxes).
4. Keep repeating the game until it false 
   	i) Keep asking the user to enter row and column until they are valid.
       ii) Set the right position on the board with proper symbol (either 'x' or 'o').
      iii) Handle the conditions such as -
		-- If the entered row and col are out of bounds then try again asking row,col
		-- If the position of row and col already filled, then print a statement that 'made a move already!'
5. Create a function to handle the Tic-tac-toe conditions
	- If the player with row-wise 'x' or 'o' has three equal (OR) 
	- with col-wise (OR)
	-  diagonal-wise(primary/secondary diagonal) same then game wins 
6.Check if the game has ended or a tie/draw. If the board still contains spaces/'-' then game is not draw
