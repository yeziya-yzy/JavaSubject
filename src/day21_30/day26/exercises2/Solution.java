package day26.exercises2;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/7
 */
class Solution {
    private List<Integer> arrayList = new ArrayList<>();

    // int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // if (root != null) {
        //     convertBST(root.right);
        //     sum += root.val;
        //     root.val = sum;
        //     convertBST(root.left);
        // }
        // return root;
        getAll(root, arrayList);
        getAllNumber(root);
        return root;
    }

    private void getAll(TreeNode root, List<Integer> arrayList) {
        if (root == null) {
            return;
        }
        getAll(root.left, arrayList);
        arrayList.add(root.val);
        getAll(root.right, arrayList);
    }

    private void getAllNumber(TreeNode root) {
        if (root == null) {
            return;
        }
        int temp = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) >= root.val) {
                temp = temp + arrayList.get(i);
            } else {
                break;
            }
        }
        root.val = temp;
        getAllNumber(root.left);
        getAllNumber(root.right);
    }
}
