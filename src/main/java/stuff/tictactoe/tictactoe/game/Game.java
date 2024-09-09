package stuff.tictactoe.tictactoe.game;

import stuff.tictactoe.tictactoe.enums.Outcome;
import stuff.tictactoe.tictactoe.enums.Player;
import stuff.tictactoe.tictactoe.enums.Type;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Field field;
    private Turn turn;

    public Game() {
        this.field = new Field();
        this.turn = new Turn(Player.FIRST_PLAYER, Type.CROSS);
    }

    public void startGame() {
        printRules();

        while (field.gameIsDone() == Outcome.NOT_DONE) {
            printBoard();

            char pressedChar = getInput();

            if (!commandIsValid(pressedChar) || getPositionByChar(pressedChar) != Type.UNDEFINED) {
                clearConsole();
                continue;
            }

            processCommand(pressedChar);

            clearConsole();
        }

        Outcome outcome = field.gameIsDone();
        printOutcome(outcome);
        printBoard();
    }

    private void printOutcome(Outcome outcome) {
        if (outcome == Outcome.DRAW) {
            System.out.println("GAME RESULTED IN A DRAW.");
        } else if (outcome == Outcome.DONE) {
            switchTurn();
            System.out.println(turn.getPlayer().name() + " WINS THE GAME!");
        } else {
            System.out.println("Error, there was no outcome.");
        }
    }

    private static void printRules() {
        System.out.println("\t\tTIC TAC TOE");
        System.out.println("\t\t   7 8 9");
        System.out.println("\t\t   4 5 6");
        System.out.println("\t\t   1 2 3");
    }

    private void switchTurn() {
        if (turn.getPlayer() == Player.FIRST_PLAYER) {
            turn.setPlayer(Player.SECOND_PLAYER);
            turn.setType(Type.CIRCLE);
        } else {
            turn.setPlayer(Player.FIRST_PLAYER);
            turn.setType(Type.CROSS);
        }
    }

    //7 8 9
    //4 5 6
    //1 2 3
    private boolean commandIsValid(char ch) {
        return switch (ch) {
            case '7', '8', '9', '4', '5', '6', '1', '2', '3' -> true;
            default -> false;
        };
    }

    private Type getPositionByChar(char pressedChar) {
        Type currentPosition = turn.getType();
        switch (pressedChar) {
            case '7' -> currentPosition = field.getFieldTopLeft();
            case '8' -> currentPosition = field.getFieldTopMid();
            case '9' -> currentPosition = field.getFieldTopRight();
            case '4' -> currentPosition = field.getFieldMidLeft();
            case '5' -> currentPosition = field.getFieldMidMid();
            case '6' -> currentPosition = field.getFieldMidRight();
            case '1' -> currentPosition = field.getFieldBottomLeft();
            case '2' -> currentPosition = field.getFieldBottomMid();
            case '3' -> currentPosition = field.getFieldBottomRight();
        }
        return currentPosition;
    }

    private void processCommand(char pressedChar) {
        Type currentType = turn.getType();
        setPosition(pressedChar, currentType);
        switchTurn();
    }

    private void setPosition(char pressedChar, Type currentType) {
        switch (pressedChar) {
            case '7' -> field.setFieldTopLeft(currentType);
            case '8' -> field.setFieldTopMid(currentType);
            case '9' -> field.setFieldTopRight(currentType);
            case '4' -> field.setFieldMidLeft(currentType);
            case '5' -> field.setFieldMidMid(currentType);
            case '6' -> field.setFieldMidRight(currentType);
            case '1' -> field.setFieldBottomLeft(currentType);
            case '2' -> field.setFieldBottomMid(currentType);
            case '3' -> field.setFieldBottomRight(currentType);
        }
    }

    private void printBoard() {
        System.out.println();
        System.out.println("\t\t " + field.getFieldTopLeft().toString() + " | " + field.getFieldTopMid().toString() + " | " + field.getFieldTopRight().toString());
        System.out.println("\t\t " + "--+---+--");
        System.out.println("\t\t " + field.getFieldMidLeft().toString() + " | " + field.getFieldMidMid().toString() + " | " + field.getFieldMidRight().toString());
        System.out.println("\t\t " + "--+---+--");
        System.out.println("\t\t " + field.getFieldBottomLeft().toString() + " | " + field.getFieldBottomMid().toString() + " | " + field.getFieldBottomRight().toString());
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ignored) {}
    }

    public char getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.charAt(0);
    }
}
