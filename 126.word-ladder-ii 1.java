import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    

       List<String>  subString=new ArrayList<>();
       List<List<String>> res= new ArrayList<>();
       
       Queue<List<String>> queue=new LinkedList<>();
       
       Set<String> set=new HashSet<>(wordList);
       Set<String> dummy = new HashSet<String>();//用作排重
      subString.add(beginWord);
       queue.offer(subString);
       if(!set.contains(endWord))
       {
           return res;
       }
       boolean flag=false;
       int len=Integer.MAX_VALUE;
       while(!queue.isEmpty()&&!flag)
       {
    
           int size=queue.size();
           for(int i=0;i<size;i++)
           {
            List<String> path=queue.poll();
           if(path.size()>=len)
           {
               flag=true;
               break;
           }
           String lastWord=path.get(path.size()-1);
           for(int j=0;j<lastWord.length();j++)
           {
               char[] ch=lastWord.toCharArray();
               for(char c='a';c<'z';c++)
               {
                   ch[j]=c;
                   String cur=new String(ch);
                   if(set.contains(cur))
                   {  
                       List<String> newpath=new ArrayList<>(path);
                       newpath.add(cur);
                     dummy.add(cur);
                       if (cur.equals(endWord))
                       {
                           len=newpath.size();
                           res.add(newpath);
                       }
                       else{
                           queue.offer(newpath);
                       }
                       
                   }
               }
           }
           }
           //remove column of a queue
           set.removeAll(dummy);
           dummy.clear();
        
       }
       
       return res;
    }
}
// @lc code=end

