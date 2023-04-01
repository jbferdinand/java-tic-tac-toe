# Java Tic-Tac-Toe

This is a Java-based implementation of the classic Tic-Tac-Toe game. The game supports human players using standard input for moves, as well as AI players with varying difficulty levels, including a perfect play AI using the Minimax algorithm with Alpha-Beta pruning.

## Features

- Easy-to-use and understand code structure
- Human vs Human, Human vs AI, and AI vs AI gameplay options
- Easy, Medium, and Hard AI difficulties
- Perfect play AI using the Minimax algorithm with Alpha-Beta pruning (Hard AI)
- Scalable and extensible codebase for future improvements or additions

## Getting Started

To run the game, simply clone the repository and execute the `TicTacToeGame` class using your preferred Java IDE or command-line interface.

## Customization
You can customize the game by modifying the TicTacToeGame class. In the main method, you can change the difficulty levels for both playerX and playerO by passing different arguments to the GameController constructor. Available difficulty levels are defined in the PlayerFactory.Difficulty enum:

PlayerFactory.Difficulty.HUMAN: Human player
PlayerFactory.Difficulty.EASY: Easy AI player (random moves)
PlayerFactory.Difficulty.MEDIUM: Medium AI player (defensive moves and winning moves)
PlayerFactory.Difficulty.HARD: Hard AI player (perfect play using Minimax algorithm with Alpha-Beta pruning)
