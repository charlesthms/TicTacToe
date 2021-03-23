package fr.hypnos.tictactoe;

import java.util.Random;

public class AI {

    public static int randomMove(){
        Random random = new Random();

        return random.nextInt(10);
    }

    public static int aiMove(){

        char[][] board = Board.getBoard();
        char temp;
        int bestScore = Integer.MIN_VALUE;
        int bestMove = 0;

        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++){
                if (board[i][j] != 'X' && board[i][j] != 'O'){
                    temp = board[i][j];
                    board[i][j] = 'O';
                    int score = minimax(board, 0, false);
                    board[i][j] = temp;
                    
                    if (score > bestScore){
                        bestScore = score;
                        bestMove = posToNumber(new int[]{i, j});
                    }
                }
            }
        }
        return bestMove;
    }

    private static int posToNumber(int[] pos) {
        int count = 0;

        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                count++;
                if (pos[0] == i && pos[1] == j) {
                    return count;
                }
            }
        }
        return -1;
    }

    private static int minimax(char[][] board, int depth, boolean isMaximising) {

        System.out.println(depth);
        int result = Board.gameStatus(true);

        if (result != 0){
            return result;
        }

        if (isMaximising){
            char temp;
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != 'X' && board[i][j] != 'O'){
                        temp = board[i][j];
                        board[i][j] = 'O';
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = temp;

                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            char temp;
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != 'X' && board[i][j] != 'O'){
                        temp = board[i][j];
                        board[i][j] = 'X';
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = temp;

                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}