

import java.util.*;
public class TicTacToe {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// fill the board with '-'  (3 x 3) -> 9 square empty boxes 
		char[][] board = new char[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = '-';
			}
		}
		
		System.out.println("Let's play Tic Tac Toe game !\\nPlayer 1, what's your name? ");
		String p1 = sc.nextLine();
		System.out.println("Player 2, what's your name? ");
		String p2 = sc.nextLine();
		
		// print out the board 
		printBoard(board);
		
		boolean hasGameEnded = false;
		boolean isPlayer = true;
		
		// if game is not end - true (the game repeats)
		while(!hasGameEnded) {
			
			char ch = '-';
			if(isPlayer) {
				System.out.println(p1 + " turn now! (X): ");
				ch = 'x';
			} else {
				System.out.println(p2 + " turn now! (O): ");
				ch = 'o';
			}
			
			int row = 0, col = 0;
			while(true) {

				System.out.println("Enter row num (either 0 or 1 or 2): ");
				row = sc.nextInt();
				System.out.println("Enter col num (either 0 or 1 or 2): ");
				col = sc.nextInt();
				
				if(row < 0 || col <0 || row > 2 || col > 2) {
					System.out.println("Entered row and col are out of bounds. Try again!");
				} else if(board[row][col] != '-') {
					System.out.println("Someone had already made a move..");
					
				} else {
					break;
				}
			
			}
				
			board[row][col] = ch;
			printBoard(board);
			
			if(isWin(board) == 'x') {
				System.out.println(p1 + " won!");
				//System.exit(0);
				hasGameEnded = true;
			} else if(isWin(board) == 'o') {
				System.out.println(p2 + " won!");
				//System.exit(0);
				hasGameEnded = true;
			} else {
				if(checkWinOrDraw(board)) {
					System.out.println("It's a tie! The game is draw!!");
					hasGameEnded = true;
				} else {
					isPlayer = !isPlayer;
				}
			}
			
		}
		
	}
	
	// print the board
	public static void printBoard(char[][] board) {
		System.out.println("Board : ");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// check the conditions - for tic-tac-toe 
	// if the player with row-wise 'x' or 'o' has three equal (OR) with col-wise (OR) diagonal-wise same ==> game wins 
	public static char isWin(char[][] board) {
		
		// row
		for(int i=0; i<3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == board[i][2] && board[i][0] != '-') {
				return board[i][0]; // return any position of the board
			}
		}
		
		// col 
		for(int j=0; j<3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == board[0][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}
		
		// diagonal  - (primary diagonal)
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[0][0] && board[0][0] != '-') {
			return board[0][0];
		}
		
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] == board[2][0] && board[0][0] != '-') {
			return board[2][0];
		}
		
		return ' ';
	}
	
	// the game might have a chance to 'draw' (either player 1/player 2)
	public static boolean checkWinOrDraw(char[][] board) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// > if the board yet contains '-' then the game is not draw (chance either player 1 or player 2 win)
				// > else game is draw!!
				 if(board[i][j] == '-') {
					 return false;
				 }
			}
		}
		return true;
	}

}
