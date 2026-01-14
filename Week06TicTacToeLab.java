package Labs;
import java.util.Scanner;

public class Week06TicTacToeLab {
	

	
		// Game board - using 1D array of 9 spaces
		private static String[] gameBoard = new String[9];
		private static Scanner scanner = new Scanner(System.in);
		
		public static void main(String[] args) {
			
			System.out.println("Welcome to Tic Tac Toe!");
			System.out.println("Player X goes first.\n");
			
			// Initialize the board
			initialize();
			
			// Display the board
			display();
			
			// Game loop
			int turn = 0;
			boolean gameWon = false;
			String currentPlayer = "X";
			
			while (turn < 9 && !gameWon) {
				// Get player move
				System.out.println("\nPlayer " + currentPlayer + ", enter your move (1-9): ");
				int move = scanner.nextInt();
				
				// Validate and place move
				if (move >= 1 && move <= 9 && gameBoard[move - 1].equals(String.valueOf(move))) {
					gameBoard[move - 1] = currentPlayer;
					turn++;
					
					// Display updated board
					display();
					
					// Check for winner (start checking after turn 5)
					if (turn >= 5) {
						gameWon = checkWinStatus(currentPlayer);
						if (gameWon) {
							System.out.println("\n🎉 Player " + currentPlayer + " wins!");
							break;
						}
					}
					
					// Switch players
					currentPlayer = currentPlayer.equals("X") ? "O" : "X";
					
				} else {
					System.out.println("Invalid move! That space is taken or out of range. Try again.");
				}
			}
			
			// Check for draw
			if (!gameWon && turn == 9) {
				System.out.println("\nIt's a draw!");
			}
			
			scanner.close();
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
		 * @param player - the current player ("X" or "O")
		 * @return true if player has won, false otherwise
		 */
		public static boolean checkWinStatus(String player) {
			// Check all 8 winning patterns
			
			// Horizontal wins (rows)
			if (gameBoard[0].equals(player) && gameBoard[1].equals(player) && gameBoard[2].equals(player)) {
				return true;
			}
			if (gameBoard[3].equals(player) && gameBoard[4].equals(player) && gameBoard[5].equals(player)) {
				return true;
			}
			if (gameBoard[6].equals(player) && gameBoard[7].equals(player) && gameBoard[8].equals(player)) {
				return true;
			}
			
			// Vertical wins (columns)
			if (gameBoard[0].equals(player) && gameBoard[3].equals(player) && gameBoard[6].equals(player)) {
				return true;
			}
			if (gameBoard[1].equals(player) && gameBoard[4].equals(player) && gameBoard[7].equals(player)) {
				return true;
			}
			if (gameBoard[2].equals(player) && gameBoard[5].equals(player) && gameBoard[8].equals(player)) {
				return true;
			}
			
			// Diagonal wins
			if (gameBoard[0].equals(player) && gameBoard[4].equals(player) && gameBoard[8].equals(player)) {
				return true;
			}
			if (gameBoard[2].equals(player) && gameBoard[4].equals(player) && gameBoard[6].equals(player)) {
				return true;
			}
			
			return false;
		}
	}
