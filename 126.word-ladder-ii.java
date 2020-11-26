import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        // List<String> cutdown = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        int shortestPath = Integer.MAX_VALUE;
        boolean flag = false;
        Map<String, Boolean> visited = new HashMap<>();
        //use a cutdown List record the list we use
        if(!wordList.contains(endWord))
        {
            return res;   
        }
        for(String s:wordSet)
        {
            visited.put(s,false);
        }
        ans.add(beginWord);
        queue.offer(ans);
        visited.put(beginWord,true);
        while(!queue.isEmpty() && !flag)
        {
            
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                List<String> path = queue.poll();
                if(path.size() >= shortestPath)
                {
                    flag = true;
                    break;
                }
                String lastWord = path.get(path.size() - 1);
                for(int j = 0; j < lastWord.length(); j ++)
                {
                    for(char c = 'a'; c <='z'; c++)
                    {
                        char[] cc = lastWord.toCharArray();
                        cc[j] = c;
                        String cur = new String(cc);
                        if(wordSet.contains(cur) && !visited.get(cur))
                        {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(cur);
                            // cutdown.add(cur);
                            visited.put(cur,true);
                            if(cur.equals(endWord))
                            {
                                shortestPath = newPath.size();
                                res.add(newPath);
                                
                            }
                            else{
                                queue.add(newPath);
                            }
                        }
                        visited.put(cur,false);
                    }
                }
            }
// 
            wordSet.removeAll(cutdown);
            cutdown.clear();
        }

        return res;
    }
}
// @lc code=end

