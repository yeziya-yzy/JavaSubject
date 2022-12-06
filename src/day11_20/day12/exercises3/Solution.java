package day12.exercises3;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/23
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Solution {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k1 = (nums1.length + nums2.length + 1) / 2;
        int k2 = (nums1.length + nums2.length + 2) / 2;
        double to1 = getK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1);
        double to2 = getK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2);
        return (to1 + to2) / 2;
    }

    private double getK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (end1 - start1 > end2 - start2) {
            return getK(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (end1 - start1 + 1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(end1 - start1 + 1, k / 2) - 1;
        int j = start2 + Math.min(end2 - start2 + 1, k / 2) - 1;

        if (nums1[i] >= nums2[j]) {
            return getK(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getK(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}