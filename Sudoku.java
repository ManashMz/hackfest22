import java.util.Scanner;

public class Sudoku {
    static final int boardSize = 9;

    public static void main(String[] args) {
        int[][] arr = new int[boardSize][boardSize];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                arr[i][j] = sc.nextInt(); //for cells with no value, enter 0
            }
        }
        sc.close();
        if (solve(arr)) {
            System.out.println("SOLVED");
        } else {
            System.out.println("Board not solvable");
        }
        printBoard(arr);
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isNumberInRow(int[][] board, int number, int row) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInColumn(int[][] board, int number, int col) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInGrid(int[][] board, int number, int row, int col) {
        // obtain the coordinates of the top left element of the 3X3 grid
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for (int i = localRow; i < localRow + 3; i++) {
            for (int j = localCol; j < localCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidLocation(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, col) &&
                !isNumberInGrid(board, number, row, col);
    }

    public static boolean solve(int[][] board) {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (board[row][col] == 0) {
                    for (int po = 1; po <= boardSize; po++) {
                        if (isValidLocation(board, po, row, col)) {
                            board[row][col] = po;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
