package day101_110.day102.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 998. 最大二叉树 II
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > val) {
                parent = temp;
                temp = temp.right;
            } else {
                TreeNode treeNode = new TreeNode(val);
                if (parent == null) {
                    treeNode.left = root;
                    return treeNode;
                } else {
                    treeNode.left = parent.right;
                    parent.right = treeNode;
                }
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}