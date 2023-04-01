package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] command = getCommand();
        if (command[0].equals("exit")) {
            System.exit(0);
        }
        GameController gameController = new GameController();
        gameController.startGame(mapPlayer(command[1]), mapPlayer(command[2]));

    }

    private static String[] getCommand() {
        var scanner = new Scanner(System.in);
        String[] possiblePlayers = new String[]{"user", "easy", "medium", "hard"};
        String player1, player2;
        while (true) {
            System.out.println("Input command:");
            String input = scanner.nextLine();
            String[] params = input.split(" ");
            if (params.length < 1) {
                System.out.println("Bad parameters!");
            } else {
                String command = params[0];
                switch (command) {
                    case "start" -> {
                        if (params.length != 3) {
                            System.out.println("Bad parameters!");
                            continue;
                        }
                        player1 = params[1];
                        player2 = params[2];
                        if (Arrays.stream(possiblePlayers).anyMatch(player1::contains) && Arrays.stream(possiblePlayers).anyMatch(player2::contains)) {
                            return new String[]{command, player1, player2};
                        } else {
                            System.out.println("Bad parameters!");
                        }
                    }
                    case "exit" -> {
                        return new String[]{command};
                    }
                    default -> System.out.println("Bad parameters!");
                }
            }
        }
    }

    private static PlayerFactory.Difficulty mapPlayer(String name) {
        switch (name) {
            case "user" -> {
                return PlayerFactory.Difficulty.HUMAN;
            }
            case "easy" -> {
                return PlayerFactory.Difficulty.EASY;
            }
            case "medium" -> {
                return PlayerFactory.Difficulty.MEDIUM;
            }
            case "hard" -> {
                return PlayerFactory.Difficulty.HARD;
            }
        }
        return null;
    }
}

