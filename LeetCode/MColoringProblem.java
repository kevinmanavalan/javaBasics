package LeetCode;

//URL:https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

import java.util.Arrays;

public class MColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] nodeColor = new int[n];
        Arrays.fill(nodeColor, -1);
        return requiredNoOfColor(0, graph, nodeColor, m, n);
    }

    static boolean requiredNoOfColor(int node, boolean[][] graph, int[] nodeColor, int m, int n){
        if(node == n){
            return true;
        }
        for(int color = 0; color < m; color++){
            if(colorValidity(node, color, graph, nodeColor, n)){
                nodeColor[node] = color;
                if(requiredNoOfColor(node + 1, graph, nodeColor, m, n))
                    return true;
                nodeColor[node] = -1;
            }
        }
        return false;
    }

    static boolean colorValidity(int node, int color, boolean[][] graph, int[] nodeColor, int n){
        for(int nodeId = 0; nodeId < n; nodeId++){
            if(graph[node][nodeId] && nodeColor[nodeId] == color){
                return false;
            }
        }
        return true;
    }
}
