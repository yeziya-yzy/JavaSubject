package day47.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/2
 * 450. 删除二叉搜索树中的节点
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }
        TreeNode temp = root.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = root.left;
        return root.right;
    }
}
