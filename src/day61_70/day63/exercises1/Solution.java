package day63.exercises1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/22
 * 513. 找树左下角的值
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        int res = 0;
        while (treeNodes.size() != 0) {
            TreeNode pop = treeNodes.poll();
            if (pop.right != null) {
                treeNodes.add(pop.right);
            }
            if (pop.left != null) {
                treeNodes.add(pop.left);
            }
            res = pop.val;
        }
        return res;
    }
}
