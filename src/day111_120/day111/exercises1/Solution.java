package day111_120.day111.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/10
 * 669. 修剪二叉搜索树
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return BST(root, low, high);
    }

    private TreeNode BST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = BST(root.left, low, high);
            root.right = BST(root.right, low, high);
            return root;
        }
        if (root.val < low) {
            return BST(root.right, low, high);
        } else {
            return BST(root.left, low, high);
        }
    }
}
