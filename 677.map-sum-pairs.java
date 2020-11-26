/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class TireNode {
    Map<Character, TireNode> children;
    int val;

    public TireNode(int val) {
        this.children = new HashMap<>();
        this.val = val;
    }
}

class MapSum {
    public TireNode root;
    int ans = 0;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TireNode(0);
    }

    public void insert(String key, int val) {
        TireNode curNode = root;
        for (int i = 0; i < key.length(); i++) {

            char ch = key.charAt(i);
            TireNode node = curNode.children.get(ch);
            if (node == null) {
                node = new TireNode(0);
                curNode.children.put(ch, node);
            }
            curNode = node;
            curNode.val += val;
            // if (i == key.length() - 1) {
            // curNode.val = val;
            // }

        }

    }

    public int sum(String prefix) {

        TireNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            // if (i == prefix.length() - 1) {
            // return curNode.val;
            // }
            if (curNode.children.containsKey(ch)) {
                curNode = curNode.children.get(ch);
                // ans += curNode.val;
            } else {
                return 0;
            }
        }
        return curNode.val;
    }
}

// public static void main(String[] args) {
// MapSum mapSum = new MapSum();
// mapSum.insert("apple", 3);
// mapSum.sum("ap");
// mapSum.insert("app", 2);
// mapSum.sum("ap");
// }

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// @lc code=end
