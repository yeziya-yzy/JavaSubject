package day80.exercises1;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/31
 * 1161. 最大层内元素和
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int res = 1;
        int sum = 0;
        int max = root.val;
        int count = 1;
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> temp;
        list.add(root);
        while (list.size() != 0) {
            temp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                sum += treeNode.val;
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            if (sum > max) {
                max = sum;
                res = count;
            }
            System.out.println(sum);
            list = temp;
            sum = 0;
            count++;
        }
        return res;
    }
}
