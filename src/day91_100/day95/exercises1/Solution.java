package day95.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/20
 * 654. 最大二叉树
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? new TreeNode(nums[0]) : new TreeNode(nums[1]);
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        int[] left = new int[index];
        System.arraycopy(nums, 0, left, 0, index);
        int[] right = new int[nums.length - index];
        for (int i = index + 1, j = 0; i < nums.length; i++, j++) {
            right[j] = nums[i];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = constructMaximumBinaryTree(left);
        treeNode.right = constructMaximumBinaryTree(right);
        return treeNode;
    }
}
