package fr.hypnos.tictactoe;

public class Board {

    private static final int SIZE = 3;

    static char[][] board;

    public Board() {
        generateBoard();
    }

    public static int availableLength(char[][] b) {
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (b[i][j] != 'X' && b[i][j] != 'O') count++;
            }
        }
        return count;
    }

    /**
     * Initialise et remplis le plateau de jeu.
     */
    public void generateBoard() {
        board = new char[SIZE][SIZE];
        int location = 1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.toString(location).charAt(0);
                location++;
            }
        }
    }

    public static void drawBoard(char[][] b) {
        drawLine();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("|  " + b[i][j] + "  ");
            }
            System.out.println("|");
            drawLine();
        }
    }

    public static void drawLine() {
        System.out.println("-------------------");
    }

    /**
     * @param pos Tableau d'entiers représentant la position jouée
     * @param p   instance du joueur
     */
    public static void makeMove(int[] pos, Player p) {
        board[pos[0]][pos[1]] = p.MARK;
    }

    public static boolean isValidMove(int[] pos) {
        return (board[pos[0]][pos[1]] != 'X') && (board[pos[0]][pos[1]] != 'O');
    }


    /** Fonction permettant de connaître le status du jeu
     * @param currentBoard Représentation interne du plateau
     * @return un entier 10 pour le joueur 2 et -10 pour le joueur 1
     */
    public static int gameStatus(char[][] currentBoard) {

        // Horizontal
        for (int row = 0; row < 3; row++) {
            if (currentBoard[row][0] == currentBoard[row][1] && currentBoard[row][1] == currentBoard[row][2]) {
                if (currentBoard[row][0] == 'X')
                    return -10;
                else if (currentBoard[row][0] == 'O')
                    return 10;
            }
        }

        // Vertical
        for (int col = 0; col < 3; col++) {
            if (currentBoard[0][col] == currentBoard[1][col] && currentBoard[1][col] == currentBoard[2][col]) {
                if (currentBoard[0][col] == 'X')
                    return -10;
                else if (currentBoard[0][col] == 'O')
                    return 10;
            }
        }

        // Diag1
        if (currentBoard[0][0] == currentBoard[1][1] && currentBoard[1][1] == currentBoard[2][2]) {
            if (currentBoard[0][0] == 'X')
                return -10;
            else if (currentBoard[0][0] == 'O')
                return 10;
        }

        // Diag2
        if (currentBoard[0][2] == currentBoard[1][1] && currentBoard[1][1] == currentBoard[2][0]) {
            if (currentBoard[0][2] == 'X')
                return -10;
            else if (currentBoard[0][2] == 'O')
                return 10;
        }

        // Dans tous les autres cas on return 0
        return 0;
    }

    public static char[][] getBoard() {
        return board;
    }
}
