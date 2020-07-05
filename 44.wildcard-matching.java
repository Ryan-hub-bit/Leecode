/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
//  boolean[][] memo; 
//     public boolean isMatch(String s, String p) {
//         memo = new boolean[s.length()+1][p.length()+1];
//         return dfs(s,p,0,0);
//     }
//     public boolean dfs(String s, String p,int indexS,int indexP)
//     {
//         if(indexS == s.length())
//         {
//             while(indexP < p.length() && p.charAt(indexP) == '*')
//             {
//                 indexP ++;
//             }

//             if(indexP == p.length())
//             {
//                 memo[indexS][indexP] = true;
//                 return true;
//             }
//             memo[indexS][indexP] = false;
//             return false;
//         }else if(indexP == p.length())
//         {
//             memo[indexS][indexP] = false;
//             return false;
//         }

//         if(memo[indexS][indexP])
//         {
//             return true;
//         }

//         if(!memo[indexS][indexP])
//         {
//             return false;
//         }

//         boolean possible = false;

//         if(p.charAt(indexP) == '?')
//         {
//             possible = dfs(s,p,indexS+1,indexP+1);
//         }
//         else if (p.charAt(indexP) == '*')
//         {
//             possible = dfs(s,p,indexS+1,indexP+1) 
//                     || dfs(s,p,indexS,indexP+1)
//                     || dfs(s,p,indexS+1,indexP);
//         }
//         else if(s.charAt(indexP) == s.charAt(indexS))
//         {
//             possible = dfs(s,p,indexS+1,indexP+1);
//         }
//         memo[indexS][indexP] = possible;
//         return possible;
//     }
boolean[][] memo; // 0 indicates haven't found, -1 is not possible, 1 is possible!

public boolean isMatch(String s, String p) {
    memo = new boolean[s.length() + 1][p.length() + 1];
    return dfs(s, p, 0, 0);
}

public boolean dfs(String s, String p, int p1, int p2) {

    // let's check if
    if (p1 == s.length()) {

        // keep advancing the star characters!
        while (p2 < p.length() && p.charAt(p2) == '*')
            p2++;

        // did we get to the end?
        if (p2 == p.length()) {
            memo[p1][p2] = true;
            return true;
        }

        memo[p1][p2] = false;
        return false;
        // still have characters left!
    } else if (p2 == p.length()) {
        memo[p1][p2] = false;
        return false;
    }

    if (!memo[p1][p2])
        return false;

    if (memo[p1][p2])
        return true;

    boolean possible = false;

    if (p.charAt(p2) == '?')
        possible = dfs(s, p, p1 + 1, p2 + 1);
    else if (p.charAt(p2) == '*') {
        // useless starting * (match zero), matches more than one character character,
        // matches this exact character
        possible = dfs(s, p, p1, p2 + 1) || dfs(s, p, p1 + 1, p2) || dfs(s, p, p1 + 1, p2 + 1);
    } else if (s.charAt(p1) == p.charAt(p2))
        possible = dfs(s, p, p1 + 1, p2 + 1);

    memo[p1][p2] = possible;
    return possible;
}

}
// @lc code=end

