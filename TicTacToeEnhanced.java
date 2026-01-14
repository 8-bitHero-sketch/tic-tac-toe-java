package Labs;
import java.util.Scanner;
public class TicTacToeEnhanced {
	private static String[] gameBoard = new String[9];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean playAgain = true;
		
		while (playAgain) {
			playGame();
			
			System.out.println("\nWould you like to play again? (y/n): ");
			String response = scanner.next().toLowerCase();
			playAgain = response.equals("y") || response.equals("yes");
		}
		
		System.out.println("\nThanks for playing!");
		scanner.close();
	}
	
	/**
	 * Main game loop
	 */
	public static void playGame() {
		System.out.println("\n=================================");
		System.out.println("    Welcome to Tic Tac Toe!");
		System.out.println("=================================");
		System.out.println("Player X goes first.\n");
		
		initialize();
		display();
		
		int turn = 0;
		boolean gameWon = false;
		String currentPlayer = "X";
		
		while (turn < 9 && !gameWon) {
			System.out.println("\nPlayer " + currentPlayer + ", enter your move (1-9): ");
			
			// Input validation
			int move = getValidMove();
			
			// Place move
			gameBoard[move - 1] = currentPlayer;
			turn++;
			
			// Display updated board
			display();
			
			// Check for winner (earliest win is on turn 5)
			if (turn >= 5) {
				gameWon = checkWinStatus(currentPlayer);
				if (gameWon) {
					System.out.println("\n🎉 Congratulations! Player " + currentPlayer + " wins!");
					break;
				}
			}
			
			// Switch players
			currentPlayer = currentPlayer.equals("X") ? "O" : "X";
		}
		
		// Check for draw
		if (!gameWon && turn == 9) {
			System.out.println("\n🤝 It's a draw! Well played!");
		}
	}
	
	/**
	 * Gets a valid move from the player with error checking
	 * @return valid move (1-9) for an available space
	 */
	public static int getValidMove() {
		int move = -1;
		boolean validInput = false;
		
		while (!validInput) {
			if (scanner.hasNextInt()) {
				move = scanner.nextInt();
				
				// Check if move is in range
				if (move < 1 || move > 9) {
					System.out.println("Invalid input! Please enter a number between 1 and 9: ");
				}
				// Check if space is available
				else if (!gameBoard[move - 1].equals(String.valueOf(move))) {
					System.out.println("That space is already taken! Choose another: ");
				}
				else {
					validInput = true;
				}
			} else {
				System.out.println("Invalid input! Please enter a number: ");
				scanner.next(); // Clear invalid input
			}
		}
		
		return move;
	}
	
	/**
	 * Initializes the game board with numbers 1-9
	 */
	public static void initialize() {
		for (int i = 0; i < 9; i++) {
			gameBoard[i] = String.valueOf(i + 1);
		}
	}
	
	/**
	 * Displays the current game board
	 */
	public static void display() {
		System.out.println("\n+---+---+---+");
		System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
		System.out.println("+---+---+---+");
	}
	
	/**
	 * Checks if the current player has won
	 * Checks all 8 possible winning patterns:
	 *   - 3 horizontal (rows)
	 *   - 3 vertical (columns)
	 *   - 2 diagonal
	 * 
	 * @param player - the current player ("X" or "O")
	 * @return true if player has won, false otherwise
	 */
	public static boolean checkWinStatus(String player) {
		// Horizontal wins (rows)
		if (checkLine(0, 1, 2, player)) return true;
		if (checkLine(3, 4, 5, player)) return true;
		if (checkLine(6, 7, 8, player)) return true;
		
		// Vertical wins (columns)
		if (checkLine(0, 3, 6, player)) return true;
		if (checkLine(1, 4, 7, player)) return true;
		if (checkLine(2, 5, 8, player)) return true;
		
		// Diagonal wins
		if (checkLine(0, 4, 8, player)) return true;
		if (checkLine(2, 4, 6, player)) return true;
		
		return false;
	}
	
	/**
	 * Helper method to check if three positions contain the same player's mark
	 * @param pos1, pos2, pos3 - the three positions to check
	 * @param player - the player to check for
	 * @return true if all three positions contain player's mark
	 */
	private static boolean checkLine(int pos1, int pos2, int pos3, String player) {
		return gameBoard[pos1].equals(player) && 
		       gameBoard[pos2].equals(player) && 
		       gameBoard[pos3].equals(player);
	}
}
