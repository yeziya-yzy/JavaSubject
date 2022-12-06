package day35.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/16
 * 面试题 04.06. 后继者
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                temp = root;
                root = root.left;
            }
        }
        return temp;
    }
}
