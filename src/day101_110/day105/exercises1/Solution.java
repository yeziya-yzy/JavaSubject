package day101_110.day105.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 998. 最大二叉树 II
 * 1475. 商品折扣后的最终价格
 */
class Solution {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        getPathLength(root);
        return res;
    }

    public int getPathLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getPathLength(root.left), right = getPathLength(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}