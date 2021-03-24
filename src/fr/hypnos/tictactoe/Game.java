package fr.hypnos.tictactoe;

import java.util.Scanner;

public class Game {

    private static final String PREFIX = "[GAME-INFO]";

    private static Player p1;
    private static Player p2;
    private static Player CPU;

    public static Player getP1() {
        return p1;
    }

    public static Player getP2() {
        return p2;
    }

    public static Player getCPU() {
        return CPU;
    }

    public static void createPlayer(int number) {
        Scanner in = new Scanner(System.in);

        if (number == 1) {
            System.out.println(PREFIX + " Entrez le nom du joueur 1 et appuyez sur [ENTRER]");
            String NAME = in.nextLine();
            p1 = new Player(NAME, 'X');
        } else {
            System.out.println(PREFIX + " Entrez le nom du joueur 2 et appuyez sur [ENTRER]");
            String NAME = in.nextLine();
            p2 = new Player(NAME, 'O');
        }
    }

    public static boolean gameModeSelector() {
        Scanner in = new Scanner(System.in);
        boolean rightInput = true;
        boolean isAI = false;
        String mode;

        System.out.println(PREFIX + " Sélectionnez le mode de jeu ( [1] HUMAN / [2] AI ) et appuyez sur [ENTRER]");
        mode = in.nextLine();

        while (rightInput) {
            if (mode.equalsIgnoreCase("1")) {
                createPlayer(1);
                createPlayer(2);
                rightInput = false;
            } else if (mode.equalsIgnoreCase("2")) {
                isAI = true;

                createPlayer(1);
                createAI();

                rightInput = false;
            } else {
                System.out.println(PREFIX + " Erreur lors du choix, reéssayez.");
                System.out.println(PREFIX + " Sélectionnez le mode de jeu ( [1] HUMAN / [2] AI ) et appuyez sur [ENTRER]");
                mode = in.nextLine();
            }
        }

        return isAI;
    }

    private static void createAI() {
        CPU = new Player("CPU", 'O');
    }

    public static void gameTurn(Player p, boolean isAI) {
        int[] pos;
        int choice;

        if (isAI) {
            choice = AI.aiMove(Board.getBoard()); // Minimax
            // choice = AI.randomMove(); // Random position
            System.out.println("Mouvement de l'IA: " + choice);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("[" + p.NAME.toUpperCase() + "] Entrez votre position et appuyez sur [ENTRER]");
            choice = in.nextInt();
        }

        switch (choice) {
            case 1 -> {
                pos = new int[]{0, 0};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 2 -> {
                pos = new int[]{0, 1};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 3 -> {
                pos = new int[]{0, 2};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 4 -> {
                pos = new int[]{1, 0};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 5 -> {
                pos = new int[]{1, 1};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 6 -> {
                pos = new int[]{1, 2};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 7 -> {
                pos = new int[]{2, 0};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 8 -> {
                pos = new int[]{2, 1};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            case 9 -> {
                pos = new int[]{2, 2};
                if (Board.isValidMove(pos)) Board.makeMove(pos, p);
                else invalidMove(p, isAI);
            }
            default -> invalidMove(p, isAI);
        }
    }

    public static void invalidMove(Player p, boolean isAI) {
        if (!isAI) {
            System.out.println(PREFIX + " Mouvement interdit, rééssayez.");
        }
        gameTurn(p, isAI);
    }

    public static void startGame() {

        boolean runGame = true;
        int tour = 0;

        boolean isAI = gameModeSelector();

        Board board = new Board();
        board.drawBoard(Board.getBoard());

        while (runGame) {
            if (tour == 0) {
                gameTurn(p1, false);
            } else {
                if (isAI) {
                    gameTurn(CPU, true);
                } else {
                    gameTurn(p2, false);
                }
            }
            tour = 1 - tour;
            Board.drawBoard(Board.getBoard());

            int currentGameStatus = Board.gameStatus(Board.getBoard());

            if (currentGameStatus == 0 && Board.availableLength(Board.getBoard()) == 0) {
                runGame = false;
                System.out.println("Match null !");
            } else if (currentGameStatus != 0) {
                runGame = false;
                if (isAI){
                    System.out.println((currentGameStatus == -10) ? p1.NAME + " remporte la partie !" : CPU.NAME + " remporte la partie !");
                } else {
                    System.out.println((currentGameStatus == -10) ? p1.NAME + " remporte la partie !" : p2.NAME + " remporte la partie !");
                }

            }
        }
    }

    public static void main(String[] args) {
        startGame();
    }

}
