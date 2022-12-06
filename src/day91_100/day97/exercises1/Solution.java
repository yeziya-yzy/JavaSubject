package day97.exercises1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/22
 * 655. 输出二叉树
 */
class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.right = treeNode4;
        List<List<String>> lists = new Solution().printTree(treeNode);
        for (List<String> list : lists) {
            for (String temp : list) {
                System.out.print(temp + "\t");
            }
            System.out.println();
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getH(root) - 1;
        int n = (int) Math.pow(2, h + 1) - 1;
        Deque<TreeNodeTemp> treeNodes = new ArrayDeque<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < h + 1; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("空");
            }
            res.add(row);
        }
        treeNodes.addLast(new TreeNodeTemp(root, 0, (n - 1) / 2));
        while (!treeNodes.isEmpty()) {
            TreeNodeTemp pop = treeNodes.pop();
            TreeNode treeNode = pop.treeNode;
            int r = pop.r;
            int l = pop.l;
            int pow = (int) Math.pow(2, h - r - 1);
            res.get(r).set(l, Integer.toString(treeNode.val));
            if (treeNode.left != null) {
                treeNodes.addLast(new TreeNodeTemp(treeNode.left, r + 1, l - pow));
            }
            if (treeNode.right != null) {
                treeNodes.addLast(new TreeNodeTemp(treeNode.right, r + 1, l + pow));
            }
        }
        return res;
    }

    private int getH(TreeNode root) {
        int res = 0;
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.addLast(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = treeNodes.pop();
                if (pop.left != null) {
                    treeNodes.addLast(pop.left);
                }
                if (pop.right != null) {
                    treeNodes.addLast(pop.right);
                }
            }
            res++;
        }
        return res;
    }
}

class TreeNodeTemp {
    TreeNode treeNode;
    int r;
    int l;

    public TreeNodeTemp(TreeNode treeNode, int r, int l) {
        this.treeNode = treeNode;
        this.r = r;
        this.l = l;
    }
}