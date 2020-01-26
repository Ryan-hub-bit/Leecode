import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
           return 0;
          Set<String> set=new HashSet<>(wordList);
           Queue<String> queue=new LinkedList<>();
      int level=0;
      queue.add(beginWord);
      
      while(!queue.isEmpty())
      {
        int size=queue.size();
        
        for(int i=0;i<size;i++)
        {
            String cur=queue.remove();
            if(cur.equals(endWord))
            {
                return level+1;
            }
          
            for(int j=0;j<cur.length();j++)
            {
                char[] cc=cur.toCharArray();// make cc is new  when  use out loop
                for(char c='a';c<'z';c++)
                {
                    cc[j]=c;
                    String check=new String(cc);
                    if (!check.equals(cur)&&set.contains(check))
                    {
                        queue.add(check);
                        set.remove(check);
                        
                    }
                }
            }
        }
        level++;
      }
          

      
    
return 0;
    
        
    }
  

}
// @lc code=end

