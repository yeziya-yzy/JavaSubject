package day93.exercises1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/17
 * 1302. 层数最深叶子节点的和
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> temp;
        queue.add(root);
        while (true) {
            res = 0;
            temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode pop = queue.pop();
                if (pop.left != null) {
                    temp.addLast(pop.left);
                }
                if (pop.right != null) {
                    temp.addLast(pop.right);
                }
                res += pop.val;
            }
            if (temp.isEmpty()) {
                break;
            }
            queue = temp;
        }
        return res;
    }
}
