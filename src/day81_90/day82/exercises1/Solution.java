package day82.exercises1;

import java.util.Stack;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/5
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        int count = 1;
        while (count < depth - 1) {
            Stack<TreeNode> temp = new Stack<>();
            while (!treeNodes.isEmpty()) {
                TreeNode pop = treeNodes.pop();
                if (pop != null) {
                    temp.add(pop.left);
                    temp.add(pop.right);
                }

            }
            treeNodes = temp;
            count++;
        }
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            System.out.println(pop.val);
            if (pop != null) {
                TreeNode leftAdd = new TreeNode(val);
                TreeNode rightAdd = new TreeNode(val);
                leftAdd.left = pop.left;
                rightAdd.right = pop.right;
                pop.left = leftAdd;
                pop.right = rightAdd;
            }
        }
        return root;
    }
}
