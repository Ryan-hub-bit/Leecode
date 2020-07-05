/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

// [1,2,3,4,5,6,7] for G(3) which is root = 3 and, the total number is [1,2] and
// (3,7] the number of the tree depends only on the number of elements. so G(3)
// = G(2) * G(4)
// for any (1,n), we should get the root from 1 - n and add them together so
// like G(n) += G(i-1)* G(n-i)
// G[i]表示1-i 中一共有多少种组合 1-i做根的子树一共有多少个

// @lc code=end
