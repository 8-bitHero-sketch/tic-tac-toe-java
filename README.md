# Tic Tac Toe Game

A console-based implementation of the classic Tic Tac Toe game in Java.

## Description

This project contains two versions of a Tic Tac Toe game:
- **TicTacToe.java**: Basic implementation with core functionality
- **TicTacToeEnhanced.java**: Enhanced version with input validation and replay option

## Features

- ✅ Two-player gameplay (X and O)
- ✅ 3x3 grid game board
- ✅ Win detection for rows, columns, and diagonals
- ✅ Draw detection
- ✅ Input validation (Enhanced version)
- ✅ Play again option (Enhanced version)
- ✅ User-friendly console interface

## How to Play

1. Players take turns entering a number (1-9) to place their mark
2. Player X always goes first
3. The game ends when:
   - A player gets three in a row (horizontally, vertically, or diagonally)
   - All 9 spaces are filled (draw)

## Game Board Layout

```
+---+---+---+
| 1 | 2 | 3 |
+---+---+---+
| 4 | 5 | 6 |
+---+---+---+
| 7 | 8 | 9 |
+---+---+---+
```

## Technologies Used

- Java
- Scanner (for user input)
- Eclipse IDE

## How to Run

### Using Command Line:
```bash
# Compile
javac TicTacToe.java

# Run
java TicTacToe
```

### Using Eclipse:
1. Import the .java file into your Eclipse project
2. Right-click on the file
3. Select "Run As" → "Java Application"

## Project Structure

```
tic-tac-toe-java/
│
├── TicTacToe.java           # Basic implementation
├── TicTacToeEnhanced.java   # Enhanced implementation
└── README.md                # This file
```

## Future Enhancements?

- [ ] Add AI opponent (single player mode)
- [ ] Add difficulty levels
- [ ] Create GUI version using JavaFX or Swing
- [ ] Add score tracking across multiple games
- [ ] Add player name customization

## Learning Outcomes

This project demonstrates:
- Array manipulation in Java
- Control flow (loops and conditionals)
- Method design and implementation
- Input validation
- Game logic implementation

## Author

Orion Burnette 8-bitHero Labs

## License

This project is open source and available for educational purposes.

## Acknowledgments

Created as part of Java programming practice and learning.
