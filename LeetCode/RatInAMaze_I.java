package LeetCode;

//URL:https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.ArrayList;

public class RatInAMaze_I {
    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0] == 0 || m[n-1][n-1] == 0)
            return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        safePath(0, 0, m, n, res, new StringBuilder());
        return res;
    }
    static void safePath(int row, int col, int[][] grid, int n, ArrayList<String> res, StringBuilder path){
        if(row == n-1 && col == n - 1){                                    //   T = O(4^(N*N))
            res.add(path.toString());                                      // S = O(N*N)
            return;
        }
        if(row >= n || row < 0 || col >= n || col < 0 || grid[row][col] == 0 || grid[row][col] == -1){
            return;
        }
        int gridVal = grid[row][col];
        grid[row][col] = -1;
        path.append('D');
        safePath(row + 1, col, grid, n, res, path);
        path.deleteCharAt(path.length() - 1);
        path.append('L');
        safePath(row, col - 1, grid, n , res, path);
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        safePath(row, col + 1, grid, n, res, path);
        path.deleteCharAt(path.length() - 1);
        path.append('U');
        safePath(row-1, col, grid, n, res, path);
        path.deleteCharAt(path.length() - 1);
        grid[row][col] = gridVal;
    }


    //OPTIMIZED CODE

    public static ArrayList<String> findPathOptimal(int[][] m, int n) {
        if(m[0][0] == 0 || m[n-1][n-1] == 0)
            return new ArrayList<>();
        int[] di = new int[]{1, 0, 0, -1};
        int[] dj = new int[]{0, -1, 1, 0};
        ArrayList<String> res = new ArrayList<>();
        optimalSafePathCode(0, 0, m, n, res, new StringBuilder(), di, dj);
        return res;
    }
    static void optimalSafePathCode(int row, int col, int[][] grid, int n, ArrayList<String> res, StringBuilder path, int[] di, int[] dj){
        if(row == n-1 && col == n-1){
            res.add(path.toString());
            return;
        }
        String traversal = "DLRU";
        if(row >= n || row < 0 || col >= n || col < 0 || grid[row][col] == 0 || grid[row][col] == -1){
            return;
        }
        int gridVal = grid[row][col];
        for(int i = 0; i < 4; i++){
            grid[row][col] = -1;
            path.append(traversal.charAt(i));
            optimalSafePathCode(row + di[i], col + dj[i], grid, n, res, path, di, dj);
            path.deleteCharAt(path.length() - 1);
        }
        grid[row][col] = gridVal;
    }
}
