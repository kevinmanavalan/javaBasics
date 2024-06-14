public class Practice2 {
    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2}, {3,4}};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == j){
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
