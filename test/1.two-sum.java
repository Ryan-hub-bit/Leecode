import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class SolutionTwoSum {
    public int[] twoSum(int[] numb, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numb.length; i++) {
            if (map.containsKey(target - numb[i])) { return new int[] { map.get(target - numb[i]), i }; }
            map.put(numb[i], i);
        }

        return new int[] { 0, 0 };
    }
}

// @lc code=end

class Main {
    public static void main(String[] args) {
        int[] inputList = new int[] { 2, 3, 4, 5 };
        int target = 6;
        int[] expectedOutput = new int[] { 0, 2 };
        SolutionTwoSum mySolution = new SolutionTwoSum();
        int[] myOutput = mySolution.twoSum(inputList, target);
        if (myOutput == expectedOutput) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}