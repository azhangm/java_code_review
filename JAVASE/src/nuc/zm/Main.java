package nuc.zm;


public class Main {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        // 从左到右非递减 可能不变 可能增
        // 从上到下非递减 从下到上 递增 或 不变
        int m = matrix.length ;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i -- ;
            else if (matrix[i][j] < target) j ++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{{-5}}, -5));
    }
}
