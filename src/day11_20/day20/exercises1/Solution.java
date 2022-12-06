package day20.exercises1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/1
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {2, 1, 4};
        TreeNode treeNode = new TreeNode(ints[0]);
        treeNode.left = new TreeNode(ints[1]);
        treeNode.right = new TreeNode(ints[2]);
        int[] ints2 = {1, 0, 3};
        TreeNode treeNode2 = new TreeNode(ints2[0]);
        treeNode2.left = new TreeNode(ints2[1]);
        treeNode2.right = new TreeNode(ints2[2]);
        List<Integer> allElements = new Solution().getAllElements(treeNode, treeNode2);
        allElements.forEach(System.out::println);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> integerListLeft = new ArrayList<>();
        List<Integer> integerListRight = new ArrayList<>();
        int indexLeft = 0;
        int indexRight = 0;
        Integer integerLeft;
        Integer integerRight;
        TreeNodeAdd(root1, integerListLeft);
        TreeNodeAdd(root2, integerListRight);
        while (indexLeft < integerListLeft.size() && indexRight < integerListRight.size()) {
            integerLeft = integerListLeft.get(indexLeft);
            integerRight = integerListRight.get(indexRight);
            if (integerLeft <= integerRight) {
                integerList.add(integerLeft);
                indexLeft++;
            } else {
                integerList.add(integerRight);
                indexRight++;
            }
        }
        while (indexLeft < integerListLeft.size()) {
            integerLeft = integerListLeft.get(indexLeft);
            integerList.add(integerLeft);
            indexLeft++;
        }
        while (indexRight < integerListRight.size()) {
            integerRight = integerListRight.get(indexRight);
            integerList.add(integerRight);
            indexRight++;
        }
        return integerList;
    }

    private void TreeNodeAdd(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        TreeNodeAdd(root.left, integers);
        integers.add(root.val);
        TreeNodeAdd(root.right, integers);
    }
}