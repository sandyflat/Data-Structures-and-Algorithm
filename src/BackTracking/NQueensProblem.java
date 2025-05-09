// Program to solve N-Queens problem using backtracking.
// N*N chessboard
// N Queens
// Print all solutions where queens are safe.
package BackTracking;

public class NQueensProblem {
    public static void main(String[] args) throws Exception {
        int[][] chess = new int[4][4];    // 4*4 chess
        printNQueens(chess, "",0);
    }
    public static void printNQueens(int[][] chess, String qsf, int row){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }
        for(int col=0; col<chess.length; col++){
            if(isSafePlaceForQueen(chess,row,col)) {       // if true
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    // method to check is Queen is safe in that place.
    public static boolean isSafePlaceForQueen(int[][] chess, int row, int col){
        for(int i=row -1, j=col; i >= 0; i--){      // check vertically (column)
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1,j=col-1; i>= 0 && j>=0; i--,j--){   // check diagonally (top-left)
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i = row-1, j=col+1; i>=0 && j<chess.length; i--, j++){  // check diagonally
            if(chess[i][j] == 1){                                       // (top-right)
                return false;
            }
        }
        return true;
    }
}
