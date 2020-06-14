import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // BFS
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<String>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        List<String> subString = new ArrayList<>();
        Set<String> cutDown = new HashSet<>();
        subString.add(beginWord);
        queue.offer(subString);
        set.remove(beginWord);
        if (!set.contains(endWord)) {
            return res;
        }
        int len = Integer.MAX_VALUE;
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                if (path.size() >= len) {
                    flag = true;
                    break;
                }
                String lastWord = path.get(path.size() - 1);
                for (int j = 0; j < lastWord.length(); j++) {
                    char[] ch = lastWord.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        ch[j] = c;
                        String cur = new String(ch);
                        if (set.contains(cur)) {
                            List<String> new_path = new ArrayList<>(path);
                            new_path.add(cur);
                            cutDown.add(cur);
                            if (cur.equals(endWord)) {
                                len = new_path.size();
                                res.add(new_path);
                            } else {
                                queue.offer(new_path);
                            }
                        }

                    }
                }

            }
            set.removeAll(cutDown);
            cutDown.clear();
        }

        return res;
    }
}
// @lc code=end
