package LeetCode;

//URL:https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        sudokuSolution(board);
    }
    static boolean sudokuSolution(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    for(char val = '1'; val <= '9'; val++){
                        if(isValid(board, row, col, val)){
                            board[row][col] = val;
                            if(sudokuSolution(board))
                                return true;
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(char[][] board, int row, int col, char val){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == val){
                return false;
            }
            if(board[i][col] == val){
                return false;
            }
            if(board[3 * (row/3) + i / 3][3 * (col/3) + i % 3] == val){
                return false;
            }
        }
        return true;
    }
}
