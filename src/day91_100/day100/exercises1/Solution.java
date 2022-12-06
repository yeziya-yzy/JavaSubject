package day100.exercises1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/27
 */
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(9);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(new Solution().widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {
        long res = 1;
        long max;
        long min;
        Deque<TreeNodeTemp> deque = new ArrayDeque<>();
        deque.add(new TreeNodeTemp(root, 1));
        while (!deque.isEmpty()) {
            max = 0;
            min = Long.MAX_VALUE;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNodeTemp pop = deque.pop();
                TreeNode treeNode = pop.treeNode;
                long number = pop.number;
                if (treeNode.left != null) {
                    deque.add(new TreeNodeTemp(treeNode.left, 2 * number));
                }
                if (treeNode.right != null) {
                    deque.add(new TreeNodeTemp(treeNode.right, 2 * number + 1));
                }
                max = Math.max(max, number);
                min = Math.min(min, number);
                System.out.println(max + "\t" + min);
            }
            res = Math.max(res, max - min + 1);
        }
        return (int) res;
    }
}

class TreeNodeTemp {
    TreeNode treeNode;
    long number;

    public TreeNodeTemp(TreeNode treeNode, long number) {
        this.treeNode = treeNode;
        this.number = number;
    }
}
