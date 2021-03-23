package fr.hypnos.tictactoe;

public class Board {

    private static final int SIZE = 3;

    static char[][] board;

    public Board(){
        generateBoard();
    }

    public static int availableLength() {
        int count = 0;

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                if (board[i][j] != 'X' && board[i][j] != 'O') count ++;
            }
        }
        return count;
    }

    public void generateBoard(){
        board = new char[SIZE][SIZE];
        int location = 1;

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                board[i][j] = Integer.toString(location).charAt(0);
                location++;
            }
        }
    }

    public void drawBoard() {
        drawLine();
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                System.out.print("|  " + board[i][j] + "  ");
            }
            System.out.println("|");
            drawLine();
        }
    }

    public void drawLine() {
        System.out.println("-------------------");
    }

    /**
     * @param pos Tableau d'entiers représentant la position jouée
     * @param p instance du joueur
     */
    public static void makeMove(int[] pos, Player p){
        board[pos[0]][pos[1]] = p.MARK;
    }

    public static boolean isValidMove(int[] pos){
        return (board[pos[0]][pos[1]] != 'X') && (board[pos[0]][pos[1]] != 'O');
    }

    public static int gameStatus(boolean isAI){
        // Vertical
        for (int i=0; i<3; i++){
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) return (board[0][i] == 'X') ? 1 : -1;

        }
        // Horizontal
        for (int i=0; i<3; i++){
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) return (board[i][0] == 'X') ? 1 : -1;
        }
        // Diag 1
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) return (board[0][0] == 'X') ? 1 : -1;
        // Diag 2
        if (board[0][2] == board[1][1] && board[0][0] == board[2][0]) return (board[0][0] == 'X') ? 1 : -1;

        return 0;
    }

    private static Player findPlayerFromMark(char c, boolean isAI) {
        if (c == 'X') return Game.getP1();

        if(isAI) {
            return Game.getCPU();
        } else {
            return Game.getP2();
        }
    }

    public static char[][] getBoard() {
        return board;
    }
}
