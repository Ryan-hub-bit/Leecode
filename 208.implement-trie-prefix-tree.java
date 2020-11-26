/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class TireNode{
    Map<Character, TireNode> children;
     boolean isEnd;
    public TireNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}
class Trie {
    private TireNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TireNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode curNode = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TireNode node = curNode.children.get(ch);
            if(node == null) {
                node = new TireNode();
                curNode.children.put(ch, node);
            }
            curNode = node;
        }
        curNode.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode curNode = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curNode.children.containsKey(ch)) {
                curNode = curNode.children.get(ch);
            } else {
                return false;
            }
        }

        return curNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode curNode = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curNode.children.containsKey(ch)) {
                curNode = curNode.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

