import java.util.Queue;
import java.util.Set;

import javax.swing.text.WrappedPlainView;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if (!set.contains(endWord)) {
            return 0;
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                System.out.println(cur);
                if (cur.equals(endWord)) {
                    return level + 1;
                }

                for (int j = 0; j < cur.length(); j++) {
                    char[] ch = cur.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        ch[j] = c;
                        String next = new String(ch);
                        if (!next.equals(cur) && set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
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
