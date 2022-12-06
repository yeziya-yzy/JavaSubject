package day9.exercises2;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/20
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
