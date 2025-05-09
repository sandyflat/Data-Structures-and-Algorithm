// Program to solve Sudoku problem using backtracking.
package BackTracking;
import java.util.Scanner;

public class SudokuSolver {
    public static void display(int[][] board){
        for(int i=0; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j){
        if(i == board.length){
            display(board);
            return;
        }
        int ni = 0;    // next i/cell
        int nj = 0;    // next j/cell

        if(j == board[0].length-1){
            ni = i +1;       // goto next row and initial column
            nj = 0;
        }else{
            ni = i;
            nj= j+1;        // goto next column of same row
        }

        if(board[i][j] !=0){
            solveSudoku(board, ni, nj);
        }else{
            for(int po = 1; po <= 9; po++){     // po = possible option
                if(isValid(board, i, j, po)){    // if true
                    board[i][j] = po;           // put the possible value in i,j position.
                    solveSudoku(board, ni, nj);   // and then goto next step
                    board[i][j] =0;   // undo the changes while backtracking.
                }
            }
        }
    }

    public static boolean isValid(int[][] board, int x, int y, int value){
        for(int j=0; j< board[0].length; j++){    // checking value already exists in a row.
            if(board[x][j] == value){
                return false;
            }
        }

        for(int i = 0; i<board.length; i++){   // checking value already exists in a column.
            if(board[i][y] == value){
                return false;
            }
        }

        int subMatrixi = x / 3 * 3;          // finding top-left corner of submatrix of particular
        int subMatrixj = y / 3 * 3;          // sell

        for(int i = 0; i < 3; i++){
            for(int j = 0; j<3; j++){
                if(board[subMatrixi + i][subMatrixj + j] == value){
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[][] arr = new int[9][9];
//        for(int i = 0; i< 9; i++){
//            for(int j = 0; j<9; j++){
//                arr[i][j] =scanner.nextInt();
//            }
//        }
        int[][] arr ={{3,0,6,5,0,8,4,0,0},
                     {5,2,0,0,0,0,0,0,0},
                     {0,8,7,0,0,0,0,3,1},
                     {0,0,3,0,1,0,0,8,0},
                     {9,0,0,8,6,3,0,0,5},
                     {0,5,0,0,9,0,6,0,0},
                     {1,3,0,0,0,0,2,5,0},
                     {0,0,0,0,0,0,0,7,4},
                     {0,0,5,2,0,6,3,0,0}};
        solveSudoku(arr,0,0);
    }
}
// Note:
// the objective is to fill a partially completed grid (ie 0 placed cell) with numbers
// and the rules is:-
// 1. Each row must contain the digits 1-9 without repetition.
// 2. Each column must contain the digits 1-9 without repetition.
// 3. Each 3*3 subgrid must contain the digits 1-9 without repetition.