/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1)
            return;

        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = new int[matrix.length];
            temp = matrix[i];
            matrix[i] = matrix[n - i];
            matrix[n - i] = temp;

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <i; j++) {
                int temp1 = 0;
                temp1 = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp1;

            }
        }
        

    }
    flip(int i,int j){};

}
// @lc code=end
