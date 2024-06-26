package LeetCode;

//URL:https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {          //T = O(N! * N)       Optimal Approach 👇👇👇
        List<List<String>> res = new ArrayList<>();          //S = O(N^2)
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        arrangements(0, board, res);
        return res;
    }
    static boolean valid(char[][] board, int row, int col){
        int trow = row;
        int tcol = col;
        while(trow >= 0 && tcol >= 0){
            if(board[trow][tcol] == 'Q')
                return false;
            trow--;
            tcol--;
        }
        trow = row;
        tcol = col;
        while(trow >= 0 && tcol < board.length){
            if(board[trow][tcol] == 'Q')
                return false;
            trow--;
            tcol++;
        }
        trow = row;
        tcol = col;
        while(trow >= 0){
            if(board[trow][tcol] == 'Q')
                return false;
            trow--;
        }
        return true;
    }
    static List<String> boardToString(char[][] board){
        List<String> arrangement = new ArrayList<>();
        for (char[] row : board) {
            arrangement.add(new String(row));
        }
        return arrangement;
    }
    static void arrangements(int row, char[][] board, List<List<String>> res){
        if(row == board.length){
            res.add(boardToString(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(valid(board, row, col)){
                board[row][col] = 'Q';
                arrangements(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }


    //Optimal Approach
    public List<List<String>> optimalApproach(int n) {            // T = no change O(N! * N)
        List<List<String>> res = new ArrayList<>();               // S = O(3N) ~ O(N)
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        int[] hashCol = new int[n];
        int[] leftDiagonal = new int[2 * n - 1];
        int[] rightDiagonal = new int[2 * n - 1];
        optimalArrangements(0, board, res, hashCol, leftDiagonal, rightDiagonal);
        return res;
    }
    static void optimalArrangements(int row, char[][] board, List<List<String>> res, int[] hashCol, int[] leftDiagonal, int[] rightDiagonal){
        if(row == board.length){
            res.add(boardToString(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(hashCol[col] != 1 && rightDiagonal[row + col] != 1 && leftDiagonal[board.length - 1 + col - row] != 1){
                board[row][col] = 'Q';
                hashCol[col] = 1;
                rightDiagonal[row + col] = 1;
                leftDiagonal[board.length - 1 + col - row] = 1;
                optimalArrangements(row + 1, board, res, hashCol, leftDiagonal, rightDiagonal);
                board[row][col] = '.';
                hashCol[col] = 0;
                rightDiagonal[row + col] = 0;
                leftDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}
