package fr.hypnos.tictactoe;

import java.util.Random;

public class AI {

    public static int randomMove() {
        Random random = new Random();

        return random.nextInt(10);
    }

    /**
     * Fonction permettant de choisir une case optimale.
     *
     * @param board plateau de jeu
     * @return entier positif entre 1 et 9 représentant la case à jouer
     */
    public static int aiMove(char[][] board) {

        char temp;
        int bestScore = Integer.MIN_VALUE;
        int bestMove = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    temp = board[i][j];
                    board[i][j] = 'O';
                    int score = minimax(board, 0, false);
                    board[i][j] = temp;

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = posToNumber(new int[]{i, j});
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Fonction permettant de transformer une coordonné en un nombre de sélection
     *
     * @param pos Tableau d'entiers représentant une coordonnée du plateau
     * @return Entier correspondant à la coordonné
     */
    private static int posToNumber(int[] pos) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                if (pos[0] == i && pos[1] == j) {
                    return count;
                }
            }
        }
        return -1;
    }

    /**
     * Fonction MiniMax permettant une recherche récursive de la meilleure position jouable pour l'IA
     *
     * @param board        Plateau de jeu
     * @param depth        Profondeur de récursion afin de régler la difficulté
     * @param isMaximising Le joueur est-il celui à maximiser
     * @return Entier permettant l'évaluation de la position testée
     */
    private static int minimax(char[][] board, int depth, boolean isMaximising) {

        int result = Board.gameStatus(board);

        if (Math.abs(result) == 10 || Board.availableLength(board) < 1) {
            return result;
        }

        // Si le joueur est l'IA alors on maximise son score afin d'obtenir la meilleure position
        if (isMaximising) {
            char temp;
            int highestVal = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != 'X' && board[i][j] != 'O') {
                        temp = board[i][j];
                        board[i][j] = 'O';

                        highestVal = Math.max(highestVal, minimax(board, depth + 1, false));

                        board[i][j] = temp;
                    }
                }
            }
            return highestVal;
        } else {
            char temp;
            int lowestVal = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != 'X' && board[i][j] != 'O') {
                        temp = board[i][j];
                        board[i][j] = 'X';

                        lowestVal = Math.min(lowestVal, minimax(board, depth + 1, true));

                        board[i][j] = temp;
                    }
                }
            }
            return lowestVal;
        }
    }

    // For tests only
    /*public static void main(String[] args) {
        char[][] b = {
                {'X', '2', 'X'},
                {'O', 'O', '6'},
                {'X', '8', '9'}
        };

        //aiMove(b);
        //System.out.println(Board.gameStatus(b));
    }*/
}
