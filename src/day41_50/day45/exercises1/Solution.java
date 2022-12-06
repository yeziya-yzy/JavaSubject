package day45.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/30
 * 1022.从根到叶的二进制数之和
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}