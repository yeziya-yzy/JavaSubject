package day101_110.day108.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/3
 * 652. 寻找重复的子树
 */
class Solution {
    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtreesdfs(root);
        return new ArrayList<>(repeat);
    }

    public String findDuplicateSubtreesdfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(findDuplicateSubtreesdfs(node.left));
        sb.append(")(");
        sb.append(findDuplicateSubtreesdfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }
}