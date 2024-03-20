package LeetCode;

public class CherryPicking_I { //WRONG!!!!!!!!!!!!!!!!!!!!
    public int cherryPickup(int[][] grid) {
        int[][] sumGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1 && (i + j) != 0) {
                    sumGrid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return 0;
    }
}
